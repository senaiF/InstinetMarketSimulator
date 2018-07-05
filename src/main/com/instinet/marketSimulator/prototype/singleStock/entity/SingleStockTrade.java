package main.com.instinet.marketSimulator.prototype.singleStock.entity;

import main.com.instinet.marketSimulator.prototype.entity.Order;
import main.com.instinet.marketSimulator.prototype.entity.TradeIf;

public class SingleStockTrade implements TradeIf {

	long tradeId;
	Order BuyerOrder;
	Order SellerOrder;
	long quantityTraded;
	double tradePrice;

	
	public SingleStockTrade(Order buyerOrder, Order sellerOrder, long quantityTraded, double tradePrice) {
		super();
		BuyerOrder = buyerOrder;
		SellerOrder = sellerOrder;
		this.quantityTraded = quantityTraded;
		this.tradePrice = tradePrice;
		
		buyerOrder.makeATrade(this);
		sellerOrder.makeATrade(this);
	}

	@Override
	public long getTradeId() {
		return tradeId;
	}

	@Override
	public Order getBuyerOrder() {
		return BuyerOrder;
	}

	@Override
	public Order getSellerOrder() {
		return SellerOrder;
	}

	@Override
	public long getQuantityTraded() {
		return quantityTraded;
	}

	@Override
	public double getTradePrice() {
		return tradePrice;
	}

	@Override
	public String toString(){
		return quantityTraded + "@" + tradePrice;
		
	}


}
