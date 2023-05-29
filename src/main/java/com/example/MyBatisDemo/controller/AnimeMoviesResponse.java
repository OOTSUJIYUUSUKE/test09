package com.example.MyBatisDemo.controller;

import com.example.MyBatisDemo.entity.AnimeMoviesForm;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class AnimeMoviesResponse {
    private final String title;

    public AnimeMoviesResponse(AnimeMoviesForm title) {
        this.title = title.getTitle();
    }
}
