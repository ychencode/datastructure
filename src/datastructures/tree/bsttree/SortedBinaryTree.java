package datastructures.tree.bsttree;


import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class SortedBinaryTree<T extends Comparable> {

    static class Node {
        Object data;
        Node parent;
        Node left;
        Node right;

        public Node(Object data, Node parent, Node left, Node right) {
            this.data = data;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }

        public String toString() {
            return "[data=" + data + "]";
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj.getClass() == Node.class) {
                Node target = (Node) obj;
                return data.equals(target.data) && parent == target.parent && left == target.left && right == target.right;
            }
            return false;
        }
    }

    private Node root;

    public SortedBinaryTree() {
        root = null;
    }

    public SortedBinaryTree(T o) {
        root = new Node(o, null, null, null);
    }

    public void add(T ele) {
        if (root == null) {
            root = new Node(ele, null, null, null);
        } else {
            Node current = root;
            Node parent = null;
            int cmp = 0;
            do {
                parent = current;
                cmp = ele.compareTo(parent.data);
                if (cmp > 0) {
                    current = current.right;
                } else {
                    current = current.left;
                }
            } while (current != null);
            Node newNode = new Node(ele, parent, null, null);
            if (cmp > 0) {
                parent.right = newNode;
            } else {
                parent.left = newNode;
            }
        }
    }

    public void remove(T ele) {
        Node target = getNode(ele);
        if (target == null) {
            return;
        }
        if (target.left == null && target.right == null) {
            if (target == root) {
                root = null;
            } else {
                if (target == target.parent.left) {
                    target.parent.left = null;
                } else {
                    target.parent.right = null;
                }
                target.parent = null;
            }
        } else if (target.left == null && target.right != null) {
            if (target == root) {
                root = root.right;
            } else {
                if (target == target.parent.left) {
                    target.parent.left = target.right;
                } else {
                    target.parent.right = target.right;
                }
                target.right.parent = target.parent;
            }
        } else if (target.left != null && target.right == null) {
            if (target == root) {
                root = root.left;
            } else {
                if (target == target.parent.left) {
                    target.parent.left = target.left;
                } else {
                    target.parent.right = target.left;
                }
                target.left.parent = target.parent;
            }
        } else {
            Node leftMaxNode = target.left;
            while (leftMaxNode.right != null) {
                leftMaxNode = leftMaxNode.right;
            }
            leftMaxNode.parent.right = null;
            leftMaxNode.parent = target.parent;
            if (target == target.parent.left) {
                target.parent.left = leftMaxNode;
            } else {
                target.parent.right = leftMaxNode;
            }
            leftMaxNode.left = target.left;
            leftMaxNode.right = target.right;
            target.parent = target.left = target.right = null;
        }
    }

    public Node getNode(T ele) {
        Node p = root;
        while (p != null) {
            int cmp = ele.compareTo(p.data);
            if (cmp > 0) {
                p = p.right;
            } else if (cmp < 0) {
                p= p.left;
            } else {
                return p;
            }
        }
        return null;
    }

    public List<Node> breadthFirst() {
        Queue<Node> queue = new ArrayDeque<>();
        List<Node> list = new ArrayList<>();
        if (root != null) {
            queue.offer(root);
        }
        while (!queue.isEmpty()) {
            list.add(queue.peek());
            Node p = queue.poll();
            if (p.left != null) {
                queue.offer(p.left);
            }
            if (p.right != null) {
                queue.offer(p.right);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        SortedBinaryTree<Integer> tree = new SortedBinaryTree<>();
        tree.add(5);
        tree.add(20);
        tree.add(10);
        tree.add(3);
        tree.add(8);
        tree.add(15);
        tree.add(30);
        System.out.println(tree.breadthFirst());
        tree.remove(20);
        System.out.println(tree.breadthFirst());
    }
}
