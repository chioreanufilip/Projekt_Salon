package Module;

/**
 * Represents a review given by a client for a service or product.
 * A review contains a rating, a comment, and a reference to the client who provided it.
 */
public class Review implements HasId {

    private Integer id;
    private Integer rating;
    private String comment;
    private Integer clientId;

    /**
     * Constructs a Review object with the specified id, rating, and comment.
     *
     * @param id      the unique identifier for the review
     * @param rating  the rating provided in the review (e.g., on a scale of 1 to 5)
     * @param comment the comment provided in the review
     */
    public Review(Integer id, Integer rating, String comment) {
        this.id = id;
        this.rating = rating;
        this.comment = comment;
    }

    /**
     * Returns the unique identifier of the review.
     *
     * @return the ID of the review
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the unique identifier for the review.
     *
     * @param id the ID to set for the review
     */
    public void setid(Integer id) {
        this.id = id;
    }

    /**
     * Returns the comment provided in the review.
     *
     * @return the comment of the review
     */
    public String getComment() {
        return comment;
    }

    /**
     * Sets the comment for the review.
     *
     * @param comment the comment to set for the review
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * Returns the rating given in the review.
     *
     * @return the rating of the review
     */
    public int getRating() {
        return rating;
    }

    /**
     * Sets the rating for the review.
     *
     * @param rating the rating to set for the review
     */
    public void setRating(int rating) {
        this.rating = rating;
    }

    /**
     * Returns the client ID who provided the review.
     *
     * @return the ID of the client who gave the review
     */
    public Integer getClientId() {
        return clientId;
    }

    /**
     * Sets the client ID for the review.
     *
     * @param clientId the client ID to set for the review
     */
    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    /**
     * Default constructor for the Review class.
     */
    public Review() {}
}
