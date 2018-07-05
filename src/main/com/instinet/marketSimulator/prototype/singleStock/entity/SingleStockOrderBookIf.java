package main.com.instinet.marketSimulator.prototype.singleStock.entity;

import java.util.List;

import main.com.instinet.marketSimulator.prototype.entity.Order;
import main.com.instinet.marketSimulator.prototype.entity.OrderBookIf;

public interface SingleStockOrderBookIf extends OrderBookIf{

	public List<Order> getBuyerOrders();

	public List<Order> getSellerOrders();

	public List<Order> getCompletedOrders();
	
	
}
