/*
class Node {
    int data;
    Node next;
    Node bottom;

    Node(int x) {
        data = x;
        next = null;
        bottom = null;
    }
}
*/
class Solution {
    public Node flatten(Node root) {
        // code here
       
       if (root == null || root.next == null)
          return root;

       // Step 1: Flatten the list on the right
       root.next = flatten(root.next);

       // Step 2: Merge current list with the flattened right-side list
       root = merge(root, root.next);

       return root;
    }
    public Node merge(Node a, Node b) {
       if (a == null) return b;
       if (b == null) return a;

       Node result;

       if (a.data < b.data) {
          result = a;
          result.bottom = merge(a.bottom, b);
       } else {
           result = b;
           result.bottom = merge(a, b.bottom);
       }

       result.next = null;   // IMPORTANT: remove next pointer
       return result;
   }
}

    