package com.example.dmeo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; // Import Model class
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.dmeo.entity.Playlist;
import com.example.dmeo.entity.Song;
import com.example.dmeo.servies.PlayListService;
import com.example.dmeo.servies.SongService;

@Controller
public class PlayListController {

	@Autowired
	SongService songService;
	@Autowired
	PlayListService playListService;

	@GetMapping("/createPlayList")
	public String createPlayList(Model model) { // Corrected the parameter type to Model
		List<Song> songList = songService.fetchAllSong(); // Corrected method name to fetchAllSong
		model.addAttribute("songs", songList); // Corrected method name to addAttribute
		return "createPlayList";
	}

    @PostMapping("/addPlaylist")
    public String addPlaylist(@ModelAttribute Playlist playlist) {
        // Your logic to add the playlist
        playListService.addPlaylist(playlist);

        // Your logic to update the song table
        List<Song> songList = playlist.getSongss();
        for (Song s : songList) {
            s.getPlaylist().add(playlist);
            songService.update(s);
        }

        return "adminhome";
    }


}
