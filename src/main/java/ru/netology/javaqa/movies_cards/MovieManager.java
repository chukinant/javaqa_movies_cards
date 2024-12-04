package ru.netology.javaqa.movies_cards;

import ru.netology.javaqa.movies_cards.data.MovieCard;

public class MovieManager {
    private MovieCard[] movies = new MovieCard[0];
    private int limit;

    public MovieManager() {
        this.limit = 5;
    }

    public MovieManager(int limit) {
        this.limit = limit;
    }

    public void addMovie(MovieCard movie) {
        MovieCard[] tmp = new MovieCard[movies.length + 1];
        for (int i = 0; i < movies.length; i++) {
            tmp[i] = movies[i];
        }
        tmp[tmp.length - 1] = movie;
        movies = tmp;
    }

    public MovieCard[] findAll() {
        return movies;
    }


    public MovieCard[] findLast() {
        int resultedLength;
        if (movies.length < limit) {
            resultedLength = movies.length;
        }
        else {
            resultedLength = limit;
        }
        MovieCard[] tmp = new MovieCard[resultedLength];
        for (int i = 0; i < tmp.length; i++) {
            tmp[i] = movies[movies.length - 1 - i];
        }
        return tmp;
    }
}
