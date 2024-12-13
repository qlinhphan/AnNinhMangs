package com.example.springWEB.domain;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String fullName;
    private String address;
    private int born;
    private String email;
    private String password;

    // user 1 -> n book
    @OneToMany(mappedBy = "user")
    private List<Book> book;

    // user n -> 1 role
    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    public String DevToString() {
        return "User{" + "id=" + id + ", fullName=" + fullName + ", address=" + address + ", born=" + born + ", role="
                + role.getName() + '}';
    }

}
