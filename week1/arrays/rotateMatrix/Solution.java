public class Solution {
	public void rotate(ArrayList<ArrayList<Integer>> a) {
	    if (a.size() < 1) return;
	    final int nLayers = a.size() / 2;
        for (int layer = 0; layer < nLayers; layer++) {
            rotateLayer(a, layer);
        }
	}
	
	
	    static void rotateLayer(ArrayList<ArrayList<Integer>> matrix, int layer) {
        final int start = layer;
        final int end = matrix.size() - 1 - layer;

        for (int i = start; i < end; i++) {
            int offset = i - start;
            int top = matrix.get(start).get(i); //save top
            matrix.get(start).set(i, matrix.get(end - offset).get(start)); // left -> top
            matrix.get(end - offset).set(start, matrix.get(end).get(end - offset)); //bottom -> left
            matrix.get(end).set(end - offset, matrix.get(i).get(end)); //right -> bottom
            matrix.get(i).set(end, top);
        }
    }
}

