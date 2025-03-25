package com.sprint.mvc.Dto;

public record LoginRep(
        boolean success,
        String token

) {
    public static LoginRep loginRep(boolean success, String token) {
        return new LoginRep(success, token );
    }
}
