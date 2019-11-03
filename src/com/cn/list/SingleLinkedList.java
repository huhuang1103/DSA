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
 * ����StarSingleLinkedList����������
 * 
 * @author huhuang
 *
 */
public class SingleLinkedList implements List{

	protected int numElem;// �б��ʵ�ʹ�ģ
	/**
	 * �ڵ������У�β����ָ��һ��Ϊ�գ���û�б��������ڵ�Ĵ洢λ����Ϣ������˫�������У�β���һ��ָ�������е�һ���ڵ㡣
	 */
	private Node header;// ͷ���

	// ���캯��
	public SingleLinkedList() {
		numElem = 0;// �ձ�
		header = new Node(null, null);// ͷ�ڵ�
	}

	/**************************** �������� ****************************/
	// ������λ�����б����Ƿ�Ϸ������ǣ�����ת��Ϊ*Node
	protected Node checkPosition(Position p) throws ExceptionPositionInvalid {
		if (null == p)
			throw new ExceptionPositionInvalid("���⣺���ݸ�SingleLinkedList��λ����null");
		if (header == p)
			throw new ExceptionPositionInvalid("���⣺ͷ�ڵ��ڱ�λ�÷Ƿ�");
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
			throw new ExceptionListEmpty("���⣺�б��");
		return header.getNext();
	}

	public Position last() {
		if (isEmpty())
			throw new ExceptionListEmpty("���⣺�б��");
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
		// ��ͷ���Ϊ��
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
			// ����λ�ã��ڵ㣩���б���ժ�����Ա�ϵͳ������ռ�õĿռ�
			numElem--;
			v = null;
			return vElem;
		}
		/*while (hNext.getNext() == v) {
			hNext.setNext(v.getNext());
			Object vElem = v.getElem();
			// ����λ�ã��ڵ㣩���б���ժ�����Ա�ϵͳ������ռ�õĿռ�
			v = null;
			return vElem;
		}*/
		return null;
	}

	/**
	 * ɾ���׽ڵ�
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
	 * �������
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
	            throw new IndexOutOfBoundsException("�������λ�ó����������󳤶ȡ�");
	        } else {
	            if (index == 0) {
	                //�±�Ϊ0ʱ������ͷԪ��
	                insertFirst(e);
	            } else if (numElem == index) {
	                //�±���������һ��ʱ������βԪ��
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
