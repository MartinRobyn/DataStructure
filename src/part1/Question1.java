package part1;
import util.*;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Question1 {
    public static int countEqualToValue(BinaryNode<Integer> root, int value) {
        if (root == null)
            return 0;
        if (root.element.equals(value))
            return 1 + countEqualToValue(root.left, value) + countEqualToValue(root.right, value);
        else
            return countEqualToValue(root.left, value) + countEqualToValue(root.right, value);
    }

    public static int countEqualToValueIterativeDFSVersion(BinaryNode<Integer> root, int value) {
        if (root == null) return 0;

        Stack<BinaryNode<Integer>> stack = new Stack<>();
        stack.push(root);
        int counter = 0;

        while (!stack.empty()) {
            BinaryNode<Integer> temp = stack.pop();
            if (temp != null) {
                if (temp.element.equals(value))
                    counter++;
                stack.push(temp.right);  // Right child is pushed first to ensure left is processed first.
                stack.push(temp.left);
            }
        }
        return counter;
    }

    public static int countEqualToValueIterativeBFSVersion(BinaryNode<Integer> root, int value) {
        if (root == null) return 0;

        Queue<BinaryNode<Integer>> queue = new LinkedList<>();
        queue.add(root);
        int counter = 0;

        while (!queue.isEmpty()) {
            BinaryNode<Integer> temp = queue.poll();
            if (temp != null) {
                if (temp.element.equals(value))
                    counter++;
                queue.add(temp.left);  // Add left child to the queue
                queue.add(temp.right); // Add right child to the queue
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        BinaryNode<Integer> root;
        root = new BinaryNode<>(5,
                new BinaryNode<>(4, new BinaryNode<>(5), new BinaryNode<>(4)),
                new BinaryNode<>(7, new BinaryNode<>(4), new BinaryNode<>(6)));

        System.out.println(root);
        System.out.println("Count (DFS Iterative): " + countEqualToValueIterativeDFSVersion(root, 4));
        System.out.println("Count (BFS Iterative): " + countEqualToValueIterativeBFSVersion(root, 4));
    }
}
