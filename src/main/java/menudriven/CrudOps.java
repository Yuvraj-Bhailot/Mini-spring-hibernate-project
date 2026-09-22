package menudriven;

import org.springframework.stereotype.Component;

@Component
public interface CrudOps {

	public void addRestaurant();
	public void updateRestaurant();
	public void removeRestaurant();
	public void fetchByRestaurantID();
	public void fetchAllRestaurant();
	public void fetchBasedOnRestaurantName();
	public void addDish();
	public void fetchAllDish();
	public void fetchAllDishByRestaurant();
	public void updateDish();
	public void removeDish();
	
}
