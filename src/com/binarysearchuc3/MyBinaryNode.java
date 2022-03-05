package com.binarysearchuc3;

public class MyBinaryNode<K extends Comparable<K>> {
	private static boolean flag = false;
	INode<K> root;

	public void add(K key) {
		INode newNode = new INode<K>(key);

		if (root == null) {
			root = newNode;
			return;
		} else {
			INode<K> current = root, parent = null;

			while (true) {
				parent = current;

				int compareResult = key.compareTo(current.key);
				if (compareResult < 0) {
					current = current.left;
					if (current == null) {
						parent.left = newNode;
						return;
					}
				} else {
					current = current.right;
					if (current == null) {
						parent.right = newNode;
						return;
					}
				}
			}
		}
	}

	public void addRecursively(INode<K> node) {
		if (root == null) {
			System.out.println("Tree is empty");
			return;
		} else {
			if (node.left != null)
				addRecursively(node.left);
			System.out.print(node.key + " ");
			if (node.right != null)
				addRecursively(node.right);
		}
	}

	public void nodeSearch(INode temp, K val) {
		if (root == null) {
			System.out.println("Tree is empty");
		} else {
			if (temp.key == val) {
				flag = true;
				return;
			}
			if (flag == false && temp.left != null) {
				nodeSearch(temp.left, val);
			}
			if (flag == false && temp.right != null) {
				nodeSearch(temp.right, val);
			}
		}
	}

	public static void main(String[] args) {
		MyBinaryNode<Integer> binaryTree = new MyBinaryNode<Integer>();
		System.out.println("Welcome to binary search tree !");
		binaryTree.add(56);
		binaryTree.add(30);
		binaryTree.add(70);
		binaryTree.add(22);
		binaryTree.add(40);
		binaryTree.add(60);
		binaryTree.add(95);
		binaryTree.add(11);
		binaryTree.add(65);
		binaryTree.add(3);
		binaryTree.add(16);
		binaryTree.add(63);
		binaryTree.add(67);

		System.out.println("After adding node : ");
		binaryTree.addRecursively(binaryTree.root);

		binaryTree.nodeSearch(binaryTree.root, 63);

		if (flag) {
			System.out.println("\nNode is present");
		} else {
			System.out.println("\nNode is not present !");
		}
	}
}
