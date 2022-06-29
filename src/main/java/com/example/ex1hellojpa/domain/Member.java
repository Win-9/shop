package com.example.ex1hellojpa.domain;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Member extends BaseEntity{
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "MEMBER_ID")
    private String name;


    @Embedded
    private Address address;

    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
