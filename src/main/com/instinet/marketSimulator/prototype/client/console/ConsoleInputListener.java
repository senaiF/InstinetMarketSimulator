package main.com.instinet.marketSimulator.prototype.client.console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import main.com.instinet.marketSimulator.prototype.client.InputListenerIf;
import main.com.instinet.marketSimulator.prototype.entity.Order;
import main.com.instinet.marketSimulator.prototype.entity.OrderType;
import main.com.instinet.marketSimulator.prototype.validate.OrderValidatorIf;

public class ConsoleInputListener implements InputListenerIf {

	OrderValidatorIf orderValidator;
	
	
	public ConsoleInputListener(OrderValidatorIf orderValidator) {
		super();
		this.orderValidator = orderValidator;
	}

	public void setOrderValidator(OrderValidatorIf orderValidator) {
		this.orderValidator = orderValidator;
	}

	@Override
	public Order listenOrder() {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String inputString ="";
		try {
			inputString = reader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		String[] orderValues =  inputString.split(" ");		
		if(orderValidator.validateOrderInputValues(orderValues)){
			try{
				OrderType side = OrderType.valueOf(orderValues[0]);
				long qty = Long.parseLong(orderValues[1]);
				double price = Double.parseDouble(orderValues[2]);
				
				return new Order(side, qty, price);
			}catch(NumberFormatException nfe){
				return null;
			}
		}else
			return null;
	}

}
