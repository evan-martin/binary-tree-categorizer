package project3;

import javax.swing.*;
import java.awt.*;

public class BinaryTreeCategorizerGUI extends NiceFrame {

    public BinaryTreeCategorizerGUI() {
        super("Binary Tree Categorizer", 750, 150);
        add(new BTCPanel());
    }

    static public void main(String[] args) {
        BinaryTreeCategorizerGUI btcApp = new BinaryTreeCategorizerGUI();
        btcApp.display();
    }
}

class NiceFrame extends JFrame {

    public NiceFrame(String title, int width, int height) {
        super(title);
        setFrame(width, height);
    }

    public void display() {
        setVisible(true);
    }

    private void setFrame(int width, int height) {
        setSize(width, height);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class BTCPanel extends JPanel {

    private String expression;
    BinaryTree tree;

    public BTCPanel() {

        setLayout(new GridLayout(3, 1));

        //create expression component
        JLabel expressionLabel = new JLabel("Enter Tree ", JLabel.LEFT);
        JTextField expressionText = new JTextField(15);

        //create buttons
        JButton makeTree = new JButton("Make Tree");
        JButton isBalanced = new JButton("Is Balanced?");
        JButton isFull = new JButton("Is Full?");
        JButton isProper = new JButton("Is Proper?");
        JButton height = new JButton("Height");
        JButton nodes = new JButton("Nodes");
        JButton inorder = new JButton("Inorder");

        //create result component
        JLabel resultLabel = new JLabel("Result ", JLabel.LEFT);
        JTextField resultText = new JTextField(15);
        resultText.setEditable(false);

        //create the expression panel
        JPanel expressionPanel = new JPanel();
        expressionPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        expressionPanel.add(expressionLabel);
        expressionPanel.add(expressionText);
        add(expressionPanel);

        //create the buttons panel
        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        buttonsPanel.add(makeTree);
        buttonsPanel.add(isBalanced);
        buttonsPanel.add(isFull);
        buttonsPanel.add(isProper);
        buttonsPanel.add(height);
        buttonsPanel.add(nodes);
        buttonsPanel.add(inorder);
        add(buttonsPanel);

        //create the result panel
        JPanel resultPanel = new JPanel();
        resultPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        resultPanel.add(resultLabel);
        resultPanel.add(resultText);
        add(resultPanel);

        //makeTree button action listener
        makeTree.addActionListener(e -> {
            expression = expressionText.getText();
            tree = new BinaryTree(expression);
            resultText.setText(tree.toString());
        });

        //isBalanced button action listener
        isBalanced.addActionListener(e -> {
            expression = expressionText.getText();
            resultText.setText(BinaryTree.isBalanced(tree));
        });
        //isFull button action listener
        isFull.addActionListener(e -> {
            expression = expressionText.getText();
            resultText.setText(BinaryTree.isFull(tree));
        });

        //isProper button action listener
        isProper.addActionListener(e -> {
            expression = expressionText.getText();
            resultText.setText(BinaryTree.isProper(tree));
        });
        //height button action listener
        height.addActionListener(e -> {
            expression = expressionText.getText();
            resultText.setText(BinaryTree.height(tree));
        });

        //nodes button action listener
        nodes.addActionListener(e -> {
            expression = expressionText.getText();
            resultText.setText(BinaryTree.nodes(tree));
        });
        //inorder button action listener
        inorder.addActionListener(e -> {
            expression = expressionText.getText();
            resultText.setText(BinaryTree.inorder(tree));
        });

    }

}
