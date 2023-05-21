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
    @NotBlank(message = "Nullもしくは空白文字です。")
    @Length(min = 1, max = 100, message = "100文字以内で入力してください。")
    private String title;
    @NotBlank(message = "Nullもしくは空白文字です。")
    @Length(min = 1, max = 4, message = "4文字以内で入力してください。")
    private String publishedYear;
}
