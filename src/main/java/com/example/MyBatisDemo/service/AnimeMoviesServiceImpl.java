package com.example.MyBatisDemo.service;

import com.example.MyBatisDemo.entity.AnimeMoviesForm;
import com.example.MyBatisDemo.exception.ResourceNotFoundException;
import com.example.MyBatisDemo.mapper.AnimeMoviesMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class AnimeMoviesServiceImpl implements AnimeMoviesService {
    final private AnimeMoviesMapper animeMoviesMapper;

    @Override
    public List<AnimeMoviesForm> findAll() {
        return animeMoviesMapper.findAll();
    }
    @Override
    public List<AnimeMoviesForm> findByPublishedYear(String publishedYear){
            return this.animeMoviesMapper.findByPublishedYear(publishedYear);
    }
    @Override
    public AnimeMoviesForm findById(int id) {
        return this.animeMoviesMapper.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("resource not found"));
    }
    @Override
    public AnimeMoviesForm create(AnimeMoviesForm conversionAnimeMovies, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ResourceNotFoundException("not be validated");
        }
        animeMoviesMapper.insert(conversionAnimeMovies);
        return conversionAnimeMovies;
    }
    @Override
    public void update(int id, AnimeMoviesForm conversionAnimeMovies, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new ResourceNotFoundException("not be validated");
        }
        animeMoviesMapper.update(id, conversionAnimeMovies);
    }
    @Override
    public void delete(int id) {
        animeMoviesMapper.delete(id);
    }
}
