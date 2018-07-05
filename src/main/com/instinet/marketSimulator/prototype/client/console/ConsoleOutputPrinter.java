package main.com.instinet.marketSimulator.prototype.client.console;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import main.com.instinet.marketSimulator.prototype.client.OutputPrinterIf;
import main.com.instinet.marketSimulator.prototype.entity.OrderBookIf;
import main.com.instinet.marketSimulator.prototype.entity.TradeIf;

public class ConsoleOutputPrinter implements OutputPrinterIf {

	@Override
	public void printTrades(List<TradeIf> trades) {
		for(TradeIf trade : trades){
			System.out.println(trade.toString());
		}
		
	}

	@Override
	public void printOrderBook(OrderBookIf orderBook) {
		
		Map<String,Map<String,Long>> sidesOrderList = orderBook.getSidesPriceMap();
		Set<String> sides = sidesOrderList.keySet();
		Map<String,Object[]> priceQtyMap = new HashMap<String,Object[]>();
		long longestList = 0;
		for(String side:sides){
			System.out.printf("%25s", side + "        |");
			longestList = (longestList < sidesOrderList.get(side).size())? sidesOrderList.get(side).size(): longestList;
			Set priceQtyset = sidesOrderList.get(side).entrySet();
			priceQtyMap.put(side, priceQtyset.toArray());
		}
		System.out.println();
		for(int i= 0; i < longestList; i++){
			for(String side:sides){
				Object[] priceQtyArray = priceQtyMap.get(side);
				if(i < priceQtyArray.length){
					Map.Entry priceQty = (Map.Entry)priceQtyArray[i];
					System.out.printf("%25s", priceQty.getValue() + "@" + priceQty.getKey() + "   |");
				}
				else{
					System.out.printf("%25s","   |");					
				}
			}
			System.out.printf(" %n");
		}
		
		
	}

	@Override
	public void printErrorMessage(String errorMessage) {
		System.out.println(errorMessage);		
	}

}
