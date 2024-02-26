package com.example.dmeo.servies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dmeo.entity.Playlist;
import com.example.dmeo.repository.PlayListRepository;

@Service
public class PlayListServiceImp implements PlayListService {
	@Autowired
	PlayListRepository repo;

	@Override
	public void addPlaylist(Playlist playlist) {
		repo.save(playlist);
	}

}
