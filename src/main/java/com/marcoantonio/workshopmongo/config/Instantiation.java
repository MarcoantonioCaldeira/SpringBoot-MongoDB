package com.marcoantonio.workshopmongo.config;

import com.marcoantonio.workshopmongo.domain.Post;
import com.marcoantonio.workshopmongo.domain.User;
import com.marcoantonio.workshopmongo.dto.AuthorDTO;
import com.marcoantonio.workshopmongo.repository.PostRepository;
import com.marcoantonio.workshopmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;
import java.util.TimeZone;


@Configuration
public class Instantiation implements CommandLineRunner{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PostRepository postRepository;

    @Override
    public void run(String... arg0) throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
        
        userRepository.deleteAll();
        postRepository.deleteAll();

        User maria = new User(null, "Maria Brown", "maria@gmail.com");
        User alex = new User(null, "Alex Green", "alex@gmail.com");
        User bob = new User(null, "Bob Grey", "bob@gmail.com");

        List<User> users = Arrays.asList(maria, alex, bob);
        userRepository.saveAll(users);

        Post post1 = new Post(null, sdf.parse("21/02/2024"), "Partiu viagem", "Vou viajar para Belo Horizonte", new AuthorDTO(maria));
        Post post2 = new Post(null, sdf.parse("21/02/2024"), "Partiu viagem", "Vou viajar para Belo Horizonte", new AuthorDTO(bob));

        List<Post> posts = Arrays.asList(post1, post2);
        postRepository.saveAll(posts);

        maria.getPosts().addAll(Arrays.asList(post1, post2));
        userRepository.save(maria);

    }
}
