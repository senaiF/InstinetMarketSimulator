package main.com.instinet.marketSimulator.prototype.client;

import java.util.List;

import main.com.instinet.marketSimulator.prototype.entity.OrderBookIf;
import main.com.instinet.marketSimulator.prototype.entity.TradeIf;

public interface OutputPrinterIf {

	void printTrades(List<TradeIf> trades);

	void printOrderBook(OrderBookIf orderBook);

	void printErrorMessage(String errorMessage);
}