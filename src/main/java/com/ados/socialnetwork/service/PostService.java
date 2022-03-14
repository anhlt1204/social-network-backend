package com.ados.socialnetwork.service;

import com.ados.socialnetwork.domain.request.PostRequest;
import com.ados.socialnetwork.domain.response.base.BaseResponse;

public interface PostService {
    BaseResponse createPost (PostRequest request);
}
