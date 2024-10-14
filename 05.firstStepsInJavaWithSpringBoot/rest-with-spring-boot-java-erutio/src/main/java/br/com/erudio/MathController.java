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
	
	@RequestMapping(value = "/sub/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double sub(
		@PathVariable(value ="numberOne") String numberOne,
	    @PathVariable(value ="numberTwo") String numberTwo) {
			if (!isNumeric(numberOne) || !isNumeric(numberTwo) ) {
				throw new UnsupportedMathOperationException("Please set a numeric value");
			}

			return ConvertToDouble(numberOne) - ConvertToDouble(numberTwo);
	}

	@RequestMapping(value = "/mult/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double mult(
		@PathVariable(value ="numberOne") String numberOne,
	    @PathVariable(value ="numberTwo") String numberTwo) {
			if (!isNumeric(numberOne) || !isNumeric(numberTwo) ) {
				throw new UnsupportedMathOperationException("Please set a numeric value");
			}

			return ConvertToDouble(numberOne) * ConvertToDouble(numberTwo);
	}

	@RequestMapping(value = "/div/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double div(
		@PathVariable(value ="numberOne") String numberOne,
	    @PathVariable(value ="numberTwo") String numberTwo) {
			if (!isNumeric(numberOne) || !isNumeric(numberTwo) ) {
				throw new UnsupportedMathOperationException("Please set a numeric value");
			}

			return ConvertToDouble(numberOne) / ConvertToDouble(numberTwo);
	}

	@RequestMapping(value = "/med/{numberOne}/{numberTwo}/{numberTree}", method=RequestMethod.GET)
	public Double med(
		@PathVariable(value ="numberOne") String numberOne,
	    @PathVariable(value ="numberTwo") String numberTwo,
		@PathVariable(value = "numberTree") String numberTree) {
			if (!isNumeric(numberOne) || !isNumeric(numberTwo) || !isNumeric(numberTree) ) {
				throw new UnsupportedMathOperationException("Please set a numeric value");
			}

			return ((ConvertToDouble(numberOne) + ConvertToDouble(numberTwo) + ConvertToDouble(numberTree))/3);
	}

	@RequestMapping(value = "/raiz/{numberOne}", method=RequestMethod.GET)
	public Double raiz(
		@PathVariable(value ="numberOne") String numberOne) {
			if (!isNumeric(numberOne) ) {
				throw new UnsupportedMathOperationException("Please set a numeric value");
			}

			Double raiz = Math.sqrt(ConvertToDouble(numberOne));

			return raiz;
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
