package is.ru.stringcalc;
import java.util.ArrayList; 

public class Calculator {

	public static int add (String text) {

		if(text.equals("")){
			return 0; 
		}
		else {
			if(text.contains("//")){
				return sum(removingDelim(text)); 
			}
			else if (text.contains(",") || text.contains("\n")){
				String numbers [] = text.split(delim);
				return sum(numbers); 
			}
			return 1; 
		}
	}

	private static int toInt (String number) {
		return Integer.parseInt(number);
	}

	private static int sum (String[] numbers) {
		int total = 0;
		ArrayList<Integer> neg = new ArrayList<Integer>(); 

		for(String number : numbers) {
			if (toInt(number) > 1000){

			}
			else if(toInt(number) < 0){
				neg.add(toInt(number)); 
			}
			else
				total += toInt(number); 
		}

		if(neg.size() > 0){
			throw new RuntimeException("Negatives not allowed: " + neg); 
		}
		return total;
	}

	private static String [] removingDelim(String numbers){
		int index = numbers.indexOf("//") + 2;
		delim = delim + "|" + numbers.substring(index,index + 1); 
		numbers = numbers.substring(index + 2); 
		return numbers.split(delim); 
	}

	private static String delim = "\n|," ; 

}