package com.example.MyBatisDemo.controller;

import com.example.MyBatisDemo.entity.AnimeMoviesForm;
import com.example.MyBatisDemo.service.AnimeMoviesService;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RequestMapping("/animeMovies")
@RestController
public class AnimeMoviesController {
    private final AnimeMoviesService animeMoviesService;

    public AnimeMoviesController(AnimeMoviesService animeMoviesService) {
        this.animeMoviesService = animeMoviesService;
    }

    @GetMapping("/All")
    public List<AnimeMoviesResponse> findAll() {
        return animeMoviesService.findAll().stream().map(AnimeMoviesResponse::new).toList();
    }
    @GetMapping("/id")
    public AnimeMoviesResponse findById(@RequestParam(value = "id") int id) {
        AnimeMoviesForm animeMovie = animeMoviesService.findById(id);
        AnimeMoviesResponse conversionAnimeMovies = new AnimeMoviesResponse(animeMovie);
        return conversionAnimeMovies;
    }
    @GetMapping("/publishedYear")
    public List<AnimeMoviesResponse> findByPublishedYear(@RequestParam(value = "publishedYear") String publishedYear) {
        List<AnimeMoviesForm> animeMovies = animeMoviesService.findByPublishedYear(publishedYear);
        return animeMovies.stream().map(AnimeMoviesResponse::new).toList();
    }
    @PostMapping()
    public ResponseEntity<Map<String, String>> createAnimeMovies(@RequestBody @Validated AnimeMoviesForm NewAnimeMovies, BindingResult bindingResult, UriComponentsBuilder uriComponentsBuilder) {
        ModelMapper modelMapper = new ModelMapper();
        AnimeMoviesForm conversionAnimeMovies = modelMapper.map(NewAnimeMovies, AnimeMoviesForm.class);
        AnimeMoviesForm animeMovies = animeMoviesService.create(conversionAnimeMovies, bindingResult);
        URI url = uriComponentsBuilder.path("/animeMovies/id/" + animeMovies.getId())
                .build()
                .toUri();
        return ResponseEntity.created(url).body(Map.of("message", "new anime movie successfully create"));
    }
    @PatchMapping("/id/{id}")
    public ResponseEntity<Map<String, String>> patchAnimeMovies(@PathVariable("id")int id, @RequestBody @Validated AnimeMoviesForm NewAnimeMovies, BindingResult bindingResult, UriComponentsBuilder uriComponentsBuilder) {
        ModelMapper modelMapper = new ModelMapper();
        AnimeMoviesForm conversionAnimeMovies = modelMapper.map(NewAnimeMovies, AnimeMoviesForm.class);
        animeMoviesService.update(id, conversionAnimeMovies, bindingResult);
        URI url = uriComponentsBuilder.path("/animeMovies/id/" + id)
                .build()
                .toUri();
        return ResponseEntity.created(url).body(Map.of("message", "the anime movie successfully update"));
    }
    @DeleteMapping("/id/{id}")
    public ResponseEntity<Map<String, String>> deleteAnimeMovies(@PathVariable("id")int id) {
        animeMoviesService.delete(id);
        return ResponseEntity.ok(Map.of("message", "the anime movie successfully delete"));
    }
}
