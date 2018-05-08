package id.ac.ubharajaya.algo.semester2.tugas1;

/**
 * @link https://www.cs.usfca.edu/~galles/visualization/BST.html
 */
public class Main {

    public static void main(String[] args) {

        BST root1 = new BST();

        root1.insert(2);
        root1.insert(3);
        root1.insert(1);
        root1.insert(16);
        root1.insert(14);
        root1.checkRoot();
        root1.findMin();
        root1.findMax();
        root1.urutRoot();
        root1.delete(2);
        root1.checkRoot();
        root1.urutRoot();
    }
}

class Node {
    int data;
    Node parent;
    Node left;
    Node right;

    public Node(int data) {
        this.data = data;
    }
}

class BST {
    private Node root;

    public void checkRoot() {
        System.out.println("Nilai Root: " + root.data);
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void searching(int i ) {
        Node tempNode = root;
        boolean hasil = false;

        while (tempNode != null && !hasil) {
            if (tempNode.data == i) {
                hasil = true;
            } else if (i < tempNode.data) {
                tempNode = tempNode.left;
            } else if (i > tempNode.data) {
                tempNode = tempNode.right;
            }
        }

        if (hasil) {
            System.out.println("Data di temukan!");
        } else {
            System.out.println("Data tidak di temukan");
        }
    }

    public void findMin() {
        Node tempNode = root;
        Node parentNode = root;

        while (tempNode != null) {
            parentNode = tempNode;
            tempNode = tempNode.left;
        }

        System.out.println("Nilai Minimum: " + parentNode.data);
    }

    public void findMax() {
        Node tempNode = root;
        Node parentNode = root;

        while (tempNode != null) {
            parentNode = tempNode;
            tempNode = tempNode.right;
        }

        System.out.println("Nilai Maximum: " + parentNode.data);
    }

    public void urutRoot() {
        System.out.println("Mengurutkan Tree: ");
        urutTree(root);
    }

    private void urutTree(Node tempNode) {
        if (tempNode != null) {
            urutTree(tempNode.left);
            System.out.println(tempNode.data);
            urutTree(tempNode.right);
        }
    }

    public void insert(int i ) {
        Node tempNode = new Node(i);
        Node y = null;
        Node x = root;
        boolean sudahAda = false;

        if (isEmpty()) {
            System.out.println("Nilai " + i + " Menjadi root");
            root = tempNode;
        } else {

            while (x != null && !sudahAda) {
                y = x;
                if (i < x.data) {
                    x = x.left;
                } else if (i > x.data) {
                    x = x.right;
                } else if (i == x.data) {
                    sudahAda = true;
                    System.out.println("Nilai " + i + " sudah ada di tree");
                }
            }

            if (!sudahAda) {
                if (i < y.data) {
                    y.left = tempNode;
                    System.out.println("Nilai " + i + " masuk sebeleah kiri " + y.data);
                } else {
                    y.right = tempNode;
                    System.out.println("Nilai " + i + " masuk sebelah kanan " + y.data);
                }
            }
        }
    }

    private void insertNode(Node nodeToInsert) {
        insert(nodeToInsert.data);

        if (nodeToInsert.right != null) {
            insertNode(nodeToInsert.right);
        }

        if (nodeToInsert.left != null) {
            insertNode(nodeToInsert.left);
        }
    }

    public void delete(int i) {
        Node tempNode = root;
        Node tempParentNode = root;
        boolean ketemu = false;

        while (tempNode != null && !ketemu) {

            if (i < tempNode.data) {
                tempParentNode = tempNode;
                tempNode = tempNode.left;
            } else if (i > tempNode.data) {
                tempParentNode = tempNode;
                tempNode = tempNode.right;
            } if (i == tempNode.data) {
                ketemu = true;
            }
        }

        if (ketemu) {

            Node highestNodeOnLeft = tempNode.left;
            Node parentHighestNodeOnLeft = tempParentNode;
            boolean foundHighest = false;
            boolean isRoot = false;

            if (root.data == i) {
                foundHighest = true;
                isRoot = true;
            }

            while (!foundHighest) {
                if (highestNodeOnLeft.right != null) {
                    parentHighestNodeOnLeft = highestNodeOnLeft;
                    highestNodeOnLeft = highestNodeOnLeft.right;
                } else {
                    foundHighest = true;
                }
            }

            if (highestNodeOnLeft.left != null || highestNodeOnLeft.right != null) {

                tempParentNode.right = highestNodeOnLeft;
            } else {


                if (isRoot) {
                    tempParentNode.data = highestNodeOnLeft.data;
                } else {
                    tempParentNode.right.data = highestNodeOnLeft.data;
                }

                if (parentHighestNodeOnLeft.right != null && parentHighestNodeOnLeft.right.data == highestNodeOnLeft.data) {
                    parentHighestNodeOnLeft.right = null;
                } else if (parentHighestNodeOnLeft.left != null && parentHighestNodeOnLeft.left.data == highestNodeOnLeft.data) {
                    parentHighestNodeOnLeft.left = null;
                }

            }

            System.out.println("Nilai " + i + " telah di hapus dari tree");

        } else {

            System.out.println("Nilai " + i + " tidak di temukan");
        }
    }
}
