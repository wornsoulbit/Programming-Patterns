/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4part1;

/**
 *
 * @author Alex Vasil
 */
public class Stock {
    private int stockNumber;
    private int quantity;
    private String name;

    public Stock(int stockNumber, int quantity, String name) {
        this.stockNumber = stockNumber;
        this.quantity = quantity;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Stock{" + "stockNumber=" + stockNumber + ", quantity=" + quantity + ", name=" + name + '}';
    }

    public int getStockNumber() {
        return stockNumber;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getName() {
        return name;
    }
}
