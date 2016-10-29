//***************************
 // ���ϸ�: hw7_2.java
 // �ۼ���: ���ؿ�
 // �ۼ���: 2015.10.16
 // ����: ����ǥ����� ����ϴ� ���α׷� ����ó���� ���ο��� �� �� �ֵ��� �����ִ� ����̴�.
 //***************************


import java.util.Scanner;
import java.util.StringTokenizer;

class FailOptException extends Exception{ // �߸��� ���� ����Ŭ���� ����.
	public FailOptException(){
		super("�߸��� �����Դϴ�.");
	}
}
class ArithmeticException extends Exception{ // �߸��� ���� ����Ŭ���� ����.
	public ArithmeticException(){
		super("0���δ� ���� �� �����ϴ�. �����մϴ�.");
	}
}

interface Stack{
	boolean isEmpty();
	boolean isFull();
	int pop();
	void push(int item);
}

class IntegerStack implements Stack{ //�������� �����ϴ� StackŬ����
	private int ArrayItem[];
	private int top=-1;
	private int stackSize=100;
	
	public IntegerStack(){ //������
		ArrayItem=new int[stackSize];
	}
	
	public boolean isEmpty(){
		return (top==-1);
	}
	public boolean isFull(){
		return (top==this.stackSize-1);
	}
	public int pop(){
		if(isEmpty()){
			System.out.println("������ ����ֽ��ϴ�.");
			return 0;
		}
		else
			return ArrayItem[top--];
	}
	public void push(int item){
		if(isFull())
			System.out.println("������ �����ֽ��ϴ�.");
		else
			ArrayItem[++top]=item;
	}
}

class OptExp{
	private String exp;
	
	public int evalPostfix(String s) throws FailOptException,ArithmeticException{  //����ó���� �����Լ����� �ϵ��� ���� �־���.
		IntegerStack S=new IntegerStack();
		exp=s;
		char testCh;
		int opr1,opr2,result=0;
		int size;
		
		StringTokenizer st=new StringTokenizer(exp," ");
		size=st.countTokens();
		for(int i=0;i<size;i++){
			exp=st.nextToken();
			
			if(exp.equals("+")||exp.equals("-")||exp.equals("*")||exp.equals("/")){
				testCh=exp.charAt(0);
				switch(testCh){
				case '+': opr2=S.pop(); opr1=S.pop();S.push(opr1+opr2);break;
				case '-': opr2=S.pop(); opr1=S.pop();S.push(opr1-opr2);break;
				case '*': opr2=S.pop(); opr1=S.pop();S.push(opr1*opr2);break;
				case '/': opr2=S.pop(); opr1=S.pop();
				if(opr2==0)
					throw new ArithmeticException();
				else
					S.push(opr1/opr2);break;
				}
			}
			else{
				S.push(Integer.parseInt(exp));
			}		
		}
		
		result = S.pop();
		if(S.isEmpty()) //����ó���� ���ο��� ���ֵ��� ���� �־���.
			return result;
		else
			throw new FailOptException();
	}
}

public class hw7_2 {
	public static void main(String arg[]) {
		System.out.println("hw7_2:���ؿ�\n");
		String s;
		Scanner input=new Scanner(System.in);
		
		System.out.println("���� ���� ���� �Է�");
		s=input.nextLine();
		try{ //����ó���� main ���� ���ش�.
		OptExp op = new OptExp();
		System.out.println("��� ��� = "+op.evalPostfix(s));
		}catch(FailOptException e){
			System.err.println(e.getMessage());
		}catch(ArithmeticException e){
			System.err.println(e.getMessage());
		}catch(NumberFormatException e){ // .���� �̻��� ���ĵ� ����ش�.
			System.err.println("�߸��� �����Դϴ�.");
		}
	}
}
