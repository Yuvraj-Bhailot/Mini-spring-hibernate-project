package menudriven;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Entity
public class Restaurant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@SequenceGenerator(name = "res_id_gen", initialValue = 101, allocationSize = 1)
	private int id;
	private String name;
	private String Address;
	
	@OneToMany(mappedBy = "restaurantId", cascade = CascadeType.ALL)
	private List<Dish> dish;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public List<Dish> getDish() {
		return dish;
	}

	public void setDish(List<Dish> dish) {
		this.dish = dish;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "\nRestaurant [id=" + id + ", name=" + name + ", Address=" + Address + ", dish=" + dish + "]";
	}
	
}
