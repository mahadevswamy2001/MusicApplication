package com.example.dmeo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.dmeo.entity.Song;
import com.example.dmeo.servies.SongService;

@Controller
public class SongController {
	@Autowired
	SongService service;

	@PostMapping("/addSong")
	public String addSong(@ModelAttribute Song song) {
		boolean songStatus = service.songExist(song.getName());
		if (songStatus == false) {
			service.addSong(song);
			System.out.println("Song Added succesfully");

		} else {
			System.out.println("Song is alredy exist");
		}
		return "adminHome";

	}

	@GetMapping("/viewSongs")
	// model is used to transfer the data from backed to the front end
	public String viewSongs(Model model) {
		List<Song> songsList = service.fetchAllSong();
		System.out.println(songsList);

		model.addAttribute("songs", songsList);
		return "displaySongs";
	}
	

	@GetMapping("/playSongs")
	// model is used to transfer the data from backed to the front end
	public String playSongs(Model model) {
		boolean premiumUsers=false;
		
		if(premiumUsers==true) {
			List<Song> songsList = service.fetchAllSong();
			System.out.println(songsList);

			model.addAttribute("songs", songsList);
			return "displaySongs";
	
		}else {
			return "makePayment";
		}
	}
}
