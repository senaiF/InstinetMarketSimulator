package main.com.instinet.marketSimulator.prototype.entity;

import java.util.List;
import java.util.Map;

public interface OrderBookIf {

	void add(Order newOrder);
	void completeOrder(Order order);
	void completeNewOrder(Order completedNewOrder);
	Map<String,List<Order>> getSortedSidesOrderList();
	Map<String,Map<String,Long>> getSidesPriceMap();
}
