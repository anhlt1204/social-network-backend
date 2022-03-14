package com.ados.socialnetwork.controller;

import com.ados.socialnetwork.domain.request.PostRequest;
import com.ados.socialnetwork.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("")
    public ResponseEntity<?> createPost(PostRequest request) {
        return ResponseEntity.ok(postService.createPost(request));
    }

}
