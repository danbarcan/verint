package com.example.verint.controllers;

import com.example.verint.repositories.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {

    @Autowired
    SongRepository songRepository;

    @GetMapping("/hello")
    public String authenticateUser() {
        songRepository.getPlaylistByPlaylistIdOrderByOrder(1L);
        return "hi from your test rest service";
    }
}
