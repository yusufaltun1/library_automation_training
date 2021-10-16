package com.library.service;

import com.library.dto.CreateUserForm;
import com.library.entity.UserEntity;
import com.library.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class UserService
{
    @Autowired
    private UserRepository userRepository;

    public List<UserEntity> getAll()
    {
        Iterator<UserEntity> it = userRepository.findAll().iterator();
        List<UserEntity> users = new ArrayList<>();
        it.forEachRemaining(users::add);

        return users;
    }

    public void createUser(CreateUserForm form)
    {
        UserEntity userEntity = new UserEntity();
        userEntity.setName(form.getName());
        userEntity.setLastName(form.getLastName());

        userRepository.save(userEntity);
    }
}
