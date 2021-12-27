package com.project.sessionmanager.services;

import com.project.sessionmanager.models.User;
import com.project.sessionmanager.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
public class SigninService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    public String firstpage(){
        return "redirect:/products";
    }

    public String signin(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth == null || auth instanceof AnonymousAuthenticationToken) {
            return "login";
        }
        return "redirect:/products";
    }

    public String registration(){
        return "registration";
    }

    public String logoutPage(HttpServletRequest request, HttpServletResponse response, RedirectAttributes redirectAttributes) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }

        String msg="You have logged out successfully!";
        redirectAttributes.addFlashAttribute("msg", msg);
        redirectAttributes.addFlashAttribute("alertClass", "alert-success");
        return "redirect:/signin";
    }

    public String doregistration(HttpServletRequest req, RedirectAttributes redirectAttributes){
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        String emailid=req.getParameter("emailid");
        String role="ROLE_NORMAL";

        String ifseller=req.getParameter("ifseller");

        if(username.length() < 4){
            String msg="Username length should be greater than 4";
            redirectAttributes.addFlashAttribute("msg", msg);
            redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
            return "redirect:/registration";
        }
        if(password.length() < 4){
            String msg="Password length should be greater than 4";
            redirectAttributes.addFlashAttribute("msg", msg);
            redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
            return "redirect:/registration";
        }
        User u = this.userRepository.findByUsername(username);
        System.out.println(u);
        if(u!=null){
            String msg="please try another username";
            redirectAttributes.addFlashAttribute("msg", msg);
            redirectAttributes.addFlashAttribute("alertClass", "alert-danger");
            return "redirect:/registration";
        }

        User user = new User(username,this.bCryptPasswordEncoder.encode(password),emailid, role);

        if(ifseller!=null){
            user.setRole("ROLE_SELLER");
            user.setStatus("INACTIVE");
        }

        this.userRepository.save(user);
        String msg="You have signed up successfully!";
        redirectAttributes.addFlashAttribute("msg", msg);
        redirectAttributes.addFlashAttribute("alertClass", "alert-success");
        return "redirect:/signin";

    }
}
