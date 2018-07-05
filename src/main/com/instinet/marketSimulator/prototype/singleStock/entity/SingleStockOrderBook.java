package main.com.instinet.marketSimulator.prototype.singleStock.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import main.com.instinet.marketSimulator.prototype.entity.Order;
import main.com.instinet.marketSimulator.prototype.entity.OrderType;

public class SingleStockOrderBook implements SingleStockOrderBookIf {
	
	List<Order> buyerOrders = new LinkedList<Order>();
	List<Order> sellerOrders = new LinkedList<Order>();
	List<Order> completedOrders = new ArrayList<Order>();

	
	@SuppressWarnings("unchecked")
	public List<Order> getBuyerOrders() {
		return (List<Order>)((LinkedList<Order>)buyerOrders).clone();
	}

	@SuppressWarnings("unchecked")
	public List<Order> getSellerOrders() {
		return (List<Order>)((LinkedList<Order>)sellerOrders).clone();
	}

	@SuppressWarnings("unchecked")
	public List<Order> getCompletedOrders() {
		return (List<Order>)((ArrayList<Order>)completedOrders).clone();
	}

	@Override
	public void add(Order newOrder) {
		
		switch(newOrder.getOrderType()){	
			case B : buyerOrders.add(newOrder);
					 Collections.sort(buyerOrders, new Comparator<Order>(){
						  public int compare(Order o1, Order o2){
							  int comparisonResult = ((Double)o2.getPrice()).compareTo(o1.getPrice());
						    if(comparisonResult != 0)
						    	return comparisonResult;
						    else
						    	return ((Long)o1.getOrderSequence()).compareTo(o2.getOrderSequence());
						  }
						});
					break;
			case S : sellerOrders.add(newOrder);
					 Collections.sort(sellerOrders, new Comparator<Order>(){
						  public int compare(Order o1, Order o2){
							  int comparisonResult = ((Double)o1.getPrice()).compareTo(o2.getPrice());
							  if(comparisonResult != 0)
								  return comparisonResult;
							  else
								  return ((Long)o1.getOrderSequence()).compareTo(o2.getOrderSequence());
						  }
						});
					break;
		}
	}
	
	@Override
	public void completeOrder(Order completedOrder) {
		
		switch(completedOrder.getOrderType()){	
			case B : buyerOrders.remove(completedOrder);
					 completedOrders.add(completedOrder);
					break;
			case S : sellerOrders.remove(completedOrder);
			 		 completedOrders.add(completedOrder);
					break;
		}
	}
	
	@Override
	public void completeNewOrder(Order completedNewOrder) {
		
		switch(completedNewOrder.getOrderType()){	
			case B : completedOrders.add(completedNewOrder);
					break;
			case S : completedOrders.add(completedNewOrder);
					break;
		}
	}

	@Override
	public Map<String, List<Order>> getSortedSidesOrderList() {
		Map<String,List<Order>> orderBookLists = new HashMap<String,List<Order>>();
		
		List<Order> buyersOrders = getBuyerOrders();
		Collections.sort(buyersOrders, new Comparator<Order>(){
												  public int compare(Order o1, Order o2){
												    return ((Double)o2.getPrice()).compareTo(o1.getPrice());
												  }
												});

		List<Order> sellersOrders = getSellerOrders();
		Collections.sort(sellersOrders, new Comparator<Order>(){
												  public int compare(Order o1, Order o2){
												    return ((Double)o1.getPrice()).compareTo(o2.getPrice());
												  }
												});

		orderBookLists.put(OrderType.B.getTypeValue(), buyersOrders);
		orderBookLists.put(OrderType.S.getTypeValue(), sellersOrders);

		return orderBookLists;
	}

	@Override
	public Map<String, Map<String, Long>> getSidesPriceMap() {
		
		Map<String,Map<String,Long>> sidesMapping = new HashMap<String,Map<String, Long>>();
		
		Map<String,Long> buyerMapping = new TreeMap<String,Long>();
		for(Order buyerOrder : getBuyerOrders()){
			Double price = buyerOrder.getPrice();
			Long qty = buyerOrder.getQuantityLeft();
			if(buyerMapping.containsKey(price.toString()))
				buyerMapping.put(price.toString(),buyerMapping.get(price.toString()) + qty);
			else
				buyerMapping.put(price.toString(),qty);
		}
		Map<String,Long> sellerMapping = new TreeMap<String,Long>(Collections.reverseOrder());
		for(Order sellerrOrder : getSellerOrders()){
			Double price = sellerrOrder.getPrice();
			Long qty = sellerrOrder.getQuantityLeft();
			if(sellerMapping.containsKey(price.toString()))
				sellerMapping.put(price.toString(),sellerMapping.get(price.toString()) + qty);
			else
				sellerMapping.put(price.toString(),qty);
		}
		
		sidesMapping.put(OrderType.B.getTypeValue(), buyerMapping);
		sidesMapping.put(OrderType.S.getTypeValue(), sellerMapping);

		return sidesMapping;
	}

	
	
}
