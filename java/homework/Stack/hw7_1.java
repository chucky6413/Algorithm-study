//***************************
 // ���ϸ�: hw7_1.java
 // �ۼ���: ���ؿ�
 // �ۼ���: 2015.10.16
 // ����: ���� ������ ����
//***************************
interface Stack{
	boolean isEmpty();
	boolean isFull();
	int pop();
	void push(int item);
}
class IntegerStack implements Stack{ //�������� �����ϴ� StackŬ����
	private int ArrayItem[];
	private int top=-1;
	private int stackSize=5;
	
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

public class hw7_1 {
	public static void main(String arg[]){
		
		IntegerStack stack1=new IntegerStack(); //��ü ����
		int deleteItem; //������ �׸�
		int delSum=0; //������ ��
		
		System.out.println("hw7_1:���ؿ�\n");
		
		stack1.push(-1);
		stack1.push(0);
		stack1.push(1);
		stack1.push(2);
		stack1.push(3);
		stack1.push(4);
		
		System.out.println();
		deleteItem=stack1.pop();
		System.out.print(deleteItem+" ");
		deleteItem=stack1.pop();
		System.out.print(deleteItem+" ");
		deleteItem=stack1.pop();
		System.out.print(deleteItem+" ");
		deleteItem=stack1.pop();
		System.out.print(deleteItem+" ");
		deleteItem=stack1.pop();
		System.out.print(deleteItem+" ");
		
		System.out.println();
		stack1.push(10);
		stack1.push(30);
		stack1.push(50);
		deleteItem=stack1.pop();
		System.out.println(deleteItem+" ");
		stack1.push(70);
		
		delSum+=stack1.pop();
		delSum+=stack1.pop();
		delSum+=stack1.pop();
		
		System.out.println("������ ���� ��:"+delSum);
	}
}
