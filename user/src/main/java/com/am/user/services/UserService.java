package com.am.user.services;

import com.am.user.models.UserModel;
import com.am.user.models.UserRepository;
import com.am.user.producer.UserProducer;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    final UserRepository userRepository;
    final UserProducer userProducer;

    public UserService(final UserRepository userRepository, final UserProducer userProducer) {
        this.userRepository = userRepository;
        this.userProducer = userProducer;
    }

    @Transactional
    public UserModel save(UserModel userModel) {
        if(userRepository.findByEmail(userModel.getEmail()).isPresent())
            throw new DuplicateKeyException("Já existe um usuário com esse email" + userModel.getEmail());

        UserModel userPersistedModel = userRepository.save(userModel);
        userProducer.publishMessageEmail(userPersistedModel);

        return userPersistedModel;
    }
}
