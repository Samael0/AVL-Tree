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
            if(n < current.data){
                    current = current.leftChild;
                    if(current == null){
                        parent.setLeftChild(newNode);
                        return;
                    }
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

    public Node getPredecessor(Node n){
        Node preDecessor = null;
        Node preDecessorParent = null;
        Node current = n.leftChild;

        while(current != null){
            preDecessorParent = preDecessor;
            preDecessor = current;
            current = current.rightChild;
        }

        if(preDecessor != root.leftChild){
            preDecessorParent.rightChild = preDecessor.leftChild;
            preDecessor.leftChild = n.leftChild;
        }

        return preDecessor;
    }

    public Node getSuccessor(Node n){
        Node successor = null;
        Node successorParent = null;
        Node current = n.rightChild;

        while(current != null){
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }

        if(successor != root.rightChild){
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = n.rightChild;
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
            Node successor = getSuccessor(current);

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
		if(root!=null){
			print(root.leftChild);
			System.out.print(root.data +" ");
			print(root.rightChild);
		}
	}

    public static void main(String[] args) {
        AVL tree = new AVL();
        tree.insert(3);
        tree.insert(8);
        tree.insert(1);
        tree.insert(4);
        tree.insert(6);
        tree.insert(2);
        tree.insert(10);
        tree.insert(9);
        tree.insert(20);
        tree.insert(25);
        tree.insert(15);
        tree.insert(16);
        tree.print();
        System.out.println();
        tree.delete(2);
        tree.print();
        System.out.println();
        tree.delete(4);
        tree.print();
        System.out.println();
        tree.delete(10);
        tree.print();
        System.out.println();
        tree.delete(3);
        tree.print();
    }
}