package com.marcoantonio.workshopmongo.service;

import com.marcoantonio.workshopmongo.domain.Post;
import com.marcoantonio.workshopmongo.domain.User;
import com.marcoantonio.workshopmongo.dto.UserDTO;
import com.marcoantonio.workshopmongo.repository.PostRepository;
import com.marcoantonio.workshopmongo.repository.UserRepository;
import com.marcoantonio.workshopmongo.service.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repo;

    public List<Post> findAll(){
        return repo.findAll();
    }

    public Post findById(String id) {
        Optional<Post> userOptional = repo.findById(id);
        return userOptional.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado!!!"));
    }

}
