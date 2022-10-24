package Model;

import java.time.LocalDateTime;

/**
 * An implementation of the stock interface.
 */
public class StockImpl implements Stock {
  private String tickerSymbol;    // The ticker symbol of stock.
  private double price;           // The price of stock.
  private int quantity;           // The quantity we buy.
  private LocalDateTime buyDate;  // The date we buy this stock.

  public StockImpl(String name, double cost, int number, LocalDateTime date)
          throws IllegalArgumentException {
    // Check each input is valid first.
    if (name == null || name.isEmpty()) {
      throw new IllegalArgumentException("The name of stock cannot be empty!");
    }
    if (cost < 0) {
      throw new IllegalArgumentException("The price of stock must be greater than 0!");
    }
    if (number < 0) {
      throw new IllegalArgumentException("The quantity of stock must be greater than 0!");
    }
    if (date == null) {
      throw new IllegalArgumentException("The purchase date cannot be null!");
    } else if (date.isAfter(LocalDateTime.now())) {
      throw new IllegalArgumentException("The purchase date cannot on a future date!");
    }
    this.tickerSymbol = name;
    this.price = cost;
    this.quantity = number;
    this.buyDate = date;
  }

  @Override
  public String getStockTickerSymbol() {
    return this.tickerSymbol;
  }

  @Override
  public double getPrice() {
    return this.price;
  }

  @Override
  public int getQuantity() {
    return this.quantity;
  }

  @Override
  public LocalDateTime getBuyDate() {
    return this.buyDate;
  }

  @Override
  public String toString() {
    return "Ticker name:" + this.tickerSymbol + " Price per stock:" + this.price
            + " Stock quantity:" + this.quantity + " Purchase date:" + this.buyDate;
  }
}
