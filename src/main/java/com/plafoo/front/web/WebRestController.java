package com.plafoo.front.web;

import java.util.Arrays;

import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.plafoo.front.domain.posts.PostsRepository;
import com.plafoo.front.dto.posts.PostsSaveRequestDto;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class WebRestController {

	private PostsRepository postsRepository;
	private Environment env;
	
    @GetMapping("/profile")
    public String getProfile () {
        return Arrays.stream(env.getActiveProfiles())
                .findFirst()
                .orElse("");
    }
    
	
    @GetMapping("/hello")
    public String hello() {
        return "HelloWorld";
    }
    
    @PostMapping("/posts")
    public void savePosts(@RequestBody PostsSaveRequestDto dto){
        postsRepository.save(dto.toEntity());
    }
}