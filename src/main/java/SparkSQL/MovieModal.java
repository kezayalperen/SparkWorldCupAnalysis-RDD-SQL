package SparkSQL;

import java.io.Serializable;

public class MovieModal  {
    private String userID;
    private String movieID;
    private String rating;
    private String timestamp;

    public MovieModal() {
    }

    public MovieModal(String userID, String movieID, String rating, String timestamp) {
        this.userID = userID;
        this.movieID = movieID;
        this.rating = rating;
        this.timestamp = timestamp;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getMovieID() {
        return movieID;
    }

    public void setMovieID(String movieID) {
        this.movieID = movieID;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String ratings) {
        this.rating = ratings;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
