package com.binarysearchuc3;

public class INode<K extends Comparable<K>> {
	K key;
	INode left;
	INode right;

	public INode(K key) {
		this.key = key;
		this.left = this.right = null;
	}
}
