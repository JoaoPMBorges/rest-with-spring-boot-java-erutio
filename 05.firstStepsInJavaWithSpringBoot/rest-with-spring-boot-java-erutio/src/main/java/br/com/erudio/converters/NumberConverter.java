package br.com.erudio.converters;

public class NumberConverter {

	public static Double ConvertToDouble(String number) {
		if(number == null)return 0D;
		String valor = number.replaceAll(",", ".");
		if(isNumeric(valor)) return Double.parseDouble(valor); 
		return 0D;
	}

	public static boolean isNumeric(String number) {
		if(number == null)return false;
		String valor = number.replaceAll(",", ".");
		return valor.matches("[-+]?[0-9]*\\.?[0-9]+");
		
		
	}
}
