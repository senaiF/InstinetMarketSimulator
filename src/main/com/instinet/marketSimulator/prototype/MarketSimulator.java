package main.com.instinet.marketSimulator.prototype;

import java.util.List;

import main.com.instinet.marketSimulator.prototype.client.OutputPrinterIf;
import main.com.instinet.marketSimulator.prototype.client.InputListenerIf;
import main.com.instinet.marketSimulator.prototype.entity.Order;
import main.com.instinet.marketSimulator.prototype.entity.OrderBookIf;
import main.com.instinet.marketSimulator.prototype.entity.TradeIf;

public class MarketSimulator {

	protected InputListenerIf inputListener;
	protected OutputPrinterIf outputPrinter;
	protected TradingStrategyIf tradingStrategy;
	protected OrderBookIf orderBook;

	public void setInputReader(InputListenerIf inputReader) {
		this.inputListener = inputReader;
	}

	public void setOutputWriter(OutputPrinterIf outputWriter) {
		this.outputPrinter = outputWriter;
	}

	public void setTradingStrategy(TradingStrategyIf tradingStrategy) {
		this.tradingStrategy = tradingStrategy;
	}

	public void setOrderBook(OrderBookIf orderBook) {
		this.orderBook = orderBook;
	}

	public void simulate() {
		
		Order newOrder = inputListener.listenOrder();
		while( newOrder != null){
			List<TradeIf> trades = tradingStrategy.processTrades(newOrder, orderBook);
			outputPrinter.printTrades(trades);
			outputPrinter.printOrderBook(orderBook);
			
			newOrder = inputListener.listenOrder();
		}
		
	}
	
}
