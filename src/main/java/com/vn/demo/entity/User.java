package com.vn.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@SuppressWarnings("serial")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User implements Serializable{
    @Id
    private String username;
    private String password;
    private String name;
    private String email;
    @JsonIgnore
    @OneToMany(mappedBy = "user")
    List<Authority> authority;
}
