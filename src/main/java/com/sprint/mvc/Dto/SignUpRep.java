package com.sprint.mvc.Dto;

public record SignUpRep(
        boolean success,
        String message
) {
    public static SignUpRep signUpReq(boolean success, String message) {
        return new SignUpRep(success, message);
    }
}
