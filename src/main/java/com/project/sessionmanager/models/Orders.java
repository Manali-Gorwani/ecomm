package com.project.sessionmanager.models;


import javax.persistence.*;
import java.util.List;

@Entity
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    //@JoinColumn(name = "user.username")
    String username;

    Integer totalAmount;
    String address;
    Integer noOfItems;

/*
    @OneToMany(targetEntity = ItemMapping.class,cascade = CascadeType.ALL)
    @JoinColumn(name ="itemidmapping",referencedColumnName = "items")
    private List<Integer> items;

    public List<Integer> getItems() {
        return items;
    }

    public void setItems(List<Integer> items) {
        this.items = items;
    }
*/

    public Integer getNoOfItems() {
        return noOfItems;
    }

    public void setNoOfItems(Integer noOfItems) {
        this.noOfItems = noOfItems;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Orders(){}
    public Orders(String username, Integer totalAmount, String address,Integer noOfItems) {

        this.username = username;
        this.totalAmount = totalAmount;
        this.address = address;
        this.noOfItems = noOfItems;
    }



}
