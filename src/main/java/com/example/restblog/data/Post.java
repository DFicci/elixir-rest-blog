package com.example.restblog.data;


import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.*;






@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Post {


    @JsonIgnore
    private long id;
    private String title;
    private String content;


}
