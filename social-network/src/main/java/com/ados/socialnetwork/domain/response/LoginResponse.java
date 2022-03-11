package com.ados.socialnetwork.domain.response;

import com.ados.socialnetwork.domain.response.base.BaseResponse;
import lombok.Data;

@Data
public class LoginResponse extends BaseResponse {
    private String email;
    private String token;
}
