package com.cn.list;

import dsa.ExceptionBoundaryViolation;
import dsa.ExceptionListEmpty;
import dsa.ExceptionPositionInvalid;
import dsa.Iterator;
import dsa.IteratorElement;
import dsa.IteratorPosition;
import dsa.List;
import dsa.Node;
import dsa.Position;

/**
 * 定义StarSingleLinkedList，单向链表
 * 
 * @author huhuang
 *
 */
public class SingleLinkedList implements List{

	protected int numElem;// 列表的实际规模
	/**
	 * 在单链表中，尾结点的指针一般为空，即没有保存其他节点的存储位置信息。但在双向链表中，尾结点一般指向链表中第一个节点。
	 */
	private Node header;// 头结点

	// 构造函数
	public SingleLinkedList() {
		numElem = 0;// 空表
		header = new Node(null, null);// 头节点
	}

	/**************************** 辅助方法 ****************************/
	// 检查给定位置在列表中是否合法，若是，则将其转换为*Node
	protected Node checkPosition(Position p) throws ExceptionPositionInvalid {
		if (null == p)
			throw new ExceptionPositionInvalid("意外：传递给SingleLinkedList的位置是null");
		if (header == p)
			throw new ExceptionPositionInvalid("意外：头节点哨兵位置非法");
		Node temp = (Node) p;
		return temp;
	}

	public int getSize() {
		return numElem;
	}

	public boolean isEmpty() {
		return (numElem == 0);
	}

	public Position first() {
		if (isEmpty())
			throw new ExceptionListEmpty("意外：列表空");
		return header.getNext();
	}

	public Position last() {
		if (isEmpty())
			throw new ExceptionListEmpty("意外：列表空");
		Node hNext = header.getNext();
		while (hNext != null) {
			if(hNext.getNext() == null) {
				return hNext;
			}
			hNext = hNext.getNext();
		}
		return hNext;
	}

	public Position getNext(Position p) throws ExceptionPositionInvalid, ExceptionBoundaryViolation {
		Node v = checkPosition(p);
		Node next = v.getNext();
		return next;
	}

	public Position insertFirst(Object e) {
		numElem++;
		Node newNode = new Node(e, header.getNext());
		header.setNext(newNode);
		return newNode;
	}

	public Position insertLast(Object e) {
		// 当头结点为空
		if (isEmpty()) {
			return insertFirst(e);
		} else {
			Node newNode = new Node(e, null);
			insertAfter(last(), e);
			/*Node hNext = header.getNext();
			
			while(hNext != null && hNext.getNext() == null){
				hNext.setNext(newNode);
				numElem++;
			}*/
			return newNode;
		}
	}

	public Position insertAfter(Position p, Object e) throws ExceptionPositionInvalid {
		Node v = checkPosition(p);
		Node newNode = new Node(e, v.getNext());
		v.setNext(newNode);
		numElem++;
		return newNode;
	}

	public Position insertBefore(Position p, Object e) throws ExceptionPositionInvalid {
		Node v = checkPosition(p);
		Node hNext = header;
		while (hNext.getNext() != v) {
			hNext = hNext.getNext();
		}
		if(hNext.getNext() == v) {
			Node newNode = new Node(e, v);
			hNext.setNext(newNode);
			numElem++;
			return newNode;
		}
		return null;
	}

	public Object remove(Position p) throws ExceptionPositionInvalid {

		Node v = checkPosition(p);
		Node hNext = header;
		while (hNext.getNext() != v) {
			hNext = hNext.getNext();
		}
		if(hNext.getNext() == v) {
			hNext.setNext(v.getNext());
			Object vElem = v.getElem();
			// 将该位置（节点）从列表中摘出，以便系统回收其占用的空间
			numElem--;
			v = null;
			return vElem;
		}
		/*while (hNext.getNext() == v) {
			hNext.setNext(v.getNext());
			Object vElem = v.getElem();
			// 将该位置（节点）从列表中摘出，以便系统回收其占用的空间
			v = null;
			return vElem;
		}*/
		return null;
	}

	/**
	 * 删除首节点
	 * 
	 * @return
	 */
	public Object removeFirst() {
		return remove(first());
	}

	public Object removeLast() {
		return remove(last());
	}

	public Object replace(Position p, Object e) throws ExceptionPositionInvalid {
		Node v = checkPosition(p);
		Object oldElem = v.getElem();
		v.setElem(e);
		return oldElem;
	}

	public Iterator positions() {
		return new IteratorPosition(this);
		
	}

	public Iterator elements() {
		return new IteratorElement(this);
		
	}

	/**
	 * 清空链表
	 */
	public void clear() {
		header = null;
		numElem = 0;
	}

	public static void main(String[] args) {
		SingleLinkedList list = new SingleLinkedList();
		list.insertFirst(1);
		list.insertFirst(2);
		list.insertFirst(3);
		list.insertFirst(4);
		list.insertFirst(5);
		list.insertFirst(6);
		list.insertFirst(7);
		list.insertFirst(8);
		list.insertFirst(9);
		list.insertFirst(10);
		System.out.println("list size:"+list.getSize());
		System.out.println("list first:"+list.first().getElem());
		System.out.println("list last:"+list.last().getElem());
//		list.add(1, 1);
//		list.insertAfter(list.get(6), 7);
		list.insertBefore(list.get(6), 0);
//		System.out.println(list.removeFirst());
//		System.out.println(list.removeLast());
		System.out.println("list size:"+list.getSize());
		Iterator positions = list.positions();
		while (positions.hasNext()) {
			Node node = (Node) positions.getNext();
			System.out.println("node:"+node.getElem().toString());
			
		}
	}

	@Override
	public Position getPrev(Position p) throws ExceptionPositionInvalid, ExceptionBoundaryViolation {
		return null;
	}
	
	public Node get(int index) {
        Node temp = header;
        for (int i = 0; i < index; i++) {
            temp = temp.getNext();
        }
        return temp;
    }

	 public void add(int index, Object e) {
	        if (index > numElem) {
	            throw new IndexOutOfBoundsException("待插入的位置超过链表的最大长度。");
	        } else {
	            if (index == 0) {
	                //下标为0时，插入头元素
	                insertFirst(e);
	            } else if (numElem == index) {
	                //下标与链表长度一致时，插入尾元素
	            	insertLast(e);
	            } else {
	                Node preNode = get(index - 1); //
	                Node nextNode = get(index);
	                Node newNode = new Node();
	                newNode.setElem(e);
	                preNode.setNext(newNode);
	                newNode.setNext(nextNode);
	                numElem++;
	            }
	        }
	    }
	
}
