/******************************************************************************************
 * Data Structures in C++
 * ISBN: 7-302-33064-6 & 7-302-33065-3 & 7-302-29652-2 & 7-302-26883-3
 * Junhui DENG, deng@tsinghua.edu.cn
 * Computer Science & Technology, Tsinghua University
 * Copyright (c) 2006-2013. All rights reserved.
 ******************************************************************************************/

/*
 * ����˫������ʵ���б�ṹ
 */

package dsa;

public class List_DLNode implements List {
	protected int numElem;// �б��ʵ�ʹ�ģ
	protected DLNode header, trailer;// �ڱ����׽ڵ�+ĩ�ڵ�

	// ���캯��
	public List_DLNode() {
		numElem = 0;// �ձ�
		header = new DLNode(null, null, null);// ͷ�ڵ�
		trailer = new DLNode(null, header, null);// β�ڵ�
		header.setNext(trailer);// ͷ��β�ڵ��໥����
	}

	/**************************** �������� ****************************/
	// ������λ�����б����Ƿ�Ϸ������ǣ�����ת��Ϊ*DLNode
	protected DLNode checkPosition(Position p) throws ExceptionPositionInvalid {
		if (null == p)
			throw new ExceptionPositionInvalid("���⣺���ݸ�List_DLNode��λ����null");
		if (header == p)
			throw new ExceptionPositionInvalid("���⣺ͷ�ڵ��ڱ�λ�÷Ƿ�");
		if (trailer == p)
			throw new ExceptionPositionInvalid("���⣺β����ڱ�λ�÷Ƿ�");
		DLNode temp = (DLNode) p;
		return temp;
	}

	/**************************** ADT���� ****************************/
	// ��ѯ�б�ǰ�Ĺ�ģ
	public int getSize() {
		return numElem;
	}

	// �ж��б��Ƿ�Ϊ��
	public boolean isEmpty() {
		return (numElem == 0);
	}

	// ���ص�һ��Ԫ�أ���λ�ã�
	public Position first() throws ExceptionListEmpty {
		if (isEmpty())
			throw new ExceptionListEmpty("���⣺�б��");
		return header.getNext();
	}

	// �������һ��Ԫ�أ���λ�ã�
	public Position last() throws ExceptionListEmpty {
		if (isEmpty())
			throw new ExceptionListEmpty("���⣺�б��");
		return trailer.getPrev();
	}

	// ���ؽ�������λ��֮ǰ��Ԫ�أ���λ�ã�
	public Position getPrev(Position p) throws ExceptionPositionInvalid, ExceptionBoundaryViolation {
		DLNode v = checkPosition(p);
		DLNode prev = v.getPrev();
		if (prev == header)
			throw new ExceptionBoundaryViolation("���⣺��ͼԽ���б�ǰ��");
		return prev;
	}

	// ���ؽ��Ӹ���λ��֮���Ԫ�أ���λ�ã�
	public Position getNext(Position p) throws ExceptionPositionInvalid, ExceptionBoundaryViolation {
		DLNode v = checkPosition(p);
		DLNode next = v.getNext();
		if (next == trailer)
			throw new ExceptionBoundaryViolation("���⣺��ͼԽ���б���");
		return next;
	}

	// ��e��������������λ��֮ǰ��λ��
	public Position insertBefore(Position p, Object element) throws ExceptionPositionInvalid {
		DLNode v = checkPosition(p);
		numElem++;
		DLNode newNode = new DLNode(element, v.getPrev(), v);
		v.getPrev().setNext(newNode);
		v.setPrev(newNode);
		return newNode;
	}

	// ��e���������Ӹ���λ��֮���λ��
	public Position insertAfter(Position p, Object element) throws ExceptionPositionInvalid {
		DLNode v = checkPosition(p);
		numElem++;
		DLNode newNode = new DLNode(element, v, v.getNext());
		v.getNext().setPrev(newNode);
		v.setNext(newNode);
		return newNode;
	}

	// ��e��Ϊ��һ��Ԫ�ز����б�
	public Position insertFirst(Object e) {
		numElem++;
		DLNode newNode = new DLNode(e, header, header.getNext());
		header.getNext().setPrev(newNode);
		header.setNext(newNode);
		return newNode;
	}

	// ��e��Ϊ���һ��Ԫ�ز����б�
	public Position insertLast(Object e) {
		numElem++;
		DLNode newNode = new DLNode(e, trailer.getPrev(), trailer);
		if (null == trailer.getPrev())
			System.out.println("!!!Prev of trailer is NULL!!!");
		trailer.getPrev().setNext(newNode);
		trailer.setPrev(newNode);
		return newNode;
	}

