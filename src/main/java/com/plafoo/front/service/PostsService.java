package com.plafoo.front.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.plafoo.front.domain.posts.PostsRepository;
import com.plafoo.front.dto.posts.PostsSaveRequestDto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class PostsService {
    private PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto dto){
        return postsRepository.save(dto.toEntity()).getId();
    }
}