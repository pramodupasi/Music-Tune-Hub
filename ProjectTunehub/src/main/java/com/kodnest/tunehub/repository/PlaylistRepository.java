package com.kodnest.tunehub.repository;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.kodnest.tunehub.entity.Playlist;

public interface PlaylistRepository extends JpaRepositoryImplementation<Playlist, Integer> {

}
