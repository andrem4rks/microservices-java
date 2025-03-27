package com.am.user.services;

import com.am.user.exceptions.user.DuplicatedUserEmailException;
import com.am.user.models.UserModel;
import com.am.user.models.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    final UserRepository userRepository;

    public UserService(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public UserModel save(UserModel userModel) {

        if(userRepository.findByEmail(userModel.getEmail()).isPresent())
            throw new DuplicatedUserEmailException("Já existe um usuário com esse email" + userModel.getEmail());

        return userRepository.save(userModel);
    }
}
