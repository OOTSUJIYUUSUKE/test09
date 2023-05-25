package com.example.MyBatisDemo.service;

import com.example.MyBatisDemo.entity.AnimeMoviesForm;
import org.springframework.validation.BindingResult;

import java.util.List;

public interface AnimeMoviesService {
    List<AnimeMoviesForm> findAll();
    AnimeMoviesForm findById(int id);
    List<AnimeMoviesForm> findByPublishedYear(String publishedYear);

    AnimeMoviesForm create(AnimeMoviesForm conversionAnimeMovies, BindingResult bindingResult);
    void update(int id, AnimeMoviesForm conversionAnimeMovies, BindingResult bindingResult);
    void delete(int id);
}
