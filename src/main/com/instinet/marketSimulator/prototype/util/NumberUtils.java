package main.com.instinet.marketSimulator.prototype.util;

public class NumberUtils {
	
	public static boolean isNumberWithLessThanThreeDecimalPlaces(double number){
		
		String text = Double.toString(number);
		int integerPlaces = text.indexOf('.');
		int decimalPlaces = text.length() - integerPlaces - 1;
		if(decimalPlaces > 3)
			return false;
		else
			return true;
	}
	
	static public boolean isEqualPrice(double x, double y)
	{
		return Math.abs(x-y) < 0.000001;
	}

	static public boolean isGreaterPriceThan(double x, double y)
	{
		return x-y > 0.000001;
	}

	static public boolean isLessPriceThan(double x, double y)
	{
		return y-x > 0.000001;
	}
	
	static public boolean isGreaterOrEqualPriceThan(double x, double y)
	{
		return isEqualPrice(x, y) || isGreaterPriceThan(x,y);
	}
	
	static public boolean isLessOrEqualPriceThan(double x, double y)
	{
		return isEqualPrice(x, y) || isLessPriceThan(x,y);
	}
	
	
}
