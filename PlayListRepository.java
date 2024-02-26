package com.example.dmeo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.dmeo.entity.Playlist;

public interface PlayListRepository extends JpaRepository<Playlist, Integer> {

}
