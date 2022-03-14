package com.ados.socialnetwork.domain.request;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class PostRequest {
    private String desc;
    private MultipartFile[] images;
}
