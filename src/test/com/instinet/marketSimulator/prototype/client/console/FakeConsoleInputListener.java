package test.com.instinet.marketSimulator.prototype.client.console;

import main.com.instinet.marketSimulator.prototype.client.InputListenerIf;
import main.com.instinet.marketSimulator.prototype.entity.Order;
import main.com.instinet.marketSimulator.prototype.validate.OrderValidatorIf;

public class FakeConsoleInputListener implements InputListenerIf {

	OrderValidatorIf orderValidator;

	
	public FakeConsoleInputListener(OrderValidatorIf orderValidator) {
		super();
		this.orderValidator = orderValidator;
	}


	@Override
	public Order listenOrder() {
		// TODO Auto-generated method stub
		return null;
	}

}
