package com.ados.socialnetwork.service;

import com.ados.socialnetwork.domain.response.base.BaseResponse;
import org.springframework.web.multipart.MultipartFile;

public interface ImageService {
    BaseResponse uploadImagesForPost(MultipartFile[] files, Long postId);
}
