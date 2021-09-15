package ca.sheridancollege.pate1431.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class MovieInformation {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String authorName;
	private Integer releaseDate;
	
	
	/*
	 * @OneToOne
	 * 
	 * @JoinTable(name="MOVIEINFORMATION_MOVIEREVIEW",
	 * joinColumns= @JoinColumn(name="MOVIEINFORMATION_ID"),
	 * inverseJoinColumns= @JoinColumn(name="MOVIEREVIEW_ID"))  */
	
//	private MovieReview movieReview;
	
	

	@OneToMany 
	private List<MovieReview> reviewList=new ArrayList<MovieReview>();
	
	@Enumerated(EnumType.STRING)
	private StreamingService streamingService;
}
