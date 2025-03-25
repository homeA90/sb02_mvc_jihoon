package com.sprint.mvc.service;

import com.sprint.mvc.Dto.SignUpRep;
import com.sprint.mvc.Dto.SignUpReq;
import com.sprint.mvc.entity.User;

public interface UserService {

    SignUpRep signUp(SignUpReq signUpReq);
}
