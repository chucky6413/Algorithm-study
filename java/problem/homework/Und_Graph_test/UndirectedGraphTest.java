//******************************************************
 // ���ϸ�: hw10_1.java
 // �ۼ���: ���ؿ�
 // �ۼ���: 2015.11.19
 // ����:  UndirectedGraph�� ���� �켱 Ž�� ���α׷�
 //******************************************************
import java.util.*;

abstract class UndirectedGraph{
	int addEdge(int v1,int v2){return 1;};
	int printAdjacentVertecies(int n){return 1;};
	void depthFirstSearch(int v){};
	void BreadthFirstSearch(int v){};
}

class StackNode{
	int data;
	StackNode link;
}

class LinkedStack{
	StackNode top;
	 
	public boolean isEmpty(){
		 return (top==null);
	}
	 
	public void push(int item){
		StackNode newNode = new StackNode();
		newNode.data=item;
		newNode.link=top;
		top=newNode;
	}
	public int pop(){
		if(isEmpty()){
			System.out.println("pop ���� ����");
			return 0;
		}
		else{
			int item=top.data;
			top=top.link;
			return item;
		}
	}
}
class QNode{
	int data;
	QNode link;
}
class LinkedQueue{
	QNode front;
	QNode rear;
	
	public LinkedQueue(){
		front = null;
		rear = null;
	}
	public boolean isEmpty(){
		return (front==null);
	}
	public void enQueue(int item){
		QNode newNode = new QNode();
		newNode.data = item;
		newNode.link = null;
		if(isEmpty()){
			front = newNode;
			rear = newNode;
		}
		else{
			rear.link = newNode;
			rear = newNode;
		}
	}
	public int deQueue(){
		if(isEmpty()){
			System.out.println("deQueue ����!!");
			return 0;
		}
		else{
			int item=front.data;
			front=front.link;
			if(front==null){
				rear=null;
			}
			return item;
		}
	}
}

class GraphNode{
	int vertex;
	GraphNode link;
}
class AdjList extends UndirectedGraph{
	private GraphNode head[];
	private int totalV=0;
	
