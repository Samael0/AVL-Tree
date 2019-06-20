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

    public Node getPredecessor(){
        Node preDecessor = null;
        Node preDecessorParent = null;
        Node current = root.leftChild;

        while(current != null){
            preDecessorParent = preDecessor;
            preDecessor = current;
            current = current.rightChild;
        }

        if(preDecessor != root.leftChild){
            preDecessorParent.rightChild = preDecessor.leftChild;
            preDecessor.leftChild = root.leftChild;
        }

        return preDecessor;
    }

    public Node getSuccessor(){
        Node successor = null;
        Node successorParent = null;
        Node current = root.rightChild;

        while(current != null){
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }

        if(successor != root.rightChild){
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = root.rightChild;
        }

        return successor;
    }

    public boolean delete(int n){
        Node parent = root;
        Node current = root;
        boolean isLeftChild = false;

        while(current.data != n){
            parent = current;

            if(current.data > n){
                isLeftChild = true;
                current = current.leftChild;
            }
            else{
                isLeftChild = false;
                current = current.rightChild;
            }

            if(current == null){
                return false;
            }
        }

        if(current.leftChild == null && current.rightChild == null){
            if(current == root){
                root = null;
            }
            else if(isLeftChild == true){
                parent.leftChild = null;
            }
            else{
                parent.rightChild = null;
            }
        }
        else if(current.rightChild == null){
            if(current == root){
                root = current.leftChild;
            }
            else if(isLeftChild){
                parent.leftChild = current.leftChild;
            }
            else{
                parent.rightChild = current.leftChild;
            }
        }
        else if(current.leftChild == null){
            if(current == root){
                root = current.rightChild;
            }
            else if(isLeftChild){
                parent.leftChild = current.rightChild;
            }
            else{
                parent.rightChild = current.rightChild;
            }
        }
        else if(current.leftChild != null && current.rightChild != null){
            Node successor = getSuccessor();

            if(current == root){
                root = successor;
            }
            else if(isLeftChild){
                parent.leftChild = successor;
            }
            else{
                parent.rightChild = successor;
            }
            successor.leftChild = current.leftChild;
        }
        return true;
    }

    public void print(){
        print(root);
    }

    public void print(Node root){
        if(root != null){
            print(root.leftChild);
            System.out.println(" " +root.data);
            print(root.rightChild);
        }
    }
}