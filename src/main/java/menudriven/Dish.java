package menudriven;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Entity
public class Dish {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private double price;
	
	@ManyToOne
	@JoinColumn(name = "restaurant_id")
	private Restaurant restaurantId;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Restaurant getRestaurant() {
		return restaurantId;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurantId = restaurant;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "\nDish [id=" + id + ", name=" + name + ", price=" + price + "]";
	}
	
}
