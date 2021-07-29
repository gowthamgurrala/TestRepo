package com.Gtech.Music_Album.Dao;

import com.Gtech.Music_Album.Entity.Album;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestParam;

public interface AlbumRepository  extends JpaRepository<Album,Integer> {
//    Page<Album> findByCategoryId(@RequestParam("id") Long id, Pageable pageable);
//
//    Page<Album> findByNameContaining(@RequestParam("name") String name, Pageable pageable);
}
