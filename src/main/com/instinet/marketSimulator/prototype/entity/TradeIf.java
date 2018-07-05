package main.com.instinet.marketSimulator.prototype.entity;


public interface TradeIf {

	long getTradeId();
	Order getBuyerOrder();
	Order getSellerOrder();
	long getQuantityTraded();
	double getTradePrice();
	
}
