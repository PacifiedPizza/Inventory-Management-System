package IMS;

import java.util.ArrayList;
import java.util.List;

class Inventory {
    private List<Product> products;

    public Inventory() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
        System.out.println("Product added to the inventory.");
    }

    public void updateProduct(int productId, double newUnitPrice, int newQuantity) {
        for (Product product : products) {
            if (product.getProductId() == productId) {
                product.setUnitPrice(newUnitPrice);
                product.setQuantityInStock(newQuantity);
                System.out.println("Product information updated.");
                return;
            }
        }
        System.out.println("Product not found in the inventory.");
    }

    public void removeProduct(int productId) {
        products.removeIf(product -> product.getProductId() == productId);
        System.out.println("Product removed from the inventory.");
    }

    public void displayProducts() {
        if (products.isEmpty()) {
            System.out.println("No products in the inventory.");
        } else {
            for (Product product : products) {
                System.out.println(product);
            }
        }
    }

    public List<Product> searchProducts(String query) {
        List<Product> searchResults = new ArrayList<>();
        for (Product product : products) {
            if (product.getProductName().toLowerCase().contains(query.toLowerCase()) ||
                    product.getCategory().toLowerCase().contains(query.toLowerCase())) {
                searchResults.add(product);
            }
        }
        return searchResults;
    }

    public List<Product> getLowStockProducts(int threshold) {
        List<Product> lowStockProducts = new ArrayList<>();
        for (Product product : products) {
            if (product.getQuantityInStock() < threshold) {
                lowStockProducts.add(product);
            }
        }
        return lowStockProducts;
    }

    public Product[] getProductName() {
        return null;
    }
}
