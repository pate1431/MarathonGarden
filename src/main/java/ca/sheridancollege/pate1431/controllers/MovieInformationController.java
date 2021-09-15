package ca.sheridancollege.pate1431.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import ca.sheridancollege.pate1431.beans.MovieInformation;
import ca.sheridancollege.pate1431.beans.MovieReview;
import ca.sheridancollege.pate1431.beans.StreamingService;
import ca.sheridancollege.pate1431.repositories.MovieInformationRepository;
import ca.sheridancollege.pate1431.repositories.MovieReviewRepository;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class MovieInformationController {
	
	private MovieInformationRepository movieInformationRepository;
	private MovieReviewRepository movieReviewRepository;
	
	@GetMapping("/")
	public String index(Model model)
	{
		model.addAttribute("movieReview", new MovieReview());
		model.addAttribute("movieInformation", new MovieInformation());
		model.addAttribute("streamingService", StreamingService.values());
		List<MovieInformation> movieList= movieInformationRepository.findAll();
		model.addAttribute("movieList", movieList);
		List<MovieReview> movieReviewList= movieReviewRepository.findAll();
		model.addAttribute("movieReviewList", movieReviewList);
		return "index";
	}
	/****************************************************
	 * 						Add Movie					*
	 ****************************************************/
	@GetMapping("/addMovie")
	public String addMovie(Model model)
	{
		List<MovieReview> movieReviewList= movieReviewRepository.findAll();
		model.addAttribute("movieReviewList", movieReviewList);
		
		model.addAttribute("streamingService", StreamingService.values());
		model.addAttribute("movieInformation", new MovieInformation());
		return "addMovie";
	}
	@PostMapping("/addMovie")
	public String addMovie(Model model, @ModelAttribute MovieInformation movieInformation)
	{	
		List<MovieReview> movieReviewList= movieReviewRepository.findAll();
		model.addAttribute("movieReviewList", movieReviewList);	
		movieInformationRepository.save(movieInformation);		
		List<MovieInformation> movieList = (List<MovieInformation>) movieInformationRepository.findAll();
		model.addAttribute("movieInformation", new MovieInformation());
		model.addAttribute("movieList", movieList);		
		return "index";
	}
	
	/****************************************************
	 * 				Release Date Order					*
	 ****************************************************/
	@PostMapping("/findByOrderByReleaseDateAsc")
	public String findByOrderByReleaseDateAsc(Model model)
	{	
		List<MovieReview> movieReviewList= movieReviewRepository.findAll();
		model.addAttribute("movieReviewList", movieReviewList);
	
		List<MovieInformation>temp = movieInformationRepository.findByOrderByReleaseDateAsc();
		model.addAttribute("movieList", temp);
		return "index";
	}
	@PostMapping("/findByOrderByReleaseDateDesc")
	public String findByOrderByReleaseDateDesc(Model model)
	{	
		List<MovieReview> movieReviewList= movieReviewRepository.findAll();
		model.addAttribute("movieReviewList", movieReviewList);
	
		List<MovieInformation>temp = movieInformationRepository.findByOrderByReleaseDateDesc();
		model.addAttribute("movieList", temp);
		return "index";
	}
	
	/****************************************************
	 * 					Streaming Order					*
	 ****************************************************/
	@PostMapping("/findByOrderByStreamingServiceDesc")
	public String findByOrderByStreamingServiceDesc(Model model)
	{	
		List<MovieReview> movieReviewList= movieReviewRepository.findAll();
		model.addAttribute("movieReviewList", movieReviewList);
	
		List<MovieInformation>temp = movieInformationRepository.findByOrderByStreamingServiceDesc();
		model.addAttribute("movieList", temp);
		return "index";
	}
	@PostMapping("/findByOrderByStreamingServiceAsc")
	public String findByOrderByStreamingServiceAsc(Model model)
	{	
		List<MovieReview> movieReviewList= movieReviewRepository.findAll();
		model.addAttribute("movieReviewList", movieReviewList);
	
		List<MovieInformation>temp = movieInformationRepository.findByOrderByStreamingServiceAsc();
		model.addAttribute("movieList", temp);
		return "index";
	}
	
	/****************************************************
	 * 				Review Date Order					*
	 ****************************************************/
	@PostMapping("/findByOrderByReviewDateDesc")
	public String findByOrderByReviewDateDesc(Model model)
	{	
		List<MovieInformation> movieList= movieInformationRepository.findAll();
		model.addAttribute("movieList", movieList);
		
		List<MovieReview>temp = movieReviewRepository.findByOrderByReviewDateDesc();
		model.addAttribute("movieReviewList", temp);
		return "index";
	}
	@PostMapping("/findByOrderByReviewDateAsc")
	public String findByOrderByReviewDateAsc(Model model)
	{	
		List<MovieInformation> movieList= movieInformationRepository.findAll();
		model.addAttribute("movieList", movieList);
		
		List<MovieReview>temp = movieReviewRepository.findByOrderByReviewDateAsc();
		model.addAttribute("movieReviewList", temp);
		return "index";
	}
	
	/****************************************************
	 * 				Review Time Order					*
	 ****************************************************/
	@PostMapping("/findByOrderByReviewTimeDesc")
	public String findByOrderByReviewTimeDesc(Model model)
	{	
		List<MovieInformation> movieList= movieInformationRepository.findAll();
		model.addAttribute("movieList", movieList);
		
		List<MovieReview>temp = movieReviewRepository.findByOrderByReviewTimeDesc();
		model.addAttribute("movieReviewList", temp);
		return "index";
	}
	@PostMapping("/findByOrderByReviewTimeAsc")
	public String findByOrderByReviewTimeAsc(Model model)
	{	
		List<MovieInformation> movieList= movieInformationRepository.findAll();
		model.addAttribute("movieList", movieList);
		
		List<MovieReview>temp = movieReviewRepository.findByOrderByReviewTimeAsc();
		model.addAttribute("movieReviewList", temp);
		return "index";
	}

	/****************************************************
	 * 					Ratings Order					*
	 ****************************************************/
	@PostMapping("/findByOrderByRatingsDesc")
	public String findByOrderByRatingsDesc(Model model)
	{	
		List<MovieInformation> movieList= movieInformationRepository.findAll();
		model.addAttribute("movieList", movieList);
		
		List<MovieReview>temp = movieReviewRepository.findByOrderByRatingsDesc();
		model.addAttribute("movieReviewList", temp);
		return "index";
	}
	@PostMapping("/findByOrderByRatingsAsc")
	public String findByOrderByRatingsAsc(Model model)
	{	
		List<MovieInformation> movieList= movieInformationRepository.findAll();
		model.addAttribute("movieList", movieList);
		
		List<MovieReview>temp = movieReviewRepository.findByOrderByRatingsAsc();
		model.addAttribute("movieReviewList", temp);
		return "index";
	}
	

}
