package main.com.instinet.marketSimulator.prototype.singleStock;

import java.util.ArrayList;
import java.util.List;

import main.com.instinet.marketSimulator.prototype.TradingStrategyIf;
import main.com.instinet.marketSimulator.prototype.entity.Order;
import main.com.instinet.marketSimulator.prototype.entity.OrderBookIf;
import main.com.instinet.marketSimulator.prototype.entity.TradeIf;
import main.com.instinet.marketSimulator.prototype.singleStock.entity.SingleStockOrderBookIf;
import main.com.instinet.marketSimulator.prototype.singleStock.entity.SingleStockTrade;
import main.com.instinet.marketSimulator.prototype.util.NumberUtils;

public class SingleStockTradingStrategy implements TradingStrategyIf {

	@Override
	public List<TradeIf> processTrades(Order order, OrderBookIf orderBook) {
		
		SingleStockOrderBookIf singleStockOrderBook = (SingleStockOrderBookIf) orderBook;
		
		switch(order.getOrderType()){	
			
			case B : return matchSellersForTrade(order,singleStockOrderBook);
					 					 
			case S : return matchBuyersForTrade(order,singleStockOrderBook);

		}
				
		return null;
		
	}
	
	private List<TradeIf> matchSellersForTrade(Order buyOrder, SingleStockOrderBookIf singleStockOrderBook){
		
		List<TradeIf> tradesMade = new ArrayList<TradeIf>();
		
		List<Order> sellerOrders = singleStockOrderBook.getSellerOrders();
		for(Order sellOrder : sellerOrders){
			if(NumberUtils.isGreaterOrEqualPriceThan(buyOrder.getPrice(), sellOrder.getPrice())){
				long tradeQuantity = (buyOrder.getQuantityLeft() <= sellOrder.getQuantityLeft())?buyOrder.getQuantityLeft():sellOrder.getQuantityLeft();
				TradeIf newTrade = new SingleStockTrade(sellOrder, buyOrder, tradeQuantity, sellOrder.getPrice());
				tradesMade.add(newTrade);
				
				if(buyOrder.getQuantityLeft() == 0){
					singleStockOrderBook.completeOrder(buyOrder);
					return tradesMade;
				}
					
				if(sellOrder.getQuantityLeft() == 0){
					singleStockOrderBook.completeOrder(sellOrder);
				}
					
			}
					
		}
		if(buyOrder.getQuantityLeft() != 0)
			singleStockOrderBook.add(buyOrder);

		return tradesMade;	
	}
	
	private List<TradeIf> matchBuyersForTrade(Order sellOrder, SingleStockOrderBookIf singleStockOrderBook){
		
		List<TradeIf> tradesMade = new ArrayList<TradeIf>();
		
		List<Order> BuyerOrders = singleStockOrderBook.getBuyerOrders();
		for(Order buyOrder : BuyerOrders){
			if(NumberUtils.isLessOrEqualPriceThan(sellOrder.getPrice(), buyOrder.getPrice())){
				long tradeQuantity = (sellOrder.getQuantityLeft() <= buyOrder.getQuantityLeft())?sellOrder.getQuantityLeft():buyOrder.getQuantityLeft();
				TradeIf newTrade = new SingleStockTrade(buyOrder, sellOrder, tradeQuantity, buyOrder.getPrice());
				tradesMade.add(newTrade);
				
				if(sellOrder.getQuantityLeft() == 0){
					singleStockOrderBook.completeOrder(sellOrder);
					return tradesMade;
				}else
					singleStockOrderBook.add(sellOrder);

				if(buyOrder.getQuantityLeft() == 0){
					singleStockOrderBook.completeOrder(buyOrder);
				}
					
			}
					
		}
		if(sellOrder.getQuantityLeft() != 0)
			singleStockOrderBook.add(sellOrder);

		return tradesMade;	
	}

}
