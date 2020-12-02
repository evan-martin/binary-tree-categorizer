// CMSC 350 Data Structures and Analysis
// Project 3
// Evan Martin
// December 1, 2020

// This class defines a BinaryTree object, it uses recursion and a nested class of Node
// to define the object. It contains methods to parse the given input, check for errors,
// and construct a BinaryTree object. This class also includes methods to check if a tree
// is balanced, proper, full, etc.


package project3;

import java.util.Stack;

public class BinaryTree {

    private static Node root;

    static class Node {
        char value;
        Node left;
        Node right;

        Node(char value) {
            this.value = value;
            left = null;
            right = null;
        }
    }

    public BinaryTree(String expression) throws InvalidTreeSyntax {
        stringToTree(expression, 1, expression.length() - 1);
    }

    //reference: https://www.geeksforgeeks.org/construct-binary-tree-string-bracket-representation/
    private Node stringToTree(String expression, int startIndex, int endIndex) throws InvalidTreeSyntax {


        if (startIndex > endIndex) return null;

        Node root = new Node(expression.charAt(startIndex));

        if ((root.value == '(') || (root.value == ')')) {
            throw new InvalidTreeSyntax("Syntax Error");
        }

        if (expression.charAt(startIndex + 1) != '(') {
            if (expression.charAt(startIndex + 1) != ')') {
                throw new InvalidTreeSyntax("Syntax Error");
            }
        }

        int index = -1;

        if (startIndex + 1 <= endIndex && expression.charAt(startIndex + 1) == '(') {
            index = findIndex(expression, startIndex + 1, endIndex);
        }
        if (index != -1) {
            root.left = stringToTree(expression, startIndex + 2, index - 1);
            root.right = stringToTree(expression, index + 2, endIndex - 1);
        }
        BinaryTree.root = root;
        return root;
    }

    //reference: https://www.geeksforgeeks.org/construct-binary-tree-string-bracket-representation/
    private int findIndex(String expression, int startIndex, int endIndex) throws InvalidTreeSyntax {

        int openCount = 0;
        int closeCount = 0;

        if (startIndex > endIndex) {
            return -1;
        }

        Stack<Character> stack = new Stack<>();

        for (int i = startIndex; i <= endIndex; i++) {
            if (expression.charAt(i) == '(') {
                stack.push(expression.charAt(i));
                openCount++;
            } else if (expression.charAt(i) == ')') {
                closeCount++;
                if (stack.peek() == '(') {
                    stack.pop();
                    if (stack.isEmpty()) {
                        return i;
                    }
                }
            }
        }
        if (openCount != closeCount) {
            throw new InvalidTreeSyntax("Syntax Error");
        }
        return -1;
    }

    public static String isBalanced() {
        return "Balanced: " + isBalanced(root);
    }

    private static boolean isBalanced(Node node) {
        if (node == null) return true;
        return Math.abs(height(node.left) - height(node.right)) <= 1 && isBalanced(node.left) && isBalanced(node.right);
    }

    public static String isFull() {
        return "Full: " + isFull(root);
    }

    private static boolean isFull(Node node) {
        if (node == null) return true;
        if (node.left == null && node.right == null) return true;
        if (node.left != null && node.right != null) return isFull(node.left) && isFull(node.right);

        return false;
    }

    public static String isProper() {
        return "proper: " + isProper(root);
    }

    private static boolean isProper(Node node) {
        if (node == null) return true;
        if ((node.left != null && node.right == null) || (node.left == null && node.right != null)) return false;
        return (isProper(node.left) && isProper(node.right));
    }

    public static String height() {
        return "Height: " + (height(root) - 1);
    }

    private static int height(Node node) {
        if (node == null) return 0;
        return Math.max(height(node.left) + 1, height(node.right) + 1);
    }

    public static String nodes() {
        return "Number of nodes: " + nodes(root);
    }

    private static int nodes(Node node) {
        if (node == null) return 0;
        int count = 0;
        if (node.value != ' ') count++;
        count += nodes(node.left) + nodes(node.right);
        return count;
    }

    public static String inorder() {
        return inorder(root);
    }

    private static String inorder(Node node) {
        if (node != null) {
            return ("(" + inorder(node.left) + node.value + inorder(node.right) + ")");
        }
        return "";
    }

}
