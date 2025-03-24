package com.sprint.mvc.service;

import com.sprint.mvc.Dto.SignUpReq;
import com.sprint.mvc.entity.User;

public interface RegisterService {

    User signUp(SignUpReq signUpReq);
}
