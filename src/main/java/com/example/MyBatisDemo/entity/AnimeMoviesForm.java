package com.example.MyBatisDemo.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import org.hibernate.validator.constraints.Length;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
@NoArgsConstructor
public class AnimeMoviesForm {
    private int id;
    @NotBlank
    @Length(min = 1, max = 100)
    private String title;
    @NotBlank
    @Pattern(regexp= "^[0-9]{4}$")
    private String publishedYear;
}
