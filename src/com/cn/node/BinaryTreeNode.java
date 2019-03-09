package com.cn.node;

public class BinaryTreeNode {
private int data;
private BinaryTreeNode left;
private BinaryTreeNode right;
public int getData() {
	return data;
}
public void setData(int data) {
	this.data = data;
}
public BinaryTreeNode getLeft() {
	return left;
}
public void setLeft(BinaryTreeNode left) {
	this.left = left;
}
public BinaryTreeNode getRight() {
	return right;
}
public void setRight(BinaryTreeNode right) {
	this.right = right;
}

public static void PreOrder(BinaryTreeNode root) {
	if(root !=null) {
		System.out.println(root.getData());
		PreOrder(root.getLeft());
		PreOrder(root.getRight());
	}
}

public static void main(String[] args) {
	BinaryTreeNode  root = new BinaryTreeNode();
	root.setData(1);
	//×ó×ÓÊ÷
	BinaryTreeNode rootLeft = new BinaryTreeNode();
	BinaryTreeNode leftSonL = new BinaryTreeNode();
	BinaryTreeNode leftSonR = new BinaryTreeNode();
	rootLeft.setData(2);
	leftSonL.setData(4);
	leftSonR.setData(5);
	rootLeft.setLeft(leftSonL);
	rootLeft.setRight(leftSonR);
	
	//ÓÒ×ÓÊ÷
	BinaryTreeNode rootRight = new BinaryTreeNode();
	BinaryTreeNode rightSonL = new BinaryTreeNode();
	BinaryTreeNode rightSonR = new BinaryTreeNode();
	rootRight.setData(3);
	rightSonL.setData(6);
	rightSonR.setData(7);
	rootRight.setLeft(rightSonL);
	rootRight.setRight(rightSonR);
	
	root.setLeft(rootLeft);
	root.setRight(rootRight);
	
	root.PreOrder(root);
}

}
