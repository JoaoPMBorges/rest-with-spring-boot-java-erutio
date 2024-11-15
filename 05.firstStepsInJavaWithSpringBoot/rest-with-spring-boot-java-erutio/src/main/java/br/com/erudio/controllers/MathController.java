package br.com.erudio.controllers;

import java.util.concurrent.atomic.AtomicLong;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.converters.NumberConverter;
import br.com.erudio.exceptions.UnsupportedMathOperationException;
import br.com.erudio.math.SimpleMath;

@RestController
public class MathController {
	 private SimpleMath math = new SimpleMath();
	private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping(value ="/sum/{numberOne}/{numberTwo}",
			method=RequestMethod.GET)
	public Double sum(
	  @PathVariable(value = "numberOne") String numberOne,
	  @PathVariable(value = "numberTwo")String numberTwo
	  ) throws UnsupportedMathOperationException {
		if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo) ) {
			throw new UnsupportedMathOperationException("Please set a numeric value");
		}
		return  math.sum( NumberConverter.ConvertToDouble(numberOne), NumberConverter.ConvertToDouble(numberTwo)) ; 
	}
	
	@RequestMapping(value = "/sub/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double sub(
		@PathVariable(value ="numberOne") String numberOne,
	    @PathVariable(value ="numberTwo") String numberTwo) {
			if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo) ) {
				throw new UnsupportedMathOperationException("Please set a numeric value");
			}

			return math.sub( NumberConverter.ConvertToDouble(numberOne), NumberConverter.ConvertToDouble(numberTwo)) ;
	}

	@RequestMapping(value = "/mult/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double mult(
		@PathVariable(value ="numberOne") String numberOne,
	    @PathVariable(value ="numberTwo") String numberTwo) {
			if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo) ) {
				throw new UnsupportedMathOperationException("Please set a numeric value");
			}

			return math.mult( NumberConverter.ConvertToDouble(numberOne), NumberConverter.ConvertToDouble(numberTwo)) ;
	}

	@RequestMapping(value = "/div/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double div(
		@PathVariable(value ="numberOne") String numberOne,
	    @PathVariable(value ="numberTwo") String numberTwo) {
			if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo) ) {
				throw new UnsupportedMathOperationException("Please set a numeric value");
			}

			return math.div( NumberConverter.ConvertToDouble(numberOne), NumberConverter.ConvertToDouble(numberTwo)) ;
	}

	@RequestMapping(value = "/med/{numberOne}/{numberTwo}/{numberTree}", method=RequestMethod.GET)
	public Double med(
		@PathVariable(value ="numberOne") String numberOne,
	    @PathVariable(value ="numberTwo") String numberTwo,
		@PathVariable(value = "numberTree") String numberTree) {
			if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo) || !NumberConverter.isNumeric(numberTree) ) {
				throw new UnsupportedMathOperationException("Please set a numeric value");
			}
 
			return math.med( NumberConverter.ConvertToDouble(numberOne), NumberConverter.ConvertToDouble(numberTwo),NumberConverter.ConvertToDouble(numberTree) ) ;
	}

	@RequestMapping(value = "/raiz/{numberOne}", method=RequestMethod.GET)
	public Double raiz(
		@PathVariable(value ="numberOne") String numberOne) {
			if (!NumberConverter.isNumeric(numberOne) ) {
				throw new UnsupportedMathOperationException("Please set a numeric value");
			}

			

			return math.raiz( NumberConverter.ConvertToDouble(numberOne)) ;
	}

	
	
}
