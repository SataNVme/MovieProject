package com.project2.movieproject.movieDetail;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class MovieOrderForm {
    private String user_name;
    private String movie_nm;
    private int movie_sellPrice;
    private int movie_rentPrice;
}