package com.marcoantonio.workshopmongo.resources;

import com.marcoantonio.workshopmongo.domain.Post;
import com.marcoantonio.workshopmongo.domain.User;
import com.marcoantonio.workshopmongo.dto.UserDTO;
import com.marcoantonio.workshopmongo.resources.util.URL;
import com.marcoantonio.workshopmongo.service.PostService;
import com.marcoantonio.workshopmongo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {

    @Autowired
    private PostService service;

    @RequestMapping(value="/{id}",method=RequestMethod.GET)
    public ResponseEntity<Post> findById(@PathVariable String id) {
        Post obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }


    @RequestMapping(value="/tietlesearch",method=RequestMethod.GET)
    public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {
            text = URL.decodeParam(text);
            List<Post> list = service.findByTitle(text);
            return ResponseEntity.ok().body(list);
    }



}
