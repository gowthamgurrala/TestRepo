package com.gowtham.music.Entities;

import lombok.*;

import javax.persistence.*;
import java.util.*;


@Data
@NoArgsConstructor
@Entity
@Table(name = "Album")
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String gener;


    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "album_id")
    private List<Title> titles;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(
            name = "album_artist",
            joinColumns = @JoinColumn(name = "album_id"),
            inverseJoinColumns = @JoinColumn(name = "artist_id")
    )
    private List<Artist> artistList;

    private Date date;

    public Album(String name, String gener, Date date) {
        this.name = name;
        this.gener = gener;
        this.date = date;
    }

    public void addTitle(Title theTitle) {
        if (titles == null) {
            titles = new ArrayList<>();
        }
        titles.add(theTitle);
    }

    public void addArtist(Artist theartist) {
        if (artistList == null) {
            artistList = new ArrayList<>();
        }
        artistList.add(theartist);
    }


}