	// ɾ������λ�ô���Ԫ�أ�������֮
	public Object remove(Position p) throws ExceptionPositionInvalid {
		DLNode v = checkPosition(p);
		numElem--;
		DLNode vPrev = v.getPrev();
		DLNode vNext = v.getNext();
		vPrev.setNext(vNext);
		vNext.setPrev(vPrev);
		Object vElem = v.getElem();
		// ����λ�ã��ڵ㣩���б���ժ�����Ա�ϵͳ������ռ�õĿռ�
		v.setNext(null);
		v.setPrev(null);
		return vElem;
	}

	// ɾ����Ԫ�أ�������֮
	public Object removeFirst() {
		return remove(header.getNext());
	}

	// ɾ��ĩԪ�أ�������֮
	public Object removeLast() {
		return remove(trailer.getPrev());
	}

	// �����ڸ���λ�õ�Ԫ���滻Ϊ��Ԫ�أ������ر��滻��Ԫ��
	public Object replace(Position p, Object obj) throws ExceptionPositionInvalid {
		DLNode v = checkPosition(p);
		Object oldElem = v.getElem();
		v.setElem(obj);
		return oldElem;
	}

	// λ�õ�����
	public Iterator positions() {
		return new IteratorPosition(this);
	}

	// Ԫ�ص�����
	public Iterator elements() {
		return new IteratorElement(this);
	}

	/**
	 * �����㷨
	 * �ڽڵ�p��n����ǰ���У��ҵ�����e�������
	 * @return
	 */
	public Position find(Position p, int n,Object e) {
		DLNode v = checkPosition(p);
		while(0< n--) {
			if(e == (v = v.getPrev()).getElem() )  return v;
		}
		return null;
		
	}
	
	//���ڸ��ƵĹ���
	public List_DLNode copyNodes(Position p, int n) {
		DLNode v = checkPosition(p);
		List_DLNode list_DLNode = new List_DLNode();
		while(n-- > 0) {
			list_DLNode.insertLast(v.getElem());
			v = v.getNext();
		}
		return list_DLNode;
	}
	
	//�޳������б��е��ظ��ڵ�
	public int deduplicate() {
		if(numElem < 0) return 0;
		int oldSize = numElem;
		DLNode p = (DLNode) first();
		int n =1;
		while(trailer != (p = p.getNext())) {
			DLNode q = (DLNode) find(p, n, p.getElem());
			if(q != null) {
				remove(q);
			}else {
				n++;
			}
		}
		return oldSize-numElem;
		
	}
	
	//����ɾ���ظ�Ԫ��
	public int uniquify() {
		if(numElem < 0) return 0;
		int oldSize = numElem;
		DLNode p = (DLNode) first();DLNode q;
		while(trailer != (q = p.getNext())) {
			if(p.getElem() != q.getElem()) {
				p= q;
			}else {
				remove(q);
			}
		}
		
		return oldSize-numElem;
		
	}
	//�������б��ڽڵ�p��n����ǰ���У��ҵ�������e�������
	public Position search(Object e ,int n ,Position p) {
		DLNode v = checkPosition(p);
		while(0 <n--) {
			if( new ComparatorDefault().compare(((v = v.getNext()).getElem()) ,e) <= 0) {//<=e
				break;
			}
		}
		return v;
	}
	
	//ѡ������:�����б�����ʼ��λ��p������n��Ԫ����ѡ������
	public void selectSort(Position p,int n) {
		DLNode v = checkPosition(p);
		DLNode head = v.getPrev();
		DLNode tail = v;
		for (int i = 0; i < n; i++) {
			tail = tail.getNext();
		}
		while(1 < n) {
			insertBefore(tail, remove(selectMax(head.getNext() ,n)));
			tail = tail.getPrev(); n--;
		}
	}

	/**
	 * ����ʼ��p�ĺ�n��Ԫ����ѡ������ߣ�1<n
	 * @param p
	 * @param n
	 * @return
	 */
	public Position selectMax(Position p ,int n) {
		DLNode v = checkPosition(p);
		DLNode max = v;
		for (DLNode curr = v; 1 < n; n--) {
			if(new ComparatorDefault().compare((curr = curr.getNext()).getElem() , max.getElem()) >= 0) {//��>= max
				max = curr;
			}
		}
		return max;
	}
	
	/**
	 * ���б�����ʼλ����p������n��Ԫ������������
	 * @param p
	 * @param n
	 */
	public void insertSort(Position p , int n) {
		DLNode v = checkPosition(p);
		for (int r = 0; r < n; r++) {
			insertAfter(search(v.getElem(), r, v), p.getElem());
			v = v.getNext();
			remove(v.getPrev());
		}
	}
	
}
