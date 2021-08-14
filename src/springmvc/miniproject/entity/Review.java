package springmvc.miniproject.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="reviews")
public class Review {
	
	@Id
	@Column(name="id")
	private int id;
	@Column
	private String reviews;
	
	public Review() {}
	public Review(int id, String reviews) {
	//	super();
		this.id = id;
		this.reviews = reviews;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getReviews() {
		return reviews;
	}
	
}
