package com.gowtham.music.Entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@ToString
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "TitleMaster")
public class Title {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title_name;

    @OneToMany(mappedBy="title",
            cascade= {CascadeType.PERSIST, CascadeType.MERGE,
                    CascadeType.DETACH, CascadeType.REFRESH})
    private List<Artist> artists;


    public Title(String title_name) {
        this.title_name = title_name;
    }

    public void add(Artist tempCourse) {

        if (artists == null) {
            artists = new ArrayList<>();
        }

        artists.add(tempCourse);

        tempCourse.setTitle(this);
    }


}
