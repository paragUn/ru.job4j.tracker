package ru.job4j.pojo;

public class ShopDrop {
    public static Product[] delete(Product[] products, int index) {
        for (int indexOfArray = index; indexOfArray < products.length - 1; indexOfArray++) {
            products[indexOfArray] = products[indexOfArray + 1];
        }
        products[products.length - 1] = null;
        return products;
    }
}