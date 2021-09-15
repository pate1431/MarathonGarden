package ca.sheridancollege.pate1431.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ca.sheridancollege.pate1431.beans.MovieReview;

public interface MovieReviewRepository extends JpaRepository<MovieReview, Long> {
	public List<MovieReview> findByOrderByReviewDateDesc();
	public List<MovieReview> findByOrderByReviewTimeDesc();
	public List<MovieReview> findByOrderByRatingsDesc();
	public List<MovieReview> findByOrderByReviewDateAsc();
	public List<MovieReview> findByOrderByReviewTimeAsc();
	public List<MovieReview> findByOrderByRatingsAsc();
}
