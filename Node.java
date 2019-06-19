class Node{
    int data;
    int counter;
    Node leftChild;
    Node rightChild;
    Node parent;
    
    public Node(int num){
        data = num;
        counter = 0;
        leftChild = null;
        rightChild = null;
        parent = null;
    }

    public void addCounter(){
        counter++;
    }

    public void setLeftChild(Node child){
        leftChild = child;
    }

    public Node getLeftChild(){
        return leftChild;
    }

    public void setRightChild(Node child){
        rightChild = child;
    }

    public Node getRightChild(){
        return rightChild;
    }

    public void setParent(Node p){
        parent = p;
    }

    public Node getParent(){
        return parent;
    }
}