package com.ados.socialnetwork.service.impl;

import com.ados.socialnetwork.domain.entity.Image;
import com.ados.socialnetwork.domain.entity.Post;
import com.ados.socialnetwork.domain.response.base.BaseResponse;
import com.ados.socialnetwork.domain.response.base.GetArrayResponse;
import com.ados.socialnetwork.repository.ImageRepo;
import com.ados.socialnetwork.repository.PostRepo;
import com.ados.socialnetwork.service.BaseService;
import com.ados.socialnetwork.service.ImageService;
import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ImageServiceImpl extends BaseService implements ImageService {

    @Autowired
    private Cloudinary cloudinary;

    @Autowired
    private ImageRepo imageRepo;

    @Autowired
    private PostRepo postRepo;

    @Override
    public BaseResponse uploadImagesForPost(MultipartFile[] files, Long postId) {
        GetArrayResponse<Image> response = new GetArrayResponse<>();

        try {
            Post post = null;
            if (postId != null) {
                Optional<Post> postOptional = postRepo.findById(postId);
                if (postOptional.isPresent()) {
                    post = postOptional.get();
                }
            }

            List<Image> images = new ArrayList<>();

            for (MultipartFile file : files) {
                Image image = new Image();
                Map<?, ?> cloudinaryMap = cloudinary.uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
                image.setUrl(cloudinaryMap.get("secure_url").toString());
                image.setPost(post);
                images.add(image);
            }

            imageRepo.saveAll(images);

            if (post != null) {
                post.setImages(images);
                postRepo.save(post);
            }

            response.setRows(images);
            response.setTotal(images.size());
            response.setSuccess();

        } catch (Exception e) {
            log.error("Ex: {}", e);
        }

        return response;
    }
}
