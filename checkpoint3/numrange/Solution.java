public class Solution {
	public int numRange(ArrayList<Integer> a, int b, int c) {
	    int nSeq = 0;
	    final int nCount = a.size();
	    
	    for (int i = 0; i < nCount; i++) {
	        int sum = 0;
	        for (int j = i; j < nCount; j++) {
	            sum += a.get(j);
	            if (b <= sum && sum <= c) {
	                nSeq++;
	            } else if (sum > c) {
	                break;
	            }
	        }
	    }
	    
	    return nSeq;
	}
}
