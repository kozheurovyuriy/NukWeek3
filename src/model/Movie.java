package model;


public class Movie {
    private  MovieType movieType;
    private String title;

    public Movie(MovieType movieType, String title) {
        this.movieType = movieType;
        this.title = title;
    }

    public MovieType getMovieType() {
        return movieType;
    }

    public String getTitle() {
        return title;
    }
}
