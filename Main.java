import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("type your infix expression: ");
            String infix = scanner.nextLine();
            if (infix.isEmpty()) {
                System.out.println("Enter Expression");
                continue;
            }
            Converter converter = new Converter(infix);
            String postfix = converter.toPostFix();
            System.out.println("converted to postfix: " + postfix);
            System.out.println("Creating expression tree...");
            ExpressionTree expressionTree = new ExpressionTree(postfix);
            Node root = expressionTree.createExpressionTree();
            System.out.println("Preorder Traversal: ");
            expressionTree.preorder(root);
            System.out.println();

            System.out.println("Inorder Traversal: ");
            expressionTree.inorder(root);
            System.out.println();

            System.out.println("Postorder Traversal: ");
            expressionTree.postorder(root);
            System.out.println();
        }
    }
}
