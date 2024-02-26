package com.example.dmeo.servies;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dmeo.entity.Song;
import com.example.dmeo.repository.SongRepository;

@Service
public class SongServiceimplementation implements SongService {

	@Autowired
	SongRepository repo;

	@Override
	public void addSong(Song song) {
		repo.save(song);
	}

	@Override
	public List<Song> fetchAllSong() {
		return repo.findAll();
	}

	@Override
	public boolean songExist(String name) {
		Song song = repo.findByName(name);
		if (song == null) {
			return false;
		} else {
			return true;
		}

	}

	@Override
	public void update(Song song) {
		repo.save(song);
	}
}
