package com.example.dmeo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.dmeo.entity.Song;

public interface SongRepository extends JpaRepository<Song, Integer> {

	public	Song findByName(String name);

}
