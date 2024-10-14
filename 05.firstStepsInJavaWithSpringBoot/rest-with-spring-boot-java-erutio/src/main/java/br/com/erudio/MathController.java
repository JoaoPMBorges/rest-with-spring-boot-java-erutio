package br.com.erudio;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.exceptions.UnsupportedMathOperationException;

@RestController
public class MathController {
	
	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping(value ="/sum/{numberOne}/{numberTwo}",
			method=RequestMethod.GET)
	public Double sum(
	  @PathVariable(value = "numberOne") String numberOne,
	  @PathVariable(value = "numberTwo")String numberTwo
	  ) throws UnsupportedMathOperationException {
		if (!isNumeric(numberOne) || !isNumeric(numberTwo) ) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}
		return ConvertToDouble(numberOne) + ConvertToDouble(numberTwo);
	}

	private Double ConvertToDouble(String number) {
		if(number == null)return 0D;
		String valor = number.replaceAll(",", ".");
		if(isNumeric(valor)) return Double.parseDouble(valor); 
		return 0D;
	}

	private boolean isNumeric(String number) {
		if(number == null)return false;
		String valor = number.replaceAll(",", ".");
		return valor.matches("[-+]?[0-9]*\\.?[0-9]+");
		
		
	}
	
}
