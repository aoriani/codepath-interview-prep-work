public class Solution {
	public ArrayList<ArrayList<Integer>> prettyPrint(int a) {
	    
	    //init matrix
	    final int matrixDim = 2 * a - 1;
	    ArrayList<ArrayList<Integer>> result = new ArrayList<>(matrixDim);
	    for (int i = 0; i < matrixDim; i++) {
	        result.add(new ArrayList<Integer>(matrixDim));
	        for (int j = 0; j < matrixDim; j++) {
	            result.get(i).add(0);
	        }
	    }
	    
	    for (int j = 0; j < a; j++) {
	        int value = a - j;
	        int max = matrixDim - 1 - j;
	        fillMatrix(result, value, j, max);     
	    }
	    
	    return result;
	}
	
	private void fillMatrix(ArrayList<ArrayList<Integer>> matrix, int value, int lo, int hi) {
	    for (int lin = lo; lin <= hi; lin++) {
	        if (lin == lo || lin == hi) {
	            for (int col = lo; col <= hi; col++) {
	                matrix.get(lin).set(col, value);
	            }
	        } else {
	            matrix.get(lin).set(lo, value);
	            matrix.get(lin).set(hi, value);
	        }
	    }
	}
}
