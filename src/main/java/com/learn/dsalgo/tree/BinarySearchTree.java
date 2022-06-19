package com.learn.dsalgo.tree;

public class BinarySearchTree<T extends Comparable<T>>  {
  
    // Tracks the number of nodes in this BST
  private int nodeCount = 0;

  // This BST is a rooted tree so we maintain a handle on the root node
  private Node<T> root = null;

  // Internal node containing node references
  // and the actual node data
  private static class Node<T> {
    T data;
    Node<T> left, right;

    public Node(Node<T> left, Node<T> right, T elem) {
      this.data = elem;
      this.left = left;
      this.right = right;
    }

    public String toString() {
      return " "+this.data.toString();
    }
  }
  
  // Check if this binary tree is empty
  public boolean isEmpty() {
    return size() == 0;
  }

  // Get the number of nodes in this binary tree
  public int size() {
    return nodeCount;
  }

  // Add an element to this binary tree. Returns true
  // if we successfully perform an insertion
  public boolean add(T elem) {

    // Check if the value already exists in this
    // binary tree, if it does ignore adding it
    if (contains(elem)) {
      return false;

      // Otherwise add this element to the binary tree
    } else {
      root = add(root, elem);
      nodeCount++;
      return true;
    }
  }

  // Private method to recursively add a value in the binary tree
  private Node<T> add(Node<T> node, T elem) {

    // Base case: found a leaf node
    if (node == null) {
      node = new Node<>(null, null, elem);

    } else {
      // Pick a subtree to insert element
      if (elem.compareTo(node.data) < 0) {
        node.left = add(node.left, elem);
      } else {
        node.right = add(node.right, elem);
      }
    }

    return node;
  }

   // returns true is the element exists in the tree
   public boolean contains(T elem) {
      return contains(root, elem);
  }

  // private recursive method to find an element in the tree
  private boolean contains(Node<T> node, T elem) {

    // Base case: reached bottom, value not found
    if (node == null) return false;

    int cmp = elem.compareTo(node.data);

    // Dig into the left subtree because the value we're
    // looking for is smaller than the current value
    if (cmp < 0) return contains(node.left, elem);

    // Dig into the right subtree because the value we're
    // looking for is greater than the current value
    else if (cmp > 0) return contains(node.right, elem);

    // We found the value we were looking for
    else return true;
  }

  // For traversing in order  
  //Inorder -	Visit left subtree --->	Visit root node	 ---> Visit right subtree
  public void inOrder(Node<T> node)  
  {  
    if(node != null)  
    {  
      inOrder(node.left);  
      System.out.print(node.toString()); 
      inOrder(node.right);  
    }  
  }  
  // Preorder traversal  
  // Preorder -	Visit root node	---> Visit left subtree ---> Visit right subtree
  public void preOrder(Node<T> node)  
  {  
    if(node != null){  
      System.out.print(node.toString());  
      preOrder(node.left);             
      preOrder(node.right);  
    }  
  }  
  // Postorder traversal 
  //Postorder -  Visit left subtree -->	Visit right subtree ---> Visit root node 
  public void postOrder(Node<T> node)  
  {  
    if(node != null)  
    {  
      postOrder(node.left);  
      postOrder(node.right);  
      System.out.print(node.toString());           
    }  
  }  


   // Remove a value from this binary tree if it exists, O(n)
   public boolean remove(T elem) {

    // Make sure the node we want to remove
    // actually exists before we remove it
    if (contains(elem)) {
      root = remove(root, elem);
      nodeCount--;
      return true;
    }
    return false;
  }

  private Node<T> remove(Node<T> node, T elem) {

    if (node == null) return null;

    int cmp = elem.compareTo(node.data);

    // Dig into left subtree, the value we're looking
    // for is smaller than the current value
    if (cmp < 0) {
      node.left = remove(node.left, elem);

      // Dig into right subtree, the value we're looking
      // for is greater than the current value
    } else if (cmp > 0) {
      node.right = remove(node.right, elem);

      // Found the node we wish to remove
    } else {

      // This is the case with only a right subtree or
      // no subtree at all. In this situation just
      // swap the node we wish to remove with its right child.
      if (node.left == null) {
        return node.right;

        // This is the case with only a left subtree or
        // no subtree at all. In this situation just
        // swap the node we wish to remove with its left child.
      } else if (node.right == null) {

        return node.left;

        // When removing a node from a binary tree with two links the
        // successor of the node being removed can either be the largest
        // value in the left subtree or the smallest value in the right
        // subtree. In this implementation I have decided to find the
        // smallest value in the right subtree which can be found by
        // traversing as far left as possible in the right subtree.
      } else {

        // Find the leftmost node in the right subtree
        Node<T> tmp = findMin(node.right);

        // Swap the data
        node.data = tmp.data;

        // Go into the right subtree and remove the leftmost node we
        // found and swapped data with. This prevents us from having
        // two nodes in our tree with the same value.
        node.right = remove(node.right, tmp.data);

        // If instead we wanted to find the largest node in the left
        // subtree as opposed to smallest node in the right subtree
        // here is what we would do:
        // Node tmp = findMax(node.left);
        // node.data = tmp.data;
        // node.left = remove(node.left, tmp.data);

      }
    }

    return node;
  }

  public int height(Node<T> root){
    if(root == null){
      return 0;
    }
    return  1 + Math.max(height(root.right), height(root.left));
  }

   // Helper method to find the leftmost node (which has the smallest value)
   private Node<T> findMin(Node<T> node) {
    while (node.left != null) node = node.left;
    return node;
  }

  public static void main(String[] args){
    BinarySearchTree<Integer> bst = new BinarySearchTree<>();

    bst.add(10);
    bst.add(4);
    bst.add(6);
    bst.add(7);
    bst.add(5);
    System.out.println("-----InOrder----");
    bst.inOrder(bst.root);
    System.out.println();
    System.out.println("-----PreOrder----");
    bst.preOrder(bst.root);
    System.out.println();
    System.out.println("-----PostOrder----");
    bst.postOrder(bst.root);
    System.out.println("-----Height-----");
    System.out.println(bst.height(bst.root));
  }
}