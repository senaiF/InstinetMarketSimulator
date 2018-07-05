package test.com.instinet.marketSimulator.prototype.entity;

import java.util.List;
import java.util.Map;

import main.com.instinet.marketSimulator.prototype.entity.Order;
import main.com.instinet.marketSimulator.prototype.singleStock.entity.SingleStockOrderBookIf;

public class FakeSingleStockOrderBook implements SingleStockOrderBookIf {

	@Override
	public void add(Order newOrder) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void completeOrder(Order order) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void completeNewOrder(Order completedNewOrder) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Map<String, List<Order>> getSortedSidesOrderList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Map<String, Long>> getSidesPriceMap() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> getBuyerOrders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> getSellerOrders() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Order> getCompletedOrders() {
		// TODO Auto-generated method stub
		return null;
	}

}
