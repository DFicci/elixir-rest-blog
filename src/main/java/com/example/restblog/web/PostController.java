package com.example.restblog.web;

import com.example.restblog.data.Post;
import com.example.restblog.data.PostsRepository;
import com.example.restblog.data.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping(value = "/api/posts", headers = "Accept=application/json")
public class PostController {
private PostsRepository postsRepository;
private UserRepository userRepository;

    public PostController(PostsRepository postsRepository, UserRepository userRepository) {
        this.postsRepository = postsRepository;
        this.userRepository = userRepository;
    }

    @GetMapping
    private List<Post> getPosts() {
        List<Post> posts = new ArrayList<>();
        return posts;
    }

    @GetMapping("{postID}")
    public Optional<Post> getById(@PathVariable Long postID) {
        return postsRepository.findById(postID);
    }

    @PostMapping
    private void createPost(@RequestBody Post newPost) {
        newPost.setAuthor(userRepository.getById(1L));
        System.out.println(newPost);
        postsRepository.save(newPost);
        System.out.println("Ready to add post." + newPost);
    }

    @PutMapping("{id}")
    private void updatePost(@PathVariable Long id, @RequestBody Post newPost) {
        System.out.println("Ready to update post." + id + newPost);
    }

    @DeleteMapping("{postId}")
    private void deletePost(@PathVariable Long postId) {
        System.out.println("ready to delete post." + postId);
    }


}
