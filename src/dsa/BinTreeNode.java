/******************************************************************************************
 * Data Structures in C++
 * ISBN: 7-302-33064-6 & 7-302-33065-3 & 7-302-29652-2 & 7-302-26883-3
 * Junhui DENG, deng@tsinghua.edu.cn
 * Computer Science & Technology, Tsinghua University
 * Copyright (c) 2006-2013. All rights reserved.
 ******************************************************************************************/

/*
 * ��������ڵ�ʵ�ֶ������ڵ�
 */

package dsa;

public class BinTreeNode implements BinTreePosition {
	protected Object element;// �ýڵ��д�ŵĶ���
	protected BinTreePosition parent;// ����
	protected BinTreePosition lChild;// ����
	protected BinTreePosition rChild;// �Һ���
	protected int size;// �����Ŀ
	protected int height;// �߶�
	protected int depth;// ���

	/**************************** ���췽�� ****************************/
	public BinTreeNode() {
		this(null, null, true, null, null);
	}

	public BinTreeNode(Object e, // �ڵ�����
			BinTreePosition p, // ���ڵ�
			boolean asLChild, // �Ƿ���Ϊ���ڵ������
			BinTreePosition l, // ����
			BinTreePosition r) { // �Һ���
		size = 1;
		height = depth = 0;
		parent = lChild = rChild = null;// ��ʼ��
		element = e;// ��ŵĶ���
		// �����븸�׵Ĺ�ϵ
		if (null != p)
			if (asLChild)
				p.attachL(this);
			else
				p.attachR(this);
		// �����뺢�ӵĹ�ϵ
		if (null != l)
			attachL(l);
		if (null != r)
			attachR(r);
	}

	/**************************** Position�ӿڷ��� ********************************/
	// ���ص�ǰ�ڵ��д�ŵĶ���
	public Object getElem() {
		return element;
	}

	// ������obj���뵱ǰ�ڵ㣬�����ش�ǰ������
	public Object setElem(Object obj) {
		Object bak = element;
		element = obj;
		return bak;
	}

	/**************************** BinTreePosition�ӿڷ��� *************************/
	// �ж��Ƿ��и��ף�Ϊʹ����������ࣩ
	public boolean hasParent() {
		return null != parent;
	}

	// ���ص�ǰ�ڵ�ĸ��ڵ�
	public BinTreePosition getParent() {
		return parent;
	}

	// ���õ�ǰ�ڵ�ĸ��ڵ�
	public void setParent(BinTreePosition p) {
		parent = p;
	}

	// �ж��Ƿ�ΪҶ��
	public boolean isLeaf() {
		return !hasLChild() && !hasRChild();
	}

	// �ж��Ƿ�Ϊ���ӣ�Ϊʹ����������ࣩ
	// ����ǰ�ڵ��и��ף����������ӣ��򷵻�true�����򣬷���false
	public boolean isLChild() {
		return (hasParent() && this == getParent().getLChild()) ? true : false;
	}

	// �ж��Ƿ������ӣ�Ϊʹ����������ࣩ
	public boolean hasLChild() {
		return null != lChild;
	}

	// ���ص�ǰ�ڵ������
	public BinTreePosition getLChild() {
		return lChild;
	}

	// ���õ�ǰ�ڵ�����ӣ�ע�⣺this.lChild��c.parent����һ��Ϊ�գ�
	public void setLChild(BinTreePosition c) {
		lChild = c;
	}

	// �ж��Ƿ�Ϊ�Һ��ӣ�Ϊʹ����������ࣩ
	// ����ǰ�ڵ��и��ף��������Һ��ӣ��򷵻�true�����򣬷���false
	public boolean isRChild() {
		return (hasParent() && this == getParent().getRChild()) ? true : false;
	}

	// �ж��Ƿ����Һ��ӣ�Ϊʹ����������ࣩ
	public boolean hasRChild() {
		return null != rChild;
	}

	// ���ص�ǰ�ڵ���Һ���
	public BinTreePosition getRChild() {
		return rChild;
	}

