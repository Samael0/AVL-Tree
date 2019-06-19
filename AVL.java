class AVL{
    Node root;

    public AVL(){
        root = null;
    }
    
    public void insert(int n){
        Node newNode = new Node(n);
        Node current = root;
        Node parent = null;

        if(root == null){
            root = newNode;
            return;
        }
        
        while(true){
            parent = current;
            if(newNode.data < root.data){
                    current = current.leftChild;
                    if(current == null){
                        parent.setLeftChild(newNode);
                        return;
                    }
                    else{
                        current = current.rightChild;
                        if(current == null){
                            parent.setRightChild(newNode);
                            return;
                        }
                    }
            }
        }

    }
}