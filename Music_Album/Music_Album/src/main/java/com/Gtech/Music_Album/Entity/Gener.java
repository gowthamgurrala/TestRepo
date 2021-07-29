package com.Gtech.Music_Album.Entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Setter
@Getter
@Entity
public class Gener {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "gener_name")
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "gener")
    private Set<Album> albums;

}