	// ���õ�ǰ�ڵ���Һ��ӣ�ע�⣺this.rChild��c.parent����һ��Ϊ�գ�
	public void setRChild(BinTreePosition c) {
		rChild = c;
	}

	// ���ص�ǰ�ڵ���Ԫ�ص���Ŀ
	public int getSize() {
		return size;
	}

	// �ں��ӷ����仯�󣬸��µ�ǰ�ڵ㼰�����ȵĹ�ģ
	public void updateSize() {
		size = 1;// ��ǰ�ڵ�
		if (hasLChild())
			size += getLChild().getSize();// �������Ĺ�ģ
		if (hasRChild())
			size += getRChild().getSize();// �������Ĺ�ģ
		if (hasParent())
			getParent().updateSize();// �ݹ���¸��������ȵĹ�ģ��¼
	}

	// ���ص�ǰ�ڵ�ĸ߶�
	public int getHeight() {
		return height;
	}

	// �ں��ӷ����仯�󣬸��µ�ǰ�ڵ㼰�����ȵĸ߶�
	public void updateHeight() {
		height = 0;// �ȼ���û�����Һ���
		if (hasLChild())
			height = Math.max(height, 1 + getLChild().getHeight()); // ����
		if (hasRChild())
			height = Math.max(height, 1 + getRChild().getHeight()); // �Һ���
		if (hasParent())
			getParent().updateHeight();// �ݹ���¸��������ȵĸ߶ȼ�¼
	}

	// ���ص�ǰ�ڵ�����
	public int getDepth() {
		return depth;
	}

	// �ڸ��׷����仯�󣬸��µ�ǰ�ڵ㼰���������
	public void updateDepth() {
		depth = hasParent() ? 1 + getParent().getDepth() : 0; // ��ǰ�ڵ�
		if (hasLChild())
			getLChild().updateDepth();// �غ�������������£�
		if (hasRChild())
			getRChild().updateDepth();// �ݹ�ظ������к������ȼ�¼
	}

	// ������������Ĵ����ҵ���ǰ�ڵ��ֱ��ǰ��
	public BinTreePosition getPrev() {
		// ���������ǿգ������е�����߼�Ϊ��ǰ�ڵ��ֱ��ǰ��
		if (hasLChild())
			return findMaxDescendant(getLChild());
		// ���ˣ���ǰ�ڵ�û������
		if (isRChild())
			return getParent();// ����ǰ�ڵ����Һ��ӣ����׼�Ϊ��ֱ��ǰ��
		// ���ˣ���ǰ�ڵ�û�����ӣ�����������
		BinTreePosition v = this;// �ӵ�ǰ�ڵ����
		while (v.isLChild())
			v = v.getParent();// ��������һֱ����
		// ���ˣ�v����û�и��ף������Ǹ��׵��Һ���
		return v.getParent();
	}

	// ������������Ĵ����ҵ���ǰ�ڵ��ֱ�Ӻ��
	public BinTreePosition getSucc() {
		// ���������ǿգ������е���С�߼�Ϊ��ǰ�ڵ��ֱ�Ӻ��
		if (hasRChild())
			return findMinDescendant(getRChild());
		// ���ˣ���ǰ�ڵ�û���Һ���
		if (isLChild())
			return getParent();// ����ǰ�ڵ������ӣ����׼�Ϊ��ֱ�Ӻ��
		// ���ˣ���ǰ�ڵ�û���Һ��ӣ��������Һ���
		BinTreePosition v = this;// �ӵ�ǰ�ڵ����
		while (v.isRChild())
			v = v.getParent();// ���Һ�����һֱ����
		// ���ˣ�v����û�и��ף������Ǹ��׵�����
		return v.getParent();
	}

	// �Ͼ���ǰ�ڵ����丸�׵ĸ��ӹ�ϵ
	// ���ص�ǰ�ڵ�
	public BinTreePosition secede() {
		if (null != parent) {
			if (isLChild())
				parent.setLChild(null);// �жϸ���ָ��ǰ�ڵ������
			else
				parent.setRChild(null);
			parent.updateSize();// ���µ�ǰ�ڵ㼰�����ȵĹ�ģ
			parent.updateHeight();// ���µ�ǰ�ڵ㼰�����ȵĸ߶�
			parent = null;// �жϵ�ǰ�ڵ�ָ��ԭ���׵�����
			updateDepth();// ���½ڵ㼰�����ڵ�����
		}
		return this;// ���ص�ǰ�ڵ�
	}

