package datastructures.tree.huffmantree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class HuffmanTree {

    public static class Node<E> {
        E data;
        double weight;
        Node leftChild;
        Node rightChild;

        public Node(E data, double weight) {
            this.data = data;
            this.weight = weight;
        }

        public String toString() {
            return "Node[data=" + data + ", weight=" + weight + "]";
        }
    }

    public static void main(String[] args) {
        List<Node> nodes = new ArrayList<>();
        nodes.add(new Node("A", 40.0));
        nodes.add(new Node("B", 8.0));
        nodes.add(new Node("C", 10.0));
        nodes.add(new Node("D", 30.0));
        nodes.add(new Node("E", 10.0));
        nodes.add(new Node("F", 2.0));
        Node root = createTree(nodes);
        System.out.println(breadthFirst(root));
    }

    private static Node createTree(List<Node> nodes) {
        while (nodes.size() > 1) {
            quickSort(nodes);
            Node left = nodes.get(nodes.size() - 1);
            Node right = nodes.get(nodes.size() - 2);
            Node parent = new Node(null, left.weight + right.weight);
            parent.leftChild = left;
            parent.rightChild = right;
            nodes.remove(nodes.size() - 1);
            nodes.remove(nodes.size() - 1);
            nodes.add(parent);
        }
        return nodes.get(0);
    }

    private static void swap(List<Node> nodes, int i, int j) {
        Node tmp = nodes.get(i);
        nodes.set(i, nodes.get(j));
        nodes.set(j, tmp);
    }

    private static void subSort(List<Node> nodes, int start, int end) {
        if (start < end) {
            Node base = nodes.get(start);
            int i = start;
            int j = end;
            while (true) {
                while (i < end && nodes.get(i).weight >= base.weight) {
                    ++i;
                }
                while (j > start && nodes.get(j).weight <= base.weight) {
                    --j;
                }
                if (i < j) {
                    swap(nodes, i, j);
                } else {
                    break;
                }
            }
            swap(nodes, start, j);
            subSort(nodes, start, j - 1);
            subSort(nodes, j + 1, end);
        }
    }

    public static void quickSort(List<Node> nodes) {
        subSort(nodes, 0, nodes.size() - 1);
    }

    public static List<Node> breadthFirst(Node root) {
        Queue<Node> queue = new ArrayDeque<>();
        List<Node> list = new ArrayList<>();
        if (root != null) {
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            list.add(queue.peek());
            Node p = queue.poll();
            if (p.leftChild != null) {
                queue.offer(p.leftChild);
            }
            if (p.rightChild != null) {
                queue.offer(p.rightChild);
            }
        }
        return list;
    }
}
