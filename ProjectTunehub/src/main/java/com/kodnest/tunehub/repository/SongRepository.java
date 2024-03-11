package com.kodnest.tunehub.repository;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.kodnest.tunehub.entity.Song;

public interface SongRepository extends JpaRepositoryImplementation<Song, Integer>{

	public Song findByName(String name);

}