	// ���ڵ�c��Ϊ��ǰ�ڵ������
	public BinTreePosition attachL(BinTreePosition c) {
		if (hasLChild())
			getLChild().secede();// ժ����ǰ�ڵ�ԭ�ȵ�����
		if (null != c) {
			c.secede();// c����ԭ����
			lChild = c;
			c.setParent(this);// ȷ���µĸ��ӹ�ϵ
			updateSize();// ���µ�ǰ�ڵ㼰�����ȵĹ�ģ
			updateHeight();// ���µ�ǰ�ڵ㼰�����ȵĸ߶�
			c.updateDepth();// ����c�������ڵ�����
		}
		return this;
	}

	// ���ڵ�c��Ϊ��ǰ�ڵ���Һ���
	public BinTreePosition attachR(BinTreePosition c) {
		if (hasRChild())
			getRChild().secede();// ժ����ǰ�ڵ�ԭ�ȵ��Һ���
		if (null != c) {
			c.secede();// c����ԭ����
			rChild = c;
			c.setParent(this);// ȷ���µĸ��ӹ�ϵ
			updateSize();// ���µ�ǰ�ڵ㼰�����ȵĹ�ģ
			updateHeight();// ���µ�ǰ�ڵ㼰�����ȵĸ߶�
			c.updateDepth();// ����c�������ڵ�����
		}
		return this;
	}

	// ǰ�����
	public Iterator elementsPreorder() {
		List list = new List_DLNode();
		preorder(list, this);
		return list.elements();
	}

	// �������
	public Iterator elementsInorder() {
		List list = new List_DLNode();
		inorder(list, this);
		return list.elements();
	}

	// �������
	public Iterator elementsPostorder() {
		List list = new List_DLNode();
		postorder(list, this);
		return list.elements();
	}

	// ��α���
	public Iterator elementsLevelorder() {
		List list = new List_DLNode();
		levelorder(list, this);
		return list.elements();
	}

	/**************************** �������� ****************************/
	// ��v�ĺ���У��ҳ���С��
	protected static BinTreePosition findMinDescendant(BinTreePosition v) {
		if (null != v)
			while (v.hasLChild())
				v = v.getLChild();// ��v��������������һֱ�½�
		// ���ˣ�v����Ϊ�գ�����û������
		return v;
	}

	// ��v�ĺ���У��ҳ������
	protected static BinTreePosition findMaxDescendant(BinTreePosition v) {
		if (null != v)
			while (v.hasRChild())
				v = v.getRChild();// ��v���������Һ�����һֱ�½�
		// ���ˣ�v����Ϊ�գ�����û���Һ���
		return v;
	}

	// ǰ�������vΪ���ڵģ��ӣ���
	protected static void preorder(List list, BinTreePosition v) {
		if (null == v)
			return;// �ݹ��������
		list.insertLast(v);// ����v
		preorder(list, v.getLChild());// ����������
		preorder(list, v.getRChild());// ����������
	}

	// ���������vΪ���ڵģ��ӣ���
	protected static void inorder(List list, BinTreePosition v) {
		if (null == v)
			return;// �ݹ��������
		inorder(list, v.getLChild());// ����������
		list.insertLast(v);// ����v
		inorder(list, v.getRChild());// ����������
	}

	// ���������vΪ���ڵģ��ӣ���
	protected static void postorder(List list, BinTreePosition v) {
		if (null == v)
			return;// �ݹ��������
		postorder(list, v.getLChild());// ����������
		postorder(list, v.getRChild());// ����������
		list.insertLast(v);// ����v
	}

