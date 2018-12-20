package com.plafoo.front.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.plafoo.front.service.PostsService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class WebController {

	private PostsService postsService;
	
    @GetMapping("/")
    public String main(Model model) {
    	/*
    	model.addAttribute("posts", postsService.findAllDesc());
    	
        return "main";
        */
    	
    	return "index";
    }
    
    
//    @PostMapping("/map/{lat}/{lng}")
//    public String map(@PathVariable("lat") String lat,@PathVariable("lng") String lng, Model model) { 
//    	
//    	model.addAttribute("lat",lat);
//    	model.addAttribute("lng",lng);
//    	
//    	return "map";
//    }
    
    
    @GetMapping("/map")
    public String map() { 
    	return "map";
    }
}