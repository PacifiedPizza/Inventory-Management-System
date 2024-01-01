package IMS;

import java.util.HashMap;
import java.util.Map;

class ShoppingCart {
    private Map<Integer, Integer> items; // Map productId to quantity

    public ShoppingCart() {
        this.items = new HashMap<>();
    }

    public void addItem(int productId, int quantity) {
        items.put(productId, items.getOrDefault(productId, 0) + quantity);
        System.out.println("Item added to the shopping cart.");
    }

    public double calculateTotalBill(Inventory inventory) {
        double totalBill = 0.0;
        for (Map.Entry<Integer, Integer> entry : items.entrySet()) {
            int productId = entry.getKey();
            int quantity = entry.getValue();
            Product product = getProductById(inventory, productId);
            if (product != null) {
                totalBill += product.getUnitPrice() * quantity;
            }
        }
        return totalBill;
    }

    private Product getProductById(Inventory inventory, int productId) {
        for (Product product : inventory.getProductName()) {
            if (product.getProductId() == productId) {
                return product;
            }
        }
        return null;
    }

    public void completeSale(Inventory inventory) {
        for (Map.Entry<Integer, Integer> entry : items.entrySet()) {
            int productId = entry.getKey();
            int soldQuantity = entry.getValue();
            Product product = getProductById(inventory, productId);
            if (product != null && product.getQuantityInStock() >= soldQuantity) {
                product.setQuantityInStock(product.getQuantityInStock() - soldQuantity);
            }
        }
        System.out.println("Sale completed successfully.");
        items.clear(); // Clear the shopping cart after a sale
    }
}