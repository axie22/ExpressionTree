
/**
 * Submitted by Alex Xie, anx201
 * October 18th, 2023
 * The main class is used to test the ExpressionTree class and print out the tree in preorder, inorder, and postorder notation
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Type your expression: ");
            String infix = scanner.nextLine();
            if (infix.isEmpty()) {
                System.out.println("Enter Expression");
                continue;
            }
            Converter converter = new Converter(infix);
            String postfix = converter.toPostFix();
            ExpressionTree expressionTree = new ExpressionTree(postfix);
            Node root = expressionTree.buildTree();
            System.out.print("Prefix: ");
            expressionTree.prefix(root);
            System.out.println();

            System.out.print("Infix: ");
            expressionTree.infix(root);
            System.out.println();

            System.out.print("Postfix: ");
            expressionTree.postfix(root);
            System.out.println();
        }
    }
}
