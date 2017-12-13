package org.anime.domain;

public class Anime {

    private String posterImage;
    private String title;
    private String description;
    private String year;
    private String rating;
    private String video;

    public Anime(String posterImage, String title, String description, String year, String rating, String video) {
        this.posterImage = posterImage;
        this.title = title;
        this.description = description;
        this.year = year;
        this.rating = rating;
        this.video = video;
    }

    public String getTitle() {
        return title;
    }

    public String getPosterImage() {
        return posterImage;
    }

    public String getDescription() {
        return description;
    }

    public String getYear() {
        return year;
    }

    public String getRating() {
        return rating;
    }

    public String getVideo() {
        return video;
    }
}
