package com.example.MyBatisDemo.controller;

import com.example.MyBatisDemo.entity.AnimeMoviesForm;
import com.example.MyBatisDemo.exceptionHandler.BadRequestException;
import com.example.MyBatisDemo.exceptionHandler.ResourceNotFoundException;
import com.example.MyBatisDemo.service.AnimeMoviesService;
import jakarta.servlet.http.HttpServletRequest;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class AnimeMoviesController {
    private final AnimeMoviesService animeMoviesService;

    public AnimeMoviesController(AnimeMoviesService animeMoviesService) {
        this.animeMoviesService = animeMoviesService;
    }
    @ExceptionHandler(value = BadRequestException.class)
    public ResponseEntity<Map<String, String>> handleBadRequest(BadRequestException e, HttpServletRequest request) {
        Map<String, String> body = Map.of(
                "timestamp", ZonedDateTime.now().toString(),
                "status", String.valueOf(HttpStatus.BAD_REQUEST.value()),
                "error", HttpStatus.BAD_REQUEST.getReasonPhrase(),
                "message", e.getMessage(),
                "path", request.getRequestURI()
        );
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = ResourceNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleNotResourceFound(ResourceNotFoundException e, HttpServletRequest request) {
        Map<String, String> body = Map.of(
                "timestamp", ZonedDateTime.now().toString(),
                "status", String.valueOf(HttpStatus.NOT_FOUND.value()),
                "error", HttpStatus.NOT_FOUND.getReasonPhrase(),
                "message", e.getMessage(),
                "path", request.getRequestURI()
        );
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }
    @GetMapping("/animeMoviesAll")
    public List<AnimeMoviesResponse> findAll() {
        return animeMoviesService.findAll().stream().map(AnimeMoviesResponse::new).toList();
    }
    @GetMapping("/animeMoviesId")
    public List<AnimeMoviesResponse> findById(@RequestParam(value = "id") int id) {
        Optional<AnimeMoviesForm> animeMovies = Optional.ofNullable(animeMoviesService.findById(id));
        return animeMovies.stream().map(AnimeMoviesResponse::new).toList();
    }
    @GetMapping("/animeMoviesPublishedYear")
    public List<AnimeMoviesResponse> findByPublishedYear(@RequestParam(value = "publishedYear") String publishedYear) {
        Optional<AnimeMoviesForm> animeMovies = Optional.ofNullable(animeMoviesService.findByPublishedYear(publishedYear));
        return animeMovies.stream().map(AnimeMoviesResponse::new).toList();
    }
    @PostMapping("/animeMovies")
    public ResponseEntity<Map<String, String>> createAnimeMovies(@RequestBody @Validated AnimeMoviesForm NewAnimeMovies, BindingResult bindingResult, UriComponentsBuilder uriComponentsBuilder) {
        ModelMapper modelMapper = new ModelMapper();
        AnimeMoviesForm conversionAnimeMovies = modelMapper.map(NewAnimeMovies, AnimeMoviesForm.class);
        AnimeMoviesForm animeMovies = animeMoviesService.create(conversionAnimeMovies, bindingResult);
        URI url = uriComponentsBuilder.path("/animeMovies/" + animeMovies.getId())
                .build()
                .toUri();
        return ResponseEntity.created(url).body(Map.of("message", "NewAnimeMovies successfully create"));
    }
    @PatchMapping("/animeMovies/{id}")
    public ResponseEntity<Map<String, String>> patchAnimeMovies(@PathVariable("id")int id, @RequestBody @Validated AnimeMoviesForm NewAnimeMovies, BindingResult bindingResult, UriComponentsBuilder uriComponentsBuilder) {
        ModelMapper modelMapper = new ModelMapper();
        AnimeMoviesForm conversionAnimeMovies = modelMapper.map(NewAnimeMovies, AnimeMoviesForm.class);
        animeMoviesService.update(id, conversionAnimeMovies, bindingResult);
        URI url = uriComponentsBuilder.path("/animeMovies/" + conversionAnimeMovies.getPublishedYear())
                .build()
                .toUri();
        return ResponseEntity.created(url).body(Map.of("message", "the animeMovie successfully update"));
    }
    @DeleteMapping("/animeMovies/{id}")
    public ResponseEntity<Map<String, String>> deleteAnimeMovies(@PathVariable("id")int id) {
        animeMoviesService.delete(id);
        return ResponseEntity.ok(Map.of("message", "the animeMovie successfully delete"));
    }
}
