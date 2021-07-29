package com.gowtham.music.Repositories;


import com.gowtham.music.Entities.Title;
import org.springframework.data.jpa.repository.JpaRepository;


public interface TitleRepository extends JpaRepository<Title,Long> {

}
