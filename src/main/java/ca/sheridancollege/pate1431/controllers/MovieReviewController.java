package ca.sheridancollege.pate1431.controllers;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ca.sheridancollege.pate1431.beans.MovieInformation;
import ca.sheridancollege.pate1431.beans.MovieReview;
import ca.sheridancollege.pate1431.repositories.MovieInformationRepository;
import ca.sheridancollege.pate1431.repositories.MovieReviewRepository;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class MovieReviewController {
	private MovieReviewRepository movieReviewRepository;
	private MovieInformationRepository movieInformationRepository;
	
	@GetMapping("/addReview")
	public String addReview(Model model)
	{
		
		model.addAttribute("movieReview", new MovieReview());
		List<MovieInformation> movieList = movieInformationRepository.findAll();
		model.addAttribute("movieData", movieList);
		return "addReview";
	}
	/****************************************************
	 * 						Add Review					*
	 ****************************************************/
	
	@PostMapping("/addReview") 
	public String addReview(Model model, @RequestParam String name, @RequestParam Long pid,
			@RequestParam String reviewMovie, @RequestParam Float ratings, 
			@RequestParam String reviewAuthor,
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate reviewDate, 
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.TIME) LocalTime reviewTime) 
	{
		List<MovieInformation> movieList= movieInformationRepository.findAll();
		model.addAttribute("movieList", movieList);
		
		MovieInformation data=movieInformationRepository.findById(pid).get();
		
		MovieReview movieReview= new MovieReview();
		movieReview.setName(name);
		movieReview.setRatings(ratings);
		movieReview.setReviewAuthor(reviewAuthor);
		movieReview.setReviewMovie(reviewMovie);
		movieReview.setReviewDate(reviewDate);
		movieReview.setReviewTime(reviewTime);
		
		movieReviewRepository.save(movieReview);
		
		data.getReviewList().add(movieReview);
		
		List<MovieReview> movieReviewList = (List<MovieReview>) movieReviewRepository.findAll();
		
		movieInformationRepository.save(data);
		
		model.addAttribute("movieInformation", new MovieReview());
		model.addAttribute("movieReviewList", movieReviewList);
		
		
		
		return "index"; 
	}
	 
}
