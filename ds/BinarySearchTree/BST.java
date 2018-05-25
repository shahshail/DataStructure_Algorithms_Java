import java.util.*;

public class BST{

  Node root;

  public BST()
  {
    root = null;
  }


  public void insert(int data)
  {
    root = insertRec(root,data);
  }



public void traverseInOrder()
{
  inOrderTraversal(root);
}
public void traversePreOrder()
{
  preOrderTraversal(root);
}

public void traversePostOrder()
{
  postOrderTraversal(root);
}



//inOrder Travesrsal
private void inOrderTraversal(Node root)
{
  if(root == null) return;
  inOrderTraversal(root.leftChildNode);
  System.out.print(root.data+" ");
  inOrderTraversal(root.rightChildNode);
}


// Check weather the tree is BST or not
// To do tthat we have to check three conditions :
// 1) The left child node must be smaller than the root node
// 2) THe right child node must be greater than the root noe..
// 3) Both left asnd right child must pass the above rules..

public void isBST()
{
  if (isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
    System.out.println("This Tree is Binary Search Tree");
  }else{
    System.out.println("This Tree is NOT Binary Search Tree");
  }
}

private boolean isBSTUtil(Node root, int min, int max)
{
  // Every Empty tree is by default Binary Search Tree
  if(root  == null) return true;

  // If the data is less than the integer mininum and greater than the integer minimum than it is not the Binary Search Tree.
  if(root.data < min || root.data > max) return false;

  return (isBSTUtil(root.leftChildNode, min , root.data -1) && isBSTUtil(root.rightChildNode, root.data+1, max));
}

//PreOrder Traversal
private void preOrderTraversal(Node root)
{
  if(root == null) return;
  System.out.print(root.data +" ");
  preOrderTraversal(root.leftChildNode);
  preOrderTraversal(root.rightChildNode);
}

private void postOrderTraversal(Node root)
{
  if(root == null) return;
  postOrderTraversal(root.leftChildNode);
  postOrderTraversal(root.rightChildNode);
  System.out.print(root.data +" ");
}




  private Node insertRec(Node root, int data)
  {
    //Lets check weather the root is empty or not
    if(root == null)
    {
      root = new Node(data);
      return root;
    }

    //If it is not null the we need to check the data and insert the new data into an appropriate position...
    if(data < root.data){
      root.leftChildNode = insertRec(root.leftChildNode, data);
    }else if(data > root.data)
    {
      root.rightChildNode = insertRec(root.rightChildNode, data);
    }

    return root;
  }

public boolean searchNode(int data)
{
  if(search(root,data) == null){
    return false;
  }
  return true;
}

  //Search Method for binary Search tree
public Node search(Node root,int data)
{
  if(root == null || root.data == data)
  {
    return root;
  }

  if(data < root.data)
  {
    return search(root.leftChildNode,data);
  }

  return search(root.rightChildNode,data);

}


//Main Method of the class...
  public static void main(String[] args)
  {
    System.out.println("Binary Search Tree Example");
    BST tree = new BST();
    tree.insert(25);
    tree.insert(18);
    tree.insert(16);
    tree.insert(98);
    tree.insert(87);
    tree.insert(88);
    tree.insert(45);
    tree.insert(76);
    tree.insert(10);
    tree.insert(99);
    tree.insert(43);

  tree.isBST();


  }

  static class Node{
    Node leftChildNode;
    Node rightChildNode;
    int data;

    public Node(int data)
    {
      this.data = data;
      leftChildNode = rightChildNode = null;
    }

    public int getData()
    {
      return data;
    }

    public void setData(int data)
    {
      this.data = data;
    }
    public Node getLeftChildNode()
    {
      return leftChildNode;
    }

    public void setLeftChilNode(Node leftChildNode)
    {
      this.leftChildNode = leftChildNode;
    }

    public Node getRightChildNode()
    {
      return rightChildNode;
    }

    public void setRightChildNode(Node rightChildNode)
    {
      this.rightChildNode = rightChildNode;
    }

  }
}
