package main.com.instinet.marketSimulator.prototype;

import main.com.instinet.marketSimulator.prototype.client.OutputPrinterIf;
import main.com.instinet.marketSimulator.prototype.client.console.ConsoleInputListener;
import main.com.instinet.marketSimulator.prototype.client.console.ConsoleOutputPrinter;
import main.com.instinet.marketSimulator.prototype.singleStock.SingleStockTradingStrategy;
import main.com.instinet.marketSimulator.prototype.singleStock.entity.SingleStockOrderBook;
import main.com.instinet.marketSimulator.prototype.singleStock.validate.SingleStockOrderValidator;
import main.com.instinet.marketSimulator.prototype.util.EnumUtils;
import main.com.instinet.marketSimulator.prototype.validate.OrderValidatorIf;

public class Main {

	public static enum tradingStrategies {
		SingleStock
	}

	public static void main(String[] args) {

		String tradingStrategyToUse = "";
		if (args.length > 0) {
			if (EnumUtils.isInEnum(args[0], tradingStrategies.class)) {
				tradingStrategyToUse = args[0];
			}
		}

		MarketSimulator simulator = new MarketSimulator();

		if (tradingStrategies.SingleStock.equals(tradingStrategyToUse) || "".equals(tradingStrategyToUse)) {
			
			OutputPrinterIf printer = new ConsoleOutputPrinter();
			OrderValidatorIf orderValidator = new SingleStockOrderValidator(printer);
			simulator.setInputReader(new ConsoleInputListener(orderValidator));
			simulator.setOutputWriter(printer);
			simulator.setOrderBook(new SingleStockOrderBook());
			simulator.setTradingStrategy(new SingleStockTradingStrategy());
		}

		simulator.simulate();
	}

}
