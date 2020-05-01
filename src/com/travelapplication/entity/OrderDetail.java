package com.travelapplication.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;



@Entity(name="order_detail")
public class OrderDetail {
	
	private Integer orderDetailId;
	private float total;
	private Integer quantity;
	private Event event;
	private Event_Order eventOrder;
	
	
	
	@Column(name="subtotal")
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	@Id
	@Column(name="review_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "order_detail_id")
	@SequenceGenerator(allocationSize = 1,name = "order_detail_id",sequenceName = "order_detail_id")
	
	public Integer getOrderDetailId() {
		return orderDetailId;
	}
	public void setOrderDetailId(Integer orderDetailId) {
		this.orderDetailId = orderDetailId;
	}
	@Column(name="quantity")
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
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
	@JoinColumn(name="ORDER_id")
	public Event_Order getEventOrder() {
		return eventOrder;
	}
	public void setEventOrder(Event_Order eventOrder) {
		this.eventOrder = eventOrder;
	}
	
	
	
	
	
	
	
	
	
	
	

}
