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

    public Node createExpressionTree() {
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

    // public void preorder() {
    // preorder(this.root);
    // System.out.println();
    // }

    public void preorder(Node root) {
        if (root == null)
            return;
        System.out.print(root);
        preorder(root.leftChild);
        preorder(root.rightChild);
    }

    // public void inorder() {
    // inorder(this.root);
    // System.out.println();
    // }

    public void inorder(Node root) {
        if (root == null)
            return;
        inorder(root.leftChild);
        System.out.print(root);
        inorder(root.rightChild);
    }

    // public void postorder() {
    // postorder(this.root);
    // System.out.println();
    // }

    public void postorder(Node root) {
        if (root == null)
            return;
        postorder(root.leftChild);
        postorder(root.rightChild);
        System.out.print(root);
    }
}