	public AdjList(int v){
		head=new GraphNode[v];
		totalV=v;
	}
	public int min(){ //�ּ� ������ ã���ִ� �Լ�
		int v=0;
		while(v<totalV)
		{
			if(head[v]!=null)
				return v;
			else
				v++;
		}
		return -1;
	}
	public int addEdge(int v1,int v2){
		if(v1>=totalV||v2>=totalV||v1<0||v2<0){ //���� ���Խ� �߸��� ������ �Էµɽ� 1��ȯ
			if(v1>=totalV||v1<0){
				System.out.println(v1+"��/�� �׷����� ���� �����Դϴ�!");
				return 0;
			}
			else
				System.out.println(v2+"��/�� �׷����� ���� �����Դϴ�!");
				return 0;	
		}
		else{
			GraphNode eNode = new GraphNode();
			eNode=head[v1]; //�ߺ��� ���� �˻�� ���
			while(eNode!=null){ 
				if(eNode.vertex==v2){ //�ߺ��� ������ ���� �� 0 �� ��ȯ�ϰ� main���� ���Է��� �����Ѵ�.
					System.out.println("�ߺ��� �����Դϴ�.");
					return 0;
				}
				else
					eNode=eNode.link;
			}
			GraphNode gNode = new GraphNode();
			gNode.vertex=v2;
			gNode.link=head[v1];
			head[v1]=gNode;
			if(head[v1].link!=null)
				if(gNode.vertex>gNode.link.vertex) //���� ���Խ� ���� �������� ũ�⸦ ���Ͽ� ������������ ���Ľ����ִ�
					sortG(gNode,v1); //sortG ȣ��
				
			GraphNode gNode2 = new GraphNode();
			gNode2.vertex=v1;
			gNode2.link=head[v2];
			head[v2]=gNode2;
			if(head[v2].link!=null)
				if(gNode2.vertex>gNode2.link.vertex)
					sortG(gNode2,v2);
			return 1;
		}
	}
	public void sortG(GraphNode g,int v){
		head[v]=sortGraph(g);
	}
	public GraphNode sortGraph(GraphNode g){ //�������� ���ĸ޼ҵ�
		GraphNode gNode=g;

		GraphNode temp=new GraphNode();
		temp.link=gNode.link.link;
		gNode.link.link=gNode;
		gNode=gNode.link;
		gNode.link.link=temp.link;
		if(gNode.link.link!=null)
			if(gNode.link.vertex>gNode.link.link.vertex)
				gNode.link=sortGraph(gNode.link);
		return gNode;
	}
	public int printAdjacentVertecies(int n){
		if(n>=totalV||n<0){ //�߸��� ���� �Է½� 0 ��ȯ
			System.out.println(n+"��/�� �׷����� ���� �����Դϴ�!");
			return 0;
		}
		else{
		GraphNode gNode = new GraphNode();
		System.out.print(n+"�� ������ ���� : ");
		gNode=head[n];
		while(gNode!=null){
			System.out.printf("%d ",gNode.vertex);
			gNode=gNode.link;
		}
		System.out.println();
		return 1;
		}
	}
	public void depthFirstSearch(int v){
		GraphNode w=new GraphNode();
		GraphNode b=new GraphNode();
		LinkedStack S=new LinkedStack();
		boolean visited[]=new boolean[10];
		S.push(v);
		visited[v]=true;
		System.out.printf("%d ",v);
		while(S.top!=null){
			w=head[v];
			while(w!=null){
				if(visited[w.vertex]==false){
					S.push(w.vertex);
					visited[w.vertex]=true;
					System.out.printf("%d ", w.vertex);
					v=w.vertex;
					w=head[v];
				}
				else w=w.link;
			}
			v=S.pop();
			if(v==min()){
				b=head[v];
				while(b!=null)
				{
					if(visited[b.vertex]==false)
					{
						S.push(v);
						break;
					}
					b=b.link;
				}
			}
		}
		System.out.println();
	}
	public void BreadthFirstSearch(int v){
		GraphNode w = new GraphNode();
		LinkedQueue Q = new LinkedQueue();
		boolean visited[] = new boolean[10];
		visited[v]=true;
		System.out.print(v+" ");
		Q.enQueue(v);
		while(!Q.isEmpty()){
			v=Q.deQueue();
			for(w=head[v];w!=null;w=w.link){
				if(visited[w.vertex]==false){
					visited[w.vertex]=true;
					System.out.print(w.vertex+" ");
					Q.enQueue(w.vertex);
				}
			}
		}
	}
}

public class UndirectedGraphTest{
	public static void main(String arg[]){
		System.out.println("hw10_1 : ���ؿ�\n");
		int sel=0,n=0;
		int e=0; //���� ã�� ���� ����
		Scanner input=new Scanner(System.in);
		while(e==0){
		System.out.print("���� �� �Է� : ");
		n=input.nextInt();
		if(n>=0&&n<11) //boolean �迭�� ũ�⸦ 10���� ���������Ƿ� n�� ������ �ƴϰ� 10���� ���� �� ����.
			e=1;
		else
			System.out.println("0�̻� 10������ ���ڸ� �Է��Ͻÿ�.");
		}
		AdjList a = new AdjList(n);
		while(sel!=5){
			System.out.println();
			int v,v1,v2;
			System.out.print("1:�������� 2:������������ 3:���̿켱Ž�� 4:�ʺ�켱Ž�� 5:����-->");
			sel=input.nextInt();
			switch(sel){
			case 1:
				e=0;
				while(e==0){ //�߸��� �������� ���� ���Կ� ������ ��� �ݺ� �Է�
				System.out.print("������ ������ �Է��ϼ���(���� ��ȣ 2��):");
				v1=input.nextInt();
				v2=input.nextInt();
				e=a.addEdge(v1, v2);
				}
				break;
			case 2:
				e=0;
				while(e==0){ //�߸��� ������ȣ �Է½� �ݺ� �Է�
				System.out.print("���� ��ȣ�� �Է��ϼ��� : ");
				v=input.nextInt();
				e=a.printAdjacentVertecies(v);
				}
				break;
			case 3:
				System.out.print("���̿켱Ž�� : ");
				if(a.min()!=-1)
					a.depthFirstSearch(a.min());
				break;
			case 4:
				System.out.print("�ʺ�켱Ž�� : ");
				e=a.min();
				if(a.min()!=-1)
					a.BreadthFirstSearch(a.min());
				break;
			case 5:
				break;
			}
		}
		
	}
}