package com.marcoantonio.workshopmongo.service;

import com.marcoantonio.workshopmongo.domain.User;
import com.marcoantonio.workshopmongo.repository.UserRepository;
import com.marcoantonio.workshopmongo.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public List<User> findAll(){
        return repo.findAll();
    }

    public User findById(String id) {
        User user = repo.findOne(id);
        if(user == null) {
            throw new ObjectNotFoundException("Objeto não encontrado!!!");
        }
        return user;
    }

}
