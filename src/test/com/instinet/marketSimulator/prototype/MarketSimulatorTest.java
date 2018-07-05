package test.com.instinet.marketSimulator.prototype;

import main.com.instinet.marketSimulator.prototype.MarketSimulator;
import main.com.instinet.marketSimulator.prototype.client.OutputPrinterIf;
import main.com.instinet.marketSimulator.prototype.validate.OrderValidatorIf;
import test.com.instinet.marketSimulator.prototype.client.console.FakeConsoleInputListener;
import test.com.instinet.marketSimulator.prototype.client.console.FakeConsoleOutputPrinter;
import test.com.instinet.marketSimulator.prototype.entity.FakeSingleStockOrderBook;
import test.com.instinet.marketSimulator.prototype.singleStock.FakeSingleStockTradingStrategy;
import test.com.instinet.marketSimulator.prototype.singleStock.validate.FakeSingleStockOrderValidator;


public class MarketSimulatorTest {
	
	public void testSimulate() {
		
		MarketSimulator marKetSimulator = new MarketSimulator();
		
		OutputPrinterIf printer = new FakeConsoleOutputPrinter();
		OrderValidatorIf orderValidator = new FakeSingleStockOrderValidator(printer);
		marKetSimulator.setInputReader(new FakeConsoleInputListener(orderValidator));
		marKetSimulator.setOutputWriter(printer);
		marKetSimulator.setOrderBook(new FakeSingleStockOrderBook());
		marKetSimulator.setTradingStrategy(new FakeSingleStockTradingStrategy());		
		
		marKetSimulator.simulate();
		//here unit tests should be written with the use of junit library.
		//unit tests not completed as junit is not standard java library
		
	}
}
