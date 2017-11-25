public class Solution {
	public void setZeroes(ArrayList<ArrayList<Integer>> a) {
	    final int nLines = a.size();
	    final int nColumns = a.get(0).size();
	    
	    boolean lineHasZeros = false;
	    for (int i = 0; i < nColumns; i++) {
	        if (a.get(0).get(i).equals(0)) {
	            lineHasZeros = true;
	            break;
	        } 
	    }
	    
	    boolean columnHasZero = false;
	    for (int i = 0; i < nLines; i++) {
	        if (a.get(i).get(0).equals(0)) {
	            columnHasZero = true;
	            break;
	        }
	    }
	    
	    for (int lin = 1; lin < nLines; lin++) {
	        for (int col = 1; col < nColumns; col++) {
	            if (a.get(lin).get(col).equals(0)) {
	                a.get(0).set(col, 0);
	                a.get(lin).set(0, 0);
	            }
	        }
	    }
	    
	    for (int col = 1; col < nColumns; col++) {
	        if (a.get(0).get(col).equals(0)) {
	            for (int lin = 1; lin < nLines; lin ++) {
	                a.get(lin).set(col, 0);
	            }
	        }
	    }
	    
	    for(int lin = 1; lin < nLines; lin++) {
	        if (a.get(lin).get(0).equals(0)) {
	            for(int col = 1; col < nColumns; col++) {
	                a.get(lin).set(col, 0);
	            }
	        }
	    }
	    
	    if (lineHasZeros) {
	        for (int col = 0; col < nColumns; col++) {
	            a.get(0).set(col, 0);
	        }
	    }
	    
	    if (columnHasZero) {
	        for (int lin = 0; lin < nLines; lin++) {
	            a.get(lin).set(0, 0);
	        }
	    }
	}
}

