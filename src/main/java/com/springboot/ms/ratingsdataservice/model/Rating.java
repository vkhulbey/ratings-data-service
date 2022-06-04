package com.springboot.ms.ratingsdataservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Rating {

    private String userId;
    private String movieId;
    private int starRating;
}
