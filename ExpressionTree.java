/**
 * Created by Alex Xie, anx201
 * October 18, 2023
 * The Expression Tree class is used to create an expression tree from a given
 * postfix expression
 * The class also contains functions to print out the tree in preorder, inorder,
 * and postorder notation
 */

public class ExpressionTree {
    private String postfixExpression;
    private Node root;

    /**
     * Constructor takes a postfix expression and creates an expression tree
     * 
     * @param postfixExpression a String containing the postfix expression
     */
    public ExpressionTree(String postfixExpression) {
        this.postfixExpression = postfixExpression;
    }

    /**
     * Creates an expression tree from the given postfix expression in the
     * ExpressionTree Object
     * Operands are leavesa and operators and internal nodes
     * 
     * @return root the root of the expression tree
     */
    public Node buildTree() {
        char[] data = postfixExpression.toCharArray();

        ArrayStack<Node> nodes = new ArrayStack<>();

        for (int i = 0; i < data.length; i++) {
            if (data[i] == ' ') {
                continue;
            } else {

                if (Character.isDigit(data[i])) {
                    // push operand
                    // all operands are leaf nodes so create a leaf node
                    Node leaf = new Node(data[i], null, null);
                    nodes.push(leaf);
                } else {
                    // operands come off in reverse order off stack'
                    Node operandTwo = nodes.pop();
                    Node operandOne = nodes.pop();
                    Node operatorNode = new Node(data[i], operandOne, operandTwo);
                    nodes.push(operatorNode);
                }
            }
        }
        // return the root node
        this.root = nodes.pop();
        return this.root;
    }

    /**
     * Prints out the tree in preorder
     * 
     * @param root the tree's root node
     */
    public void prefix(Node root) {
        if (root == null)
            return;
        System.out.print(root);
        prefix(root.leftChild);
        prefix(root.rightChild);
    }

    /**
     * Prints out the tree inorder and adds parenthesis to specify order of
     * operation
     * 
     * @param root the tree's root node
     */
    public void infix(Node root) {
        if (root == null)
            return;
        // add a paren every time we go deeper
        System.out.print("(");
        infix(root.leftChild);
        System.out.print(root);
        infix(root.rightChild);
        // closing parens
        System.out.print(")");
    }

    /**
     * Prints out the tree in postorder
     * 
     * @param root the tree's root node
     */
    public void postfix(Node root) {
        if (root == null)
            return;
        postfix(root.leftChild);
        postfix(root.rightChild);
        System.out.print(root);
    }
}
