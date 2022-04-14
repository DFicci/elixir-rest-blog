package com.example.restblog.web;

import com.example.restblog.data.Post;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@CrossOrigin
@RestController
@RequestMapping(value = "/api/posts", headers = "Accept=application/json")
public class PostController {

    @GetMapping
    private List<Post> getPosts() {
        List<Post> posts = new ArrayList<>();
        posts.add(new Post(1L, "post 1", "blah"));
        posts.add(new Post(2L, "post 2", "blah,blah"));
        posts.add(new Post(3L, "post 3", "blah,blah,blah"));
        return posts;
    }

    @GetMapping("{postID}")
    public Post getById(@PathVariable Long postID){
        Post post = new Post(postID, "Post" + postID, "blah blah blah");
        return post;
    }

   @PostMapping
    private void createPost(@RequestBody Post newPost){
        System.out.println("Ready to add post." + newPost);
   }

   @PutMapping("{id}")
    private void updatePost(@PathVariable Long id, @RequestBody Post newPost){
       System.out.println("Ready to update post." + id + newPost);
   }

   @DeleteMapping("{postId}")
    private void deletePost(@PathVariable Long postId){
       System.out.println("ready to add post." + postId);
   }


}
