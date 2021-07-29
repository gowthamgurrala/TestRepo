package com.Gtech.Music_Album.Dao;

import com.Gtech.Music_Album.Entity.Gener;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "gener",path = "gener")
public interface ArtistRepository extends JpaRepository<Gener,Integer> {
}
