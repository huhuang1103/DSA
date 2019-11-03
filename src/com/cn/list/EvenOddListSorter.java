package com.cn.list;

import dsa.Node;

public class EvenOddListSorter {

	  private Node listHead;
	    private Node evenHead, oddHead;
	    
	    public EvenOddListSorter(Node head) {
	        this.listHead = head;
	    }
	    
	    
	    public Node sort() {
	        if (listHead == null || listHead.getNext() == null) {
	            return listHead;
	        }
	        
	        evenHead = listHead;
	        oddHead = listHead.getNext();
	        Node node = oddHead;
	        
	        while (evenHead.getNext() != null && oddHead.getNext() != null) {
	            if (oddHead.getNext() != null) {
	                evenHead.setNext(oddHead.getNext());
	                evenHead = evenHead.getNext();
	            }
	            
	            if (evenHead.getNext() != null) {
	                oddHead.setNext(evenHead.getNext());
	                oddHead = oddHead.getNext();
	            }
	        }
	        
	        evenHead.setNext(node);
	        return listHead;
	    }
	    
		public static void main(String[] args) {
	
		}

}
