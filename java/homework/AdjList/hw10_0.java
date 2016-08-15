//******************************************************
 // ���ϸ�: hw10_0.java
 // �ۼ���: ���ؿ�
 // �ۼ���: 2015.11.17
 // ����:  adjacency list�� �̿��� �׷��� ����
 //******************************************************
import java.util.*;

class GraphNode{
	int vertex;
	GraphNode link;
}
class AdjList{
	private GraphNode head[];
	private int totalV=0;
	
	public AdjList(int v){
		head=new GraphNode[v];
		totalV=v;
	}
	public void addEdge(int v1,int v2){
		if(v1>=totalV||v2>=totalV)
			System.out.println("�׷����� ���� �����Դϴ�!");
		else{
			GraphNode gNode = new GraphNode();
			gNode.vertex=v2;
			gNode.link=head[v1];
			head[v1]=gNode;
			
			GraphNode gNode2 = new GraphNode();
			gNode2.vertex=v1;
			gNode2.link=head[v2];
			head[v2]=gNode2;
		}
	}
	public void printAdjacentVertecies(int n){
		GraphNode gNode = new GraphNode();
		System.out.print(n+"�� ������ ���� : ");
		gNode=head[n];
		while(gNode!=null){
			System.out.printf("%d ",gNode.vertex);
			gNode=gNode.link;
		}
		System.out.println();
	}
}

public class hw10_0{
	public static void main(String arg[]){
		System.out.println("hw10_0 : ���ؿ�\n");
		int sel=0,n;
		Scanner input=new Scanner(System.in);
		System.out.print("���� �� �Է� : ");
		n=input.nextInt();
		AdjList a = new AdjList(n);
		while(sel!=3){
			System.out.println();
			int v,v1,v2;
			System.out.print("1:�������� 2:������������ 3:����-->");
			sel=input.nextInt();
			switch(sel){
			case 1:
				System.out.print("������ ������ �Է��ϼ���(���� ��ȣ 2��):");
				v1=input.nextInt();
				v2=input.nextInt();
				a.addEdge(v1, v2);
				break;
			case 2:
				System.out.print("���� ��ȣ�� �Է��ϼ��� : ");
				v=input.nextInt();
				a.printAdjacentVertecies(v);
				break;
			case 3:
				break;
			}
		}
		
	}
}