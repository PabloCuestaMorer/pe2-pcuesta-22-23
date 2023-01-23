package beans;

import java.util.Comparator;

/**
 * @author Pablo Cuesta Morer
 * @date 2023-01-24
 */
public class Film {

	private String id;
	private String title;
	private int duration;
	private double rating;
	private boolean isActive = true;

	/**
	 * Empty constructor.
	 */
	public Film() {
	}

	/**
	 * Constructor with all parameters.
	 * 
	 * @param id
	 * @param title
	 * @param duration
	 * @param rating
	 */
	public Film(String id, String title, int duration, double rating) {
		this.id = id;
		this.title = title;
		this.duration = duration;
		this.rating = rating;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the duration
	 */
	public int getDuration() {
		return duration;
	}

	/**
	 * @param duration the duration to set
	 */
	public void setDuration(int duration) {
		this.duration = duration;
	}

	/**
	 * @return the rating
	 */
	public double getRating() {
		return rating;
	}

	/**
	 * @param rating the rating to set
	 */
	public void setRating(double rating) {
		this.rating = rating;
	}

	/**
	 * @return the isActive
	 */
	public boolean isActive() {
		return isActive;
	}

	/**
	 * @param isActive the isActive to set
	 */
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public static final Comparator<Film> BY_RATING_DURATION = new ByRatingDuration();

	private static class ByRatingDuration implements Comparator<Film> {
		public int compare(Film s1, Film s2) {
			int ratingCompare = Double.compare(s1.getRating(), s2.getRating());
			if (ratingCompare != 0) {
				return ratingCompare;
			}
			return Integer.compare(s1.getDuration(), s2.getDuration());
		}
	}

	@Override
	public String toString() {
		return "Film [id=" + id + ", title=" + title + ", duration=" + duration + ", rating=" + rating + ", isActive="
				+ isActive + "]";
	}

}
