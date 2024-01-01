package IMS;

class Product {
    private int productId;
    private String productName;
    private String category;
    private double unitPrice;
    private int quantityInStock;

    public Product(int productId, String productName, String category, double unitPrice, int quantityInStock) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
        this.unitPrice = unitPrice;
        this.quantityInStock = quantityInStock;
    }

    // Getters and setters for product attributes

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getCategory() {
        return category;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    @Override
    public String toString() {
        return "ID: " + productId + ", Name: " + productName + ", Category: " + category +
                ", Unit Price: " + unitPrice + ", Quantity in Stock: " + quantityInStock;
    }
}