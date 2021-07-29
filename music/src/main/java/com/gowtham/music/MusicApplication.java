package com.gowtham.music;

import com.gowtham.music.Entities.Album;
import com.gowtham.music.Entities.Artist;

import com.gowtham.music.Entities.Title;
import com.gowtham.music.Repositories.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

@SpringBootApplication
public class MusicApplication implements CommandLineRunner {
    @Autowired
    private final AlbumRepository albumRepository;

    public MusicApplication(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }


    public static void main(String[] args) {
        SpringApplication.run(MusicApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Date d = new Date();

        Album dammu = new Album("Dammu", "hipop", d);
        Title f1 = new Title("Sound of vel");
        Title f2 = new Title("O Lilly");
        Title f3 = new Title("Roolar");
        Title f4 = new Title("Raja Vasi Reddy");
        Title f5 = new Title("Vastuea Bagundea");
        Title f6 = new Title("Dhammu");
        dammu.addTitle(f1);
        dammu.addTitle(f2);
        dammu.addTitle(f3);
        dammu.addTitle(f4);
        dammu.addTitle(f5);
        dammu.addTitle(f6);


        Album vakeel = new Album("Vakeela Saab", "Rock", d);
        Title v1 = new Title("Maguava");
        Title v2 = new Title("O kashnam");
        Title v3 = new Title("Intro");

        vakeel.addTitle(v1);
        vakeel.addTitle(v2);
        vakeel.addTitle(v3);

        Artist fa1 = new Artist("Baba Shegal", "Singer");
        Artist fa2 = new Artist("Balu ", "Singer");
        Artist fa3 = new Artist("Shreya Goshal ", "Singer");

        Artist va1 = new Artist("sid sriram", "Singer");
        Artist va2 = new Artist("Shanker Mahadevan ", "Singer");
        Artist va3 = new Artist("SS Thaman ", "Director");

          
        vakeel.addArtist(va1);
        vakeel.addArtist(va2);
        vakeel.addArtist(va3);


        dammu.addArtist(fa1);
        dammu.addArtist(fa2);
        dammu.addArtist(fa3);


        albumRepository.save(dammu);
        albumRepository.save(vakeel);


    }
}
