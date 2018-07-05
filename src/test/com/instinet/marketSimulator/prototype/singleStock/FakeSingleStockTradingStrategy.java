package test.com.instinet.marketSimulator.prototype.singleStock;

import java.util.List;

import main.com.instinet.marketSimulator.prototype.TradingStrategyIf;
import main.com.instinet.marketSimulator.prototype.entity.Order;
import main.com.instinet.marketSimulator.prototype.entity.OrderBookIf;
import main.com.instinet.marketSimulator.prototype.entity.TradeIf;

public class FakeSingleStockTradingStrategy implements TradingStrategyIf {

	@Override
	public List<TradeIf> processTrades(Order order, OrderBookIf orderBook) {
		// TODO Auto-generated method stub
		return null;
	}

}
