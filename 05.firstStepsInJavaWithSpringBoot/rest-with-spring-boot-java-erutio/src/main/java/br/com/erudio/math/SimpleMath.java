package br.com.erudio.math;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.erudio.converters.NumberConverter;
import br.com.erudio.exceptions.UnsupportedMathOperationException;

public class SimpleMath {
	public Double sum( Double numberOne,Double numberTwo ) {

				return  (numberOne) +  (numberTwo);
			}
			

			public Double sub(Double numberOne,Double numberTwo) {

					return  (numberOne) -  (numberTwo);
			}


			public Double mult( Double numberOne,Double numberTwo) {

					return  (numberOne) *  (numberTwo);
			}


			public Double div( Double numberOne, Double numberTwo) {

					return  (numberOne) /  (numberTwo);
			}


			public Double med( Double numberOne, Double numberTwo, Double numberTree) {

					return (( (numberOne) +  (numberTwo) +  (numberTree))/3);
			}


			public Double raiz( Double numberOne) {
					Double raiz = Math.sqrt( (numberOne));

					return raiz;
			}
}
