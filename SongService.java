package com.example.dmeo.servies;

import java.util.List;

import com.example.dmeo.entity.Song;

public interface SongService {

public	void addSong(Song song);
public	void update(Song song);

public List<Song> fetchAllSong();


public boolean songExist(String name);




}
