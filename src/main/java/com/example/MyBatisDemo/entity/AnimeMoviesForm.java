package com.example.MyBatisDemo.entity;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class AnimeMoviesForm {
    private int id;
    @NotBlank
    @Length(min = 1, max = 30)
    private String title;
    @NotBlank
    @Length(min = 1, max = 4)
    private String publishedYear;
}
