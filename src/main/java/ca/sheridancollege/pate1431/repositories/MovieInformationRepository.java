package ca.sheridancollege.pate1431.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ca.sheridancollege.pate1431.beans.MovieInformation;

public interface MovieInformationRepository extends JpaRepository<MovieInformation, Long> {

	public List<MovieInformation> findByOrderByStreamingServiceDesc();
	public List<MovieInformation> findByOrderByReleaseDateDesc();
	public List<MovieInformation> findByOrderByStreamingServiceAsc();
	public List<MovieInformation> findByOrderByReleaseDateAsc();

}
