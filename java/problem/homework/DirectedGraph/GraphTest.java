//****************************************************************
// ���ϸ�: GraphTest.java
// �ۼ���:���ؿ�
// �ۼ���: 2016-6-02
// ����: ����׷����� ���������� �׽�Ʈ�ϴ� ���α׷�
//****************************************************************
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class GraphTest {
	public static void main(String arg[]) throws IOException{
		System.out.println("hw9_1 : ���ؿ�\n");
		Scanner input = new Scanner(new File("hw9_1.txt"));
		
		int v = input.nextInt();
		int e = input.nextInt();
		DAG graph = new DAG(v,e);
		
		for(int i=0; i<e; i++){
			int v1=input.nextInt();
			int v2=input.nextInt();
			graph.link(v1,v2);
		}
		graph.print();
		boolean error = graph.topologicalSort2();
		if(!error)
			System.out.print("\nDAG�� �ƴմϴ�.");
	}
}
