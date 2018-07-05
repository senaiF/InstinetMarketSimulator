package main.com.instinet.marketSimulator.prototype;

import java.util.List;
import main.com.instinet.marketSimulator.prototype.entity.Order;
import main.com.instinet.marketSimulator.prototype.entity.OrderBookIf;
import main.com.instinet.marketSimulator.prototype.entity.TradeIf;

public interface TradingStrategyIf {
	List<TradeIf> processTrades(Order order, OrderBookIf orderBook);
}
