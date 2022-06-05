package com.springboot.ms.ratingsdataservice.controllers;

import com.springboot.ms.ratingsdataservice.models.Rating;
import com.springboot.ms.ratingsdataservice.models.UserRating;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ratingsData")
public class RatingsController {

    private static final String USER_V = "vkhulbey";
    private static final String USER_C = "cmadho";

    @GetMapping("/users/{userId}")
    public UserRating getUserRating(@PathVariable("userId") String userId) {
        List<Rating> filteredRatingList = getRatingList()
                .stream()
                .filter(rating -> rating.getUserId().equals(userId))
                .collect(Collectors.toList());
        return new UserRating(userId, filteredRatingList);
    }

    private static List<Rating> getRatingList() {
        return List.of(
                new Rating(USER_V, "101", 4),
                new Rating(USER_V, "102", 4),
                new Rating(USER_V, "103", 4),
                new Rating(USER_V, "104", 4),
                new Rating(USER_C, "101", 5),
                new Rating(USER_C, "105", 5),
                new Rating(USER_C, "106", 5),
                new Rating(USER_C, "102", 5),
                new Rating("var1", "110", 5)
        );
    }

}
