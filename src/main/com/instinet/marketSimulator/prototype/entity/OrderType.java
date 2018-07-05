package main.com.instinet.marketSimulator.prototype.entity;

//OrderType is referenced as side in requirements
public enum OrderType {
	
	B("BUY"), S("SELL");
	
	private String typeValue;
		
	public String getTypeValue() {
		return this.typeValue;
	}
	   
	OrderType(String typeValue) {
		this.typeValue = typeValue;
	}

}
