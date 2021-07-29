package com.Gtech.Music_Album.Entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Album_table")
@Setter
@Getter
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "gener_id", nullable = false)
    private Gener gener;


    private String imageUrl;
    @CreationTimestamp
    private Date date;

}
