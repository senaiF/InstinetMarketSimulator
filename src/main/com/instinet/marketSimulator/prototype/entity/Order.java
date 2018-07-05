package main.com.instinet.marketSimulator.prototype.entity;

import java.util.ArrayList;
import java.util.List;

public class Order {

	public static long ordersCounter = 0;
	
	long orderSequence;
	OrderType orderType;
	long orderedQuantity;
	double price;

	long quantityLeft;
	List<TradeIf> trades = new ArrayList<TradeIf>();

	public Order(OrderType orderType, long orderedQuantity, double price) {
		super();
		ordersCounter++;
		orderSequence = ordersCounter;
		this.orderType = orderType;
		this.orderedQuantity = orderedQuantity;
		this.price = price;
		this.quantityLeft = orderedQuantity;
	}

	public long getOrderSequence() {
		return orderSequence;
	}

	public void setOrderSequence(long orderSequence) {
		this.orderSequence = orderSequence;
	}

	public OrderType getOrderType() {
		return orderType;
	}
	
	public long getOrderedQuantity() {
		return orderedQuantity;
	}

	public double getPrice() {
		return price;
	}

	public long getQuantityLeft() {
		return quantityLeft;
	}

	private void setQuantityLeft(long quantityLeft) {
		this.quantityLeft = quantityLeft;
	}
	
	public boolean makeATrade(TradeIf trade){
		if(quantityLeft >= trade.getQuantityTraded())
			setQuantityLeft(quantityLeft - trade.getQuantityTraded());
		else
			return false;
		
		trades.add(trade);
		return true;		
	}

	@Override
	public String toString() {
		
		return quantityLeft + "@" + price;
	}

	@Override
	public boolean equals(Object obj) {
		
		return orderSequence == ((Order)obj).orderSequence;
	}

}
