public class Solution {
    public int atoi(final String a) {
        String digits = extractDigits(a);
        if (digits.length() == 0) return 0; //Did not found a number

        final boolean isPositive = digits.charAt(0) != '-';
        final int last = digits.length() - 1;
        final int first = Character.isDigit(digits.charAt(0)) ? 0 : 1;

        int value = 0;
        int factor = isPositive ? 1 : - 1;

        try {
            for (int i = last; i >= first; i--) {
                int curDigit = digits.charAt(i) - '0';
                int installment = safeMult(curDigit, factor);
                value = safeSum(value, installment);
                if (i != first) {
                    // Prevent possible overflow for a factor that won't be used
                    // We always calc for the next interaction,
                    factor = safeMult(factor, 10); //rethink
                }
            }
        } catch (UnderFlowException e) {
            return Integer.MIN_VALUE;
        } catch (OverFlowException e) {
            return Integer.MAX_VALUE;
        }

        return value;
    }

    static class UnderFlowException extends Exception {
    }

    static class OverFlowException extends Exception {
    }

    private int safeSum(int a, int b) throws UnderFlowException, OverFlowException {
        if (a > 0 && b > Integer.MAX_VALUE - a) throw new OverFlowException();
        if (a < 0 && b < Integer.MIN_VALUE - a) throw new UnderFlowException();
        return  a + b;
    }

    private int safeMult(int a, int b) throws UnderFlowException, OverFlowException {
        if (a > 0 && b > 0 &&  b > (Integer.MAX_VALUE/a)) throw new OverFlowException();
        if (a < 0 && b < 0  && b < (Integer.MAX_VALUE/a)) throw new OverFlowException();
        if (a < -1 && b > 0 && b > (Integer.MIN_VALUE/a)) throw new UnderFlowException();//Avoid special case MIN and -1
        if (a > 0 && b < 0 && b < (Integer.MIN_VALUE/a)) throw new UnderFlowException();

        return a * b;
    }

    private String extractDigits(String text) {
        final int size = text.length();
        int i = 0;
        StringBuilder number = new StringBuilder();

        //Consume extranous chars at beginning
        while(i < size && !Character.isDigit(text.charAt(i)) && text.charAt(i) != '-' & text.charAt(i) != '+') {
            if (!Character.isWhitespace(text.charAt(i))) return "";
            i++;
        }

        if (i >= size)  return ""; // no digits found
        if ((text.charAt(i) == '-' || text.charAt(i) == '+') && (i == size - 1)) return "" ; // string ends in -
        number.append(text.charAt(i)); // a number or minus symbol
        i++;

        while (i < size && Character.isDigit(text.charAt(i))) {
            number.append(text.charAt(i));
            i++;
        }

        return number.toString();
    }
}

