package com.gowtham.music.Repositories;


import com.gowtham.music.Entities.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "album", path = "album")
public interface AlbumRepository extends JpaRepository<Album, Long> {
    List<Album> findByNameContaining(@RequestParam("name") String name);
}
