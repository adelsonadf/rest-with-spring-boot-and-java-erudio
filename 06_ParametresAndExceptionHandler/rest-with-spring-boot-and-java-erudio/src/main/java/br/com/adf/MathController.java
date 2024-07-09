package br.com.adf;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class MathController {
		private final AtomicLong counter = new AtomicLong();
		@RequestMapping(value = "/sum/{number1}/{number2}",method=RequestMethod.GET)
		public Double sum
					(@PathVariable(value = "number1") String number1,
					 @PathVariable(value = "number2") String number2
		    ) throws Exception {

//			if (isNumeric(number1) || isNumeric(number2)) throw new Exception();
			return convertToDouble(number1) + convertToDouble(number2) ;
		}

	private Double convertToDouble(String strNumber) {
		if (strNumber == null) return 0D;
		String number = strNumber.replaceAll(",",".");
		if (isNumeric(number)) return Double.parseDouble(number);
		return 0D;
	}

	private boolean isNumeric(String strNumber) {
		if(strNumber == null)	return false;
		String number = strNumber.replaceAll(",",".");
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}

}
