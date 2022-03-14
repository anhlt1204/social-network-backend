package com.ados.socialnetwork.service.impl;

import com.ados.socialnetwork.domain.entity.Post;
import com.ados.socialnetwork.domain.request.PostRequest;
import com.ados.socialnetwork.domain.response.base.BaseResponse;
import com.ados.socialnetwork.domain.response.base.GetSingleResponse;
import com.ados.socialnetwork.repository.PostRepo;
import com.ados.socialnetwork.service.BaseService;
import com.ados.socialnetwork.service.ImageService;
import com.ados.socialnetwork.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl extends BaseService implements PostService {

    @Autowired
    private PostRepo postRepo;

    @Autowired
    private ImageService imageService;

    @Override
    public BaseResponse createPost(PostRequest request) {

        GetSingleResponse<Post> response = new GetSingleResponse<>();

        try {

            Post post = new Post();
            post.setDescription(request.getDesc());

            postRepo.save(post);
            imageService.uploadImagesForPost(request.getImages(), post.getId());

            response.setItem(post);

        } catch (Exception e) {
            log.error("Ex: {}", e);
        }

        return response;

    }
}
