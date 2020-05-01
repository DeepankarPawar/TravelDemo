package com.travelapplication.entity;



import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;




@Entity(name="review")
public class Review {

	
	private Integer reviewId;
	private String comment;
	private String headLine;
	private Date reviewDate;
	private Event event;
	private Customer customer;
	private Integer rating;
	
	
	
	
	
	@Column(name="rating")
	public Integer getRating() {
		return rating;
	}
	public void setRating(Integer rating) {
		this.rating = rating;
	}
	@Id
	@Column(name="review_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "review_seq")
	@SequenceGenerator(allocationSize = 1,name = "review_seq",sequenceName = "review_seq")
	public Integer getReviewId() {
		return reviewId;
	}
	public void setReviewId(Integer reviewId) {
		this.reviewId = reviewId;
	}
	@Column(name="com_ment")
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	@Column(name="headline")
	public String getHeadLine() {
		return headLine;
	}
	public void setHeadLine(String headLine) {
		this.headLine = headLine;
	}
	@Column(name="review_time")
	public Date getReviewDate() {
		return reviewDate;
	}
	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="event_id")
	public Event getEvent() {
		return event;
	}
	public void setEvent(Event event) {
		this.event = event;
	}

	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="customer_id")
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
	
	
}
