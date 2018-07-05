package main.com.instinet.marketSimulator.prototype.singleStock.validate;

import main.com.instinet.marketSimulator.prototype.client.OutputPrinterIf;
import main.com.instinet.marketSimulator.prototype.entity.OrderType;
import main.com.instinet.marketSimulator.prototype.util.EnumUtils;
import main.com.instinet.marketSimulator.prototype.util.NumberUtils;
import main.com.instinet.marketSimulator.prototype.validate.OrderValidatorIf;

public class SingleStockOrderValidator implements OrderValidatorIf{
	
	OutputPrinterIf outputPrinter;
	
	public SingleStockOrderValidator(OutputPrinterIf outputPrinter) {
		super();
		this.outputPrinter = outputPrinter;
	}

	public void setOutputPrinter(OutputPrinterIf outputPrinter) {
		this.outputPrinter = outputPrinter;
	}

	@Override
	public boolean validateOrderInputValues(String[] inputOrderValues) {
		
		if(inputOrderValues.length != 3){
			
			outputPrinter.printErrorMessage("Invalid Order: 3 values(Side, Quantity,Price) separated by a space should be entered for an order. Example-\n B 100 9.9 \n Please reenter your order. ");
			return false;
			
		}else if(inputOrderValues[0].length() != 1 || !EnumUtils.isInEnum(inputOrderValues[0], OrderType.class)){
			
			outputPrinter.printErrorMessage("Invalid Order: First value(Side) of order should be just one character from  " + OrderType.values());
			return false;
			
		}else {
					
			try{
				long qty = Long.parseLong(inputOrderValues[1]);	
				if( qty <= 0)
					throw new NumberFormatException();					
			}catch(NumberFormatException nfe){
				outputPrinter.printErrorMessage("Invalid Order: Second value(Quantity) of order should be a number one character from  " + OrderType.values());
				return false;
			}

			
			try{
				double price = Double.parseDouble(inputOrderValues[2]);				
				if(price < 0 || !NumberUtils.isNumberWithLessThanThreeDecimalPlaces(price))
					throw new NumberFormatException();		
			}catch(NumberFormatException nfe){
				outputPrinter.printErrorMessage("Invalid Order: Third value(Price) of order should be a number value greater than zero to 3 decimal places.");
				return false;
			}
	
		}

		return true;
	}
	

}
