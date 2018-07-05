package test.com.instinet.marketSimulator.prototype.singleStock.validate;

import main.com.instinet.marketSimulator.prototype.client.OutputPrinterIf;
import main.com.instinet.marketSimulator.prototype.validate.OrderValidatorIf;

public class FakeSingleStockOrderValidator implements OrderValidatorIf{

	OutputPrinterIf outputPrinter;

	
	public FakeSingleStockOrderValidator(OutputPrinterIf outputPrinter) {
		super();
		this.outputPrinter = outputPrinter;
	}



	@Override
	public boolean validateOrderInputValues(String[] inputOrderValues) {
		// TODO Auto-generated method stub
		return false;
	}

}
