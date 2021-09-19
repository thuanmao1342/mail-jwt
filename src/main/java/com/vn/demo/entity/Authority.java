package com.vn.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "authorities")
public class Authority implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "roleid")
    private Role role;
    @ManyToOne
    @JoinColumn(name = "username")
    private User user;
}
