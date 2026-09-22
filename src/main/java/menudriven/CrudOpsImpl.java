package menudriven;

import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class CrudOpsImpl implements CrudOps {

	@Autowired
	EntityManager em;
	@Autowired
	EntityTransaction et;
	@Autowired
	Scanner sc;
	@Autowired
	@Qualifier("getDishList")
	List<Dish> dishList;
	@Autowired
	@Qualifier("getResList")
	List<Restaurant> resList;

	@Override
	public void addRestaurant() {
		Restaurant res = new Restaurant();
		System.out.println("Enter Restaurant Name: ");
		res.setName(sc.next());
		System.out.println("Enter Restaurant Address: ");
		res.setAddress(sc.next());

		dishList.clear();
		
		System.out.println("Do you want add Dishes for " + res.getName() + ":\n1=>Yes | 2=>No");
		if (sc.nextInt() == 1) {
			while (true) {
				Dish dish = new Dish();
				System.out.println("Enter Dish Name: ");
				dish.setName(sc.next());
				System.out.println("Enter Dish Price: ");
				dish.setPrice(sc.nextDouble());
				dish.setRestaurant(res);

				dishList.add(dish);

				System.out.println("Do you want add another Dish:\n1=>Yes | 2=>No");
				if (sc.nextInt() != 1) {
					break;
				}
			}
			res.setDish(dishList);
		}
		em.persist(res);
		et.begin();
		et.commit();
		System.out.println("Restaurant Added Successfully");
	}

	@Override
	public void updateRestaurant() {
		System.out.println("Enter Restaurant ID you want to update:");
		Restaurant res = em.find(Restaurant.class, sc.nextInt());
		System.out.println("Do you want to update restaurant name:\n1=>Yes | 2=>No");
		if(sc.nextInt()==1) {
			System.out.println("Enter Restaurant new name:");
			res.setName(sc.next());
		}
		System.out.println("Do you want to update restaurant address:\n1=>Yes | 2=>No");
		if(sc.nextInt()==1) {
			System.out.println("Enter Restaurant new address:");
			res.setAddress(sc.next());
		}
		em.merge(res);
		et.begin();
		et.commit();
		System.out.println("Restaurant Updated Successfully");
	}

	@Override
	public void removeRestaurant() {
		Restaurant res = new Restaurant();
		System.out.println("Enter Restaurant ID you want to remove:");
		res = em.find(Restaurant.class, sc.nextInt());
		em.remove(res);
		et.begin();
		et.commit();
		System.out.println("Restaurant Removed Successfully");
	}

	@Override
	public void fetchByRestaurantID() {
		System.out.println("Enter Restaurant ID you want to fetch:");
		Restaurant res = em.find(Restaurant.class, sc.nextInt());
		System.out.println(res);
	}

	@Override
	public void fetchAllRestaurant() {
		Query query = em.createQuery("select res from Restaurant res");
		resList = query.getResultList();
		for (Restaurant r : resList) {
			System.out.println(r);
		}
	}

	@Override
	public void fetchBasedOnRestaurantName() {
		Query query = em.createQuery("select res from Restaurant res where name=:name");
		System.out.println("Enter Restaurant Name you want to fetch:");
		query.setParameter("name", sc.next());
		resList = query.getResultList();
		for (Restaurant r : resList) {
			System.out.println(r);
		}
	}

	@Override
	public void addDish() {
		System.out.println("Enter Restaurant ID you want to add dishes:");
		Restaurant res = em.find(Restaurant.class, sc.nextInt());
		
		System.out.println("Do you want add Dishes for " + res.getName() + ":\n1=>Yes | 2=>No");
		if (sc.nextInt() == 1) {
			while (true) {
				Dish dish = new Dish();
				System.out.println("Enter Dish Name: ");
				dish.setName(sc.next());
				System.out.println("Enter Dish Price: ");
				dish.setPrice(sc.nextDouble());
				dish.setRestaurant(res);

				em.persist(dish);
				et.begin();
				et.commit();

				System.out.println("Do you want add another Dish:\n1=>Yes | 2=>No");
				if (sc.nextInt() != 1) {
					break;
				}
			}
		}
		System.out.println("Dishes Added Successfully");
	}

	@Override
	public void fetchAllDish() {
		Query query = em.createQuery("select dish from Dish dish");
		dishList = query.getResultList();
		for (Dish d : dishList) {
			System.out.println(d);
		}
	}

	@Override
	public void fetchAllDishByRestaurant() {
		System.out.println("Enter Restaurant ID you want to fetch dishes:");
		int id = sc.nextInt();
		Query query = em.createQuery("select dish from Dish dish where restaurantId = "+id);
		dishList = query.getResultList();
		for (Dish d : dishList) {
			System.out.println(d);
		}
	}

	@Override
	public void updateDish() {
		System.out.println("Enter Dish ID you want to update:");
		Dish dish = em.find(Dish.class, sc.nextInt());
		System.out.println("Do you want update dish name:\n1=>Yes | 2=>No");
		if(sc.nextInt()==1) {
			System.out.println("Enter dish new name:");
			dish.setName(sc.next());
		}
		System.out.println("Do you want update dish price:\n1=>Yes | 2=>No");
		if(sc.nextInt()==1) {
			System.out.println("Enter dish new price:");
			dish.setPrice(sc.nextDouble());
		}
		em.merge(dish);
		et.begin();
		et.commit();
		System.out.println("Dish Updated Successfully.");
	}

	@Override
	public void removeDish() {
		System.out.println("Enter Dish ID you want to remove:");
		Dish dish = em.find(Dish.class, sc.nextInt());
		em.remove(dish);
		et.begin();
		et.commit();
		System.out.println("Dish Removed Successfully.");
	}

}
