package ru.netology.javaqa.movies_cards;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.javaqa.movies_cards.data.MovieCard;

import static org.junit.jupiter.api.Assertions.*;

class MovieManagerTest {

    MovieCard movie1 = new MovieCard(1, "Matrix", "action", 5);
    MovieCard movie2 = new MovieCard(2, "Matrix 2", "action", 7);
    MovieCard movie3 = new MovieCard(3, "Matrix 3", "action", 10);

    @Test
    void shouldAddNoMovie() {
        MovieManager movies = new MovieManager();

        MovieCard[] expected = {};
        MovieCard[] actual = movies.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldAddOneMovie() {
        MovieManager movies = new MovieManager();
        movies.addMovie(movie1);

        MovieCard[] expected = {movie1};
        MovieCard[] actual = movies.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldAddSeveralMovies() {
        MovieManager movies = new MovieManager();
        movies.addMovie(movie1);
        movies.addMovie(movie2);
        movies.addMovie(movie3);

        MovieCard[] expected = {movie1, movie2, movie3};
        MovieCard[] actual = movies.findAll();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindLastIfDefault() {
        MovieManager movies = new MovieManager();
        movies.addMovie(movie1);
        movies.addMovie(movie2);
        movies.addMovie(movie3);
        movies.addMovie(movie3);
        movies.addMovie(movie3);

        MovieCard[] expected = {movie3, movie3, movie3, movie2, movie1};
        MovieCard[] actual = movies.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindLastIfBelowDefault() {
        MovieManager movies = new MovieManager();
        movies.addMovie(movie1);
        movies.addMovie(movie2);
        movies.addMovie(movie3);
        movies.addMovie(movie3);

        MovieCard[] expected = {movie3, movie3, movie2, movie1};
        MovieCard[] actual = movies.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindLastIfCustomLimit() {
        MovieManager movies = new MovieManager(4);
        movies.addMovie(movie1);
        movies.addMovie(movie2);
        movies.addMovie(movie3);
        movies.addMovie(movie3);

        MovieCard[] expected = {movie3, movie3, movie2, movie1};
        MovieCard[] actual = movies.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindLastIfBelowCustomLimit() {
        MovieManager movies = new MovieManager(4);
        movies.addMovie(movie1);
        movies.addMovie(movie2);
        movies.addMovie(movie3);

        MovieCard[] expected = {movie3, movie2, movie1};
        MovieCard[] actual = movies.findLast();

        Assertions.assertArrayEquals(expected, actual);
    }
}