import java.util.Scanner;

public class RestaurantOrders {

    static final int MAX_ORDERS = 20; // Maximum number of orders

    public static void main(String[] args) {
        // Menu items and their prices
        String[] menuItems = {
                "Appetizer: Garlic Bread", "Appetizer: Caesar Salad", "Appetizer: Roll",
                "Appetizer: Onion Rings", "Appetizer: Soup of the Day",
                "Entree: Steak", "Entree: Salmon", "Entree: Chicken Alfredo",
                "Entree: Veggie Burger", "Entree: Spaghetti no Meatballs",
                "Dessert: Cheesecake", "Dessert: Chocolate Cake", "Dessert: Apple Pie",
                "Dessert: Ice Cream", "Dessert: Skittles"
        };
        double[] prices = {
                5.99, 6.99, 7.99, 4.99, 5.49,
                15.99, 13.99, 12.99, 11.99, 14.99,
                6.99, 5.99, 4.99, 3.99, 7.99
        };

        // Array to track the number of orders for each item
        int[] ordersCount = new int[menuItems.length];

        // Total revenue from all orders
        double totalRevenue = 0;

        // Scanner object for reading user input
        Scanner scanner = new Scanner(System.in);

        // Loop to take orders up to the maximum limit
        for (int i = 0; i < MAX_ORDERS; i++) {
            System.out.println("Welcome to Dip Out and Eat! Check out our menu:");
            // Displaying the menu
            for (int j = 0; j < menuItems.length; j++) {
                System.out.printf("%d. %s - $%.2f\n", j + 1, menuItems[j], prices[j]);
            }

            // Prompting the user to choose an item
            System.out.print("Pick an item by number: ");
            int choice = scanner.nextInt();

            // Validating the user's choice
            while (choice < 1 || choice > menuItems.length) {
                System.out.print("Stop playing. Please choose a valid item number: ");
                choice = scanner.nextInt();
            }

            // Updating the count and revenue for the chosen item
            ordersCount[choice - 1]++;
            totalRevenue += prices[choice - 1];
        }

        // Displaying the order summary
        System.out.println("\nOrder Summary:");
        System.out.printf("Total Money Made: $%.2f\n", totalRevenue);
        for (int i = 0; i < menuItems.length; i++) {
            double percentage = ordersCount[i] * 100.0 / MAX_ORDERS;
            System.out.printf("%s - Ordered: %d, Sales Percentage: %.2f%%\n",
                    menuItems[i], ordersCount[i], percentage);
        }

        // Closing the scanner resource
        scanner.close();
    }
}

