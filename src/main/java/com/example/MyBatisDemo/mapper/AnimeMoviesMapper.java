package com.example.MyBatisDemo.mapper;

import com.example.MyBatisDemo.entity.AnimeMoviesForm;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

@Mapper
public interface AnimeMoviesMapper {
    List<AnimeMoviesForm> findAll();
    Optional<AnimeMoviesForm> findById(int id);
    List<AnimeMoviesForm> findByPublishedYear(String publishedYear);
    int insert(AnimeMoviesForm conversionAnimeMovies);

    void update(int id, AnimeMoviesForm conversionAnimeMovies);

    void delete(int id);
}