	// ��α�����vΪ���ڵģ��ӣ���
	protected static void levelorder(List list, BinTreePosition v) {
		Queue_List Q = new Queue_List();// �ն�
		Q.enqueue(v);// ���ڵ����
		while (!Q.isEmpty()) {
			BinTreePosition u = (BinTreePosition) Q.dequeue();// ����
			list.insertLast(u);// ����v
			if (u.hasLChild())
				Q.enqueue(u.getLChild());
			if (u.hasRChild())
				Q.enqueue(u.getRChild());
		}
	}

	@Override
	public String toString() {
		return element.toString();
	}

	// ��������������㷨(������#1)
	public static void tranPre_I1(List list, BinTreePosition v) {
		// ����ջ
		Stack_List stack = new Stack_List();
		if (v != null)
			stack.push(v);// ���ڵ���ջ
		while (!stack.isEmpty()) {// ��ջ����֮ǰ����ѭ��
			v = (BinTreePosition) stack.pop();
			list.insertLast(v);// ������ڪ����ǰ�ڵ㣬��ǿպ��Ӱm��ջ����Ϊ
			if (v.hasRChild())
				stack.push(v.getRChild());// �Һ���������
			if (v.hasLChild())
				stack.push(v.getLChild());// ���Ӻ����ȳ�
		}

	}

	protected static void visitAlongLeftBranch(List list, BinTreePosition v, Stack_List stack) {
		while (v != null) {
			list.insertLast(v);// ڪ����ǰ�ڵ�
			stack.push(v.getRChild()); // �Һ�����ջ�ݴ棨���Ż���ͨ���`�ϣ�����յ��Һ�����ջ��
			if (v.hasLChild())
				v = v.getLChild(); // �����֧����һ��
		}
	}

	// ��������������㷨(������#2) ��̯O(1)
	public static void tranPre_I2(List list, BinTreePosition v) {
		// ����ջ
		Stack_List stack = new Stack_List();
		while (true) {
			visitAlongLeftBranch(list, v, stack);
			if (stack.isEmpty())
				break;
			v = (BinTreePosition) stack.pop();
		}
	}

	// �ӵ�ǰ�ڵ�����������֧آ�����룬ֱ��û�����֧�Ľڵ�
	static void goAlongLeftBranch(BinTreePosition v, Stack_List stack) {
		while (v != null) {
			stack.push(v);
//	    	if(v.hasLChild()) stack.push(v.getLChild());
			if (v.hasLChild()) {
				v = v.getLChild();
			} else {
				break;
			}
		} // ��ǰ�ڵ���ջ���漴������֧���룬����ֱ��������
	}

	// ��������������㷨��������#1��
	public static void travIn_I1(List list, BinTreePosition v) {
		// ����ջ
		Stack_List stack = new Stack_List();
		while (true) {
			goAlongLeftBranch(v, stack); // ����ǰ�ڵ������������ջ
			if (stack.isEmpty())
				break; // ֱ�����нڵ㴦�����
			v = (BinTreePosition) stack.pop();
			list.insertLast(v); // ����ջ���ڵ��ڪ�ʁT
			v = v.getRChild(); // ת��������
		}
	}

	// ��������������㷨��������#2��
	public static void travIn_I2(List list, BinTreePosition v) {
		// ����ջ
		Stack_List stack = new Stack_List();
		while (true)
			if (v != null) {
				stack.push(v); // ���ڵ���ջ
				v = v.getLChild(); // �������������
			} else if (!stack.isEmpty()) {
				v = (BinTreePosition) stack.pop(); // ��δڪ�ʰm������Ƚڵ���ջ
				list.insertLast(v); // ڪ��ڹ���Ƚڵ�
				v = v.getRChild(); // �������ȵ�������
			} else
				break; // �������
	}

	//ǰ�̽ڵ�
		public BinTreePosition prev() { // ��λ�ڵ�v��ֱ�Ӻ��
			BinTreePosition s = this; // ��¼��̵���ʱ����
			if (s.hasLChild()) { // �������ӣ���ֱ�Ӻ�̱����������У�����ؾ���
				s =  s.getLChild(); // ��������
				while (s.hasRChild())
					s = s.getRChild(); // �����С���m�ڵ�
			} else { // ����ֱ�Ӻ��Ӧ�ǡ�����ǰ�ڵ���������������е�������ȡ�������ؾ���
				while (s.isLChild())
					s = s.getParent(); // ������������֧�����ϳ������ƶ�
				s = s.getParent(); // ����ٳ����ϔڶ�۽һ�������ִ�ֱ�Ӻ�̣��疈���ڣ�
			}
			return s;
		}
	
