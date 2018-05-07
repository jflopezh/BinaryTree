/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trees;

/**
 *
 * @author Estudiante
 */
public class Node {
    
    int value;
    Node right = null;
    Node left = null;

    public Node(int value) {
        this.value = value;
    }
    
    public String toString()
    {
        return "Value: " + this.value + "\n";
    }
    
    public Node clone()
    {
        return new Node(this.value);
    }
    
    public static void main(String[] args) 
    {
        
    }
    
}
