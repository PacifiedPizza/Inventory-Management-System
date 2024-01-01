package IMS;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        ShoppingCart shoppingCart = new ShoppingCart();

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("===== Inventory Management System =====");
            System.out.println("1. Manage Inventory");
            System.out.println("2. Handle Sales");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    manageInventory(inventory, scanner);
                    break;
                case 2:
                    handleSales(inventory, shoppingCart, scanner);
                    break;
                case 3:
                    System.out.println("Exiting the program. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void manageInventory(Inventory inventory, Scanner scanner) {
        System.out.println("===== Manage Inventory =====");
        System.out.println("1. Add Product");
        System.out.println("2. Update Product");
        System.out.println("3. Remove Product");
        System.out.println("4. Display Products");
        System.out.println("5. Search Products");
        System.out.println("6. Generate Low Stock Report");
        System.out.println("7. Back to Main Menu");
        System.out.print("Enter your choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        switch (choice) {
            case 1:
                addProduct(inventory, scanner);
                break;
            case 2:
                updateProduct(inventory, scanner);
                break;
            case 3:
                removeProduct(inventory, scanner);
                break;
            case 4:
                displayProducts(inventory);
                break;
            case 5:
                searchProducts(inventory, scanner);
                break;
            case 6:
                generateLowStockReport(inventory, scanner);
                break;
            case 7:
                // Back to main menu
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private static void handleSales(Inventory inventory, ShoppingCart shoppingCart, Scanner scanner) {
        System.out.println("===== Handle Sales =====");
        System.out.println("1. Add Item to Shopping Cart");
        System.out.println("2. Calculate Total Bill");
        System.out.println("3. Complete Sale");
        System.out.println("4. Back to Main Menu");
        System.out.print("Enter your choice: ");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        switch (choice) {
            case 1:
                addItemToCart(inventory, shoppingCart, scanner);
                break;
            case 2:
                calculateTotalBill(shoppingCart, inventory);
                break;
            case 3:
                completeSale(shoppingCart, inventory);
                break;
            case 4:
                // Back to main menu
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private static void addProduct(Inventory inventory, Scanner scanner) {
        System.out.print("Enter Product ID: ");
        int productId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        System.out.print("Enter Product Name: ");
        String productName = scanner.nextLine();

        System.out.print("Enter Category: ");
        String category = scanner.nextLine();

        System.out.print("Enter Unit Price: ");
        double unitPrice = scanner.nextDouble();

        System.out.print("Enter Quantity in Stock: ");
        int quantityInStock = scanner.nextInt();

        Product product = new Product(productId, productName, category, unitPrice, quantityInStock);
        inventory.addProduct(product);
    }

    private static void updateProduct(Inventory inventory, Scanner scanner) {
        System.out.print("Enter Product ID to update: ");
        int productId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        System.out.print("Enter new Unit Price: ");
        double newUnitPrice = scanner.nextDouble();

        System.out.print("Enter new Quantity in Stock: ");
        int newQuantity = scanner.nextInt();

        inventory.updateProduct(productId, newUnitPrice, newQuantity);
    }

    private static void removeProduct(Inventory inventory, Scanner scanner) {
        System.out.print("Enter Product ID to remove: ");
        int productId = scanner.nextInt();
        inventory.removeProduct(productId);
    }

    private static void displayProducts(Inventory inventory) {
        inventory.displayProducts();
    }

    private static void searchProducts(Inventory inventory, Scanner scanner) {
        System.out.print("Enter search query (product name or category): ");
        String query = scanner.nextLine();
        List<Product> searchResults = inventory.searchProducts(query);

        if (searchResults.isEmpty()) {
            System.out.println("No matching products found.");
        } else {
            System.out.println("Search results:");
            for (Product product : searchResults) {
                System.out.println(product);
            }
        }
    }

    private static void generateLowStockReport(Inventory inventory, Scanner scanner) {
        System.out.print("Enter low stock threshold: ");
        int threshold = scanner.nextInt();
        List<Product> lowStockProducts = inventory.getLowStockProducts(threshold);

        if (lowStockProducts.isEmpty()) {
            System.out.println("No low stock items found.");
        } else {
            System.out.println("Low stock items:");
            for (Product product : lowStockProducts) {
                System.out.println(product);
            }
        }
    }

    private static void addItemToCart(Inventory inventory, ShoppingCart shoppingCart, Scanner scanner) {
        System.out.print("Enter Product ID to add to the shopping cart: ");
        int productId = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();

        shoppingCart.addItem(productId, quantity);
    }

    private static void calculateTotalBill(ShoppingCart shoppingCart, Inventory inventory) {
        double totalBill = shoppingCart.calculateTotalBill(inventory);
        System.out.println("Total Bill: $" + totalBill);
    }

    private static void completeSale(ShoppingCart shoppingCart, Inventory inventory) {
        shoppingCart.completeSale(inventory);
    }
}
