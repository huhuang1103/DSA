package com.cn.list;

public class ListNode {
private int data;
private ListNode next;
public int getData() {
	return data;
}
public void setData(int data) {
	this.data = data;
}
public ListNode getNext() {
	return next;
}
public void setNext(ListNode next) {
	this.next = next;
}

public static int listLength(ListNode headNode) {
	int length = 0;
	ListNode currentNode = headNode;
	while(currentNode != null) {
		length++;
		currentNode = currentNode.next;
	}
	return length;
}
//插入节点
public ListNode insertInListedList(ListNode headNode,ListNode nodeToInsert, int position) {
	if(headNode == null)
		return nodeToInsert;
	int size = listLength(headNode);
	if(position>size+1 || position <1) {
		System.out.println("Postition of node to insert is invalid");
		return headNode;
	}
	if(position ==1) {//从链表开头插入
		nodeToInsert.setNext(headNode);
		return nodeToInsert;
	}else {
		ListNode previousNode = headNode;
		int count =1;
		while(count<position-1) {
			previousNode =previousNode.getNext();
			count++;
		}
		ListNode currentNode = previousNode.getNext();
		nodeToInsert.setNext(currentNode);
		previousNode.setNext(nodeToInsert);
		
	}
	return headNode;
	
}
//删除节点
public static ListNode deleteNodeFromLinkedList(ListNode headNode, int position) {
	int size = listLength(headNode);
	if(position>size+1 || position <1) {
		System.out.println("Postition of node to delete is invalid");
		return headNode;
	}
	if(position ==1) {
		ListNode currentNode = headNode.getNext();
		headNode =null;
		return currentNode;
	}else {
		ListNode previousNode = headNode;
		int count =1;
		while(count<position-1) {
			previousNode =previousNode.getNext();
			count++;
		}
		ListNode currentNode = previousNode.getNext();
		previousNode.setNext(currentNode.getNext());
		currentNode = null;
	}
	return headNode;
	
}
//删除单向链表
public void DeleteLinkedList(ListNode head) {
	ListNode auxilaryNode ,itertor = head;
	while(itertor != null) {
		auxilaryNode = itertor.getNext();
		itertor = null;
		itertor = auxilaryNode;
	}
}

public static void main(String[] args) {
	ListNode node = new ListNode();
	System.out.println(ListNode.listLength(node));
}
}