	//��̽ڵ�
	public BinTreePosition succ() { // ��λ�ڵ�v��ֱ�Ӻ��
		BinTreePosition s = this; // ��¼��̵���ʱ����
		if (s.hasRChild()) { // �����Һ��ӣ���ֱ�Ӻ�̱����������У�����ؾ���
			s =  s.getRChild(); // ��������
			while (s.hasLChild())
				s = s.getLChild(); // �����С���m�ڵ�
		} else { // ����ֱ�Ӻ��Ӧ�ǡ�����ǰ�ڵ���������������е�������ȡ�������ؾ���
			while (s.isRChild())
				s = s.getParent(); // ������������֧�����ϳ������ƶ�
			s = s.getParent(); // ����ٳ����ϔڶ�۽һ�������ִ�ֱ�Ӻ�̣��疈���ڣ�
		}
		return s;
	}

	// ��������������㷨��������#3��
	public static void travIn_I3(List list, BinTreePosition v) { // ��������������㷨��������#3�����踨��ջ��
		boolean backtrack = false; // ǰһ���Ƿ�մ����������ݡ���ʡȥջ����O(1)���ӿռ�
		while (true)
			if (!backtrack && v.hasLChild()) { // �����������Ҳ��Ǹոջ��ݣ���
				v = v.getLChild();
			} // �������������
			else { // ���򡪡�����������ոջ��ݣ�����ء����������
				list.insertLast(v); // ڪ��ڹ�ڵ�
				if (v.hasRChild()) { // �����������ǿգ���
					v = v.getRChild(); // ������������������
					backtrack = false; // �ԃ̱ջ��ݱ�־
				} else { // ���������գ���
					if (v.succ() ==null)
						break; // ���ݣ����ִ�ĩ�ڵ�ʱ�m�˳�ކ�أ�
					backtrack = true; // ��ک�û��ݱ�־
				}
			}
	}

	public static void main(String[] args) {
		BinTreeNode root = new BinTreeNode();
		root.setElem("1");
		// ������
		BinTreeNode rootLeft = new BinTreeNode();
		BinTreeNode leftSonL = new BinTreeNode();
		BinTreeNode leftSonR = new BinTreeNode();
		rootLeft.setElem("2");
		leftSonL.setElem("4");
		leftSonR.setElem("5");
		rootLeft.setParent(root);
		rootLeft.setLChild(leftSonL);
		rootLeft.setRChild(leftSonR);
		leftSonL.setParent(rootLeft);
		leftSonR.setParent(rootLeft);

		// ������
		BinTreeNode rootRight = new BinTreeNode();
		BinTreeNode rightSonL = new BinTreeNode();
		BinTreeNode rightSonR = new BinTreeNode();
		rootRight.setElem("3");
		rightSonL.setElem("6");
		rightSonR.setElem("7");
		rightSonR.setParent(rootRight);
		rootRight.setLChild(rightSonL);
		rootRight.setRChild(rightSonR);
		rightSonL.setParent(rootRight);
		
		
		root.setLChild(rootLeft);
		root.setRChild(rootRight);
		List_DLNode list = new List_DLNode();
//	BinTreeNode.tranPre_I2(list, root);
//	BinTreeNode.tranPre_I1(list, root);
		// �������
//	BinTreeNode.inorder(list, root);
//	BinTreeNode.travIn_I1(list, root);
//	BinTreeNode.travIn_I2(list, root);
	BinTreeNode.travIn_I3(list, root);
//	System.out.println(rightSonR.succ());
//	System.out.println(rightSonR.getSucc());
//	System.out.println(rightSonR.getPrev());
//	System.out.println(rightSonR.prev());
		for (Iterator iterator = list.elements(); iterator.hasNext();) {
			Object obj = iterator.getNext();
			System.out.println(obj.toString());
		}
	}
}