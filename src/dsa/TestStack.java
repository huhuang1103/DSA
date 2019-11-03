package dsa;

public class TestStack {

	public static char[] digit  = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
	/**
	 *  进制转换
	 * @param s
	 * @param n
	 * @param base
	 */
	public static void convert(Stack_Array s,int n , int base) {
		while(n>0) {
			s.push(digit[n%base]);
			n/=base;//n更新为其对base的除商
		}
		
	}
	
	public static void main(String[] args) {
		Stack_Array s = new Stack_Array();
		/*convert(s, 648, 8);
		while(!s.isEmpty()) {
			System.out.println(s.pop());
		}*/
		
		char expr[] = {'(','(',')','(','(',')',')',')'};
		System.out.println(paren(expr, 0, expr.length));
	}
	
	public static boolean paren(char expr[],int lo , int hi) {
		Stack_Array S = new Stack_Array();
		for(int i =lo ;i<hi;i++) {
			if('('==expr[i]) {
				S.push(expr[i]);
			}else if(!S.isEmpty()) {
				S.pop();
			}else {
				return false;
			}
		}
		return S.isEmpty();
		
	}
	
	public static float evaluate(char S) {
		Stack_Array opnd = new Stack_Array();//操作数栈
		Stack_Array optr = new Stack_Array();//操作符栈
		optr.push("\0");
		while(!optr.isEmpty()) {
			
		}
		return S;
		
	}
	
}
