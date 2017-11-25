public class Solution {
	// DO NOT MODIFY THE LIST. IT IS READ ONLY
	public int kthsmallest(final List<Integer> a, int k) {
        final KMinTree tree = new KMinTree(k);
        for (Integer value: a) {
            tree.add(value);
        }
        
        return tree.max();
	}

    // A binary tree that only keep the smallest k elements
    public static class KMinTree {
    
        private static class Node {
            int value;
            Node left;
            Node right;
    
            Node(int value) {
                this.value = value;
                this.left = null;
                this.right = null;
            }
        }
    
        private Node root;
        private int size = 0;
    
        private final int maxSize;
    
        public KMinTree(int k) {
            this.maxSize = k > 0 ? k : 1;
        }
    
        public void add(int value) {
            root = add(root, value);
            size++;
    
            if (size > maxSize) pruneMaxNode();
        }
    
        private Node add(Node node, int value) {
            if (node == null) {
                return new Node(value);
            } else {
                if (value < node.value) {
                    node.left  = add(node.left, value);
                } else {
                    node.right = add(node.right, value);
                }
                return node;
            }
        }
    
        private void pruneMaxNode() {
            Node parent = null;
            Node curr = root;
    
            while (curr.right != null) {
                parent = curr;
                curr = curr.right;
            }
    
            if (parent == null) { // max node is root
                root = root.left;
            } else {
                parent.right = curr.left;
            }
    
            size--;
        }
    
        public int max() {
            if (root == null) throw new IllegalStateException("Tree is empty");
    
            Node curr = root;
            while (curr.right != null) curr = curr.right;
            return curr.value;
        }
    
    }

}
