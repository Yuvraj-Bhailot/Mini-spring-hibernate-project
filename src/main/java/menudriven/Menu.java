package menudriven;

import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Menu {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext app = new AnnotationConfigApplicationContext("menudriven");
		CrudOps ops = app.getBean(CrudOps.class);
		Scanner sc = app.getBean(Scanner.class);
		
		System.out.println("------------------------ Welcome -----------------------");
		
		menu:
		while (true) {
			
			System.out.println("Choose an Option:\n"
							 + "-----------------\n"
							 + "1. Add Restaurant\n"
							 + "2. Update Restaurant\n"
							 + "3. Remove Restaurant\n"
							 + "4. Fetch Restaurant by ID\n"
							 + "5. Fetch All Restaurants\n"
							 + "6. Fetch Restaurant by Name\n"
							 + "7. Add Dish\n"
							 + "8. Fetch All Dishes\n"
							 + "9. Fetch All Dishes by Restaurant\n"
							 + "10. Update Dish\n"
							 + "11. Remove Dish\n"
							 + "12. Exit");
			
			switch (sc.nextInt()) {
			case 1:
				ops.addRestaurant();
				System.out.println("===================================================");
				break;

			case 2:
				ops.updateRestaurant();
				System.out.println("===================================================");
				break;
				
			case 3:
				ops.removeRestaurant();
				System.out.println("===================================================");
				break;
				
			case 4:
				ops.fetchByRestaurantID();
				System.out.println("===================================================");
				break;
				
			case 5:
				ops.fetchAllRestaurant();
				System.out.println("===================================================");
				break;
				
			case 6:
				ops.fetchBasedOnRestaurantName();
				System.out.println("===================================================");
				break;
				
			case 7:
				ops.addDish();
				System.out.println("===================================================");
				break;
				
			case 8:
				ops.fetchAllDish();
				System.out.println("===================================================");
				break;
				
			case 9:
				ops.fetchAllDishByRestaurant();
				System.out.println("===================================================");
				break;
				
			case 10:
				ops.updateDish();
				System.out.println("===================================================");
				break;
				
			case 11:
				ops.removeDish();
				System.out.println("===================================================");
				break;
				
			case 12:
				break menu;
				
			default:
				System.err.println("Enter a valid choice.");
				break;
			}
		}
		
		app.close();
	}
	
}
