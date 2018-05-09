package trees;

public class BinaryTree {
    
    Node root = null;

    public BinaryTree() {};
    
    public void insert(int value) {
        Node node = new Node(value);
        
        if (root == null)
            root = node;
        else {
            Node temp = root;
            Node parent = null;
            boolean left = false;
            
            while (temp != null) {
                parent = temp;
                if(value < temp.value) {
                    temp = temp.left;
                    left = true;
                } else {
                    temp = temp.right;
                    left = false;
                }
            }
            
            temp = node;
            
            if (left)
                parent.left = temp;                
            else
                parent.right = temp;
        }
    }
    
    public Node search(int value) {
        Node temp = root;
        
        while (temp != null) {
            if (temp.value == value)
                return temp;
            else
                if (value < temp.value)
                    temp = temp.left;
                else
                    temp = temp.right;
        }
        
        return null;
    }
    
    public void delete(int value) {
        Node temp = root;
        Node parent = root;
        boolean left = false;
        
        while (temp != null) {
            if (temp.value == value)
                break;
            else {
                parent = temp;
                
                if (value < temp.value) {
                    temp = temp.left;
                    left = true;
                } else {
                    temp = temp.right;
                    left = false;
                }
            }
        }
        
        if (temp != null) {
            int counter = this.offspring(temp);
            
            switch (counter) {
                case 0:
                    if (left)
                        parent.left = null;
                    else
                        parent.right = null;
                    break;
                case 1:
                    if (temp.left != null) {
                        if (left)
                            parent.left = temp.left;
                        else
                            parent.right = temp.left;
                    } else {
                        if (left)
                            parent.left = temp.right;
                        else
                            parent.right = temp.right;
                    }   
                    break;
                case 2:
                    Node nodo = temp.right;
                    Node nodoPadre = temp;
                    
                    while (nodo.left != null) {
                        nodoPadre = nodo;
                        nodo = nodo.left;
                    }   
                    
                    if (nodo.right != null)
                        nodoPadre.left = nodo.right;
                    
                    nodo.right = temp.right;
                    nodo.left = temp.left;
                    
                    if(left)
                        parent.left = nodo;
                    else
                        parent.right = nodo;
                    break;
                default:
                    break;
            }
        }
    }
    
    public int offspring(Node node) {
        return (node.left != null) ? (node.right != null ? 2 : 1) : (node.right != null ? 1 : 0);
    }
    
    public void preorderPrint(Node node) {
        if (node != null) {
            System.out.print(node.toString());
            preorderPrint(node.left);
            preorderPrint(node.right);
        }
    }
    
    public void posorderPrint(Node node) {
        if (node != null) {
            posorderPrint(node.left);
            posorderPrint(node.right);
            System.out.print(node.toString());
        }
    }
    
    public void inorderPrint(Node node) {
        if (node != null) {
            inorderPrint(node.left);
            System.out.print(node.toString());
            inorderPrint(node.right);
        }
    }
    
    public static void main(String[] args) 
    {
        BinaryTree bt = new BinaryTree();
        bt.insert(52);
        bt.insert(18);
        bt.insert(74);
        bt.insert(60);
        bt.insert(87);
        bt.insert(83);
        bt.insert(100);
        bt.insert(85);
        
        bt.delete(74);
        
        bt.preorderPrint(bt.root);  
    }
    
}
