package com.sprint.mvc.Dto;

public record SignUpReq(
        String userId,
        String password,
        String email,
        String nickname
) {

}
