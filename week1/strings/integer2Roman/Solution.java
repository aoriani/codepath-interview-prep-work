public class Solution {
    
    static final String thousandsStr[] = {"", "M", "MM", "MMM"};
	static final String hundredsStr[] = {"", "C", "CC", "CCC", "CD", "D",
	                                    "DC", "DCC", "DCCC", "CM"};
	static final String tensStr[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", 
	                                "XC"};
    static final String unitsStr[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII",
                                        "IX"};
    
	public String intToRoman(int a) {
	   final StringBuilder result = new StringBuilder();
	   
	   //Extract Thousands
	   int thousands = a / 1000;
	   result.append(thousandsStr[thousands]);

	   //Extract hundreds
	   a %= 1000 ;
	   int hundreds = a/100;
	   result.append(hundredsStr[hundreds]);
	   
	   //Extract tens
	   a %= 100;
	   int tens = a/10;
	   result.append(tensStr[tens]);
	   
	   //Extact units
	   a %= 10;
	   result.append(unitsStr[a]);

	   return result.toString();
	}
}

