package com.am.user.controllers;

import com.am.user.dtos.UserRecordDTO;
import com.am.user.models.UserModel;
import com.am.user.services.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/users")
public class UserController {

    final UserService userService;

    public UserController(final UserService userService) {
        this.userService = userService;
    }


    @PostMapping
    public ResponseEntity<Object> saveUser(@RequestBody @Valid UserRecordDTO userRecordDTO) {

        final UserModel userModel = new UserModel();
        BeanUtils.copyProperties(userRecordDTO, userModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(userModel));
    }
}
