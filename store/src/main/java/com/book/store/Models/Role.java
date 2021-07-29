package com.book.store.Models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@NoArgsConstructor
@Setter
@Getter
@Entity
@Table( name = "roles" )
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String role;

    @ManyToMany( mappedBy = "roles")
    private Set<User> users = new HashSet<User>();

    public Role(String role) {
        this.role = role;
    }
}