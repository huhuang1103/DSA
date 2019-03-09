package com.cn.list;

public class DLLNode {
private int data;
private DLLNode next;
private DLLNode previous;
public int getData() {
	return data;
}
public void setData(int data) {
	this.data = data;
}
public DLLNode getNext() {
	return next;
}
public void setNext(DLLNode next) {
	this.next = next;
}
public DLLNode getPrevious() {
	return previous;
}
public void setPrevious(DLLNode previous) {
	this.previous = previous;
}

public int getDLLLength(DLLNode headNode){
	int length = 0;
	DLLNode currentNode = headNode;
	while(currentNode != null) {
		length++;
		currentNode = currentNode.next;
	}
	return length;
}

}
