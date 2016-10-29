//****************************************************************
// ���ϸ�: DirectedGraph.java
// �ۼ���:���ؿ�
// �ۼ���: 2016-6-02
// ����: DAG�� ���������� ������ ���α׷�
//****************************************************************
public class DAG {
	private Node[] list;
	private int numberOfVertices;
	private int numberOfEdges;
	
	private boolean[] visited;
	private boolean[] finalize;//cycle �˻縦 ���� �迭
	private Node R; //���������� ���� Node
	
	private class Node{
		int vertex;
		Node next;
	}
	//������
	public DAG(int v,int e){
		list = new Node[v];
		visited = new boolean[v];
		finalize = new boolean[v];
		numberOfVertices = v;
		numberOfEdges=e;
	}
	
	public void link(int v1,int v2){
		Node newnode = new Node();
		newnode.vertex=v2;
		newnode.next=list[v1];
		list[v1]=newnode;
	}
	public void print(){
		  for(int i=0; i<numberOfVertices; i++) {
			   Node first = list[i];
			   System.out.print("����"+i+"�� ��������Ʈ ");
			   while(first!=null){
			    System.out.print("-->"+first.vertex);
			    first=first.next;
			   }
			   System.out.println(); 
		  }
	}
	public boolean topologicalSort2(){
		boolean cycle;
		for(int i=0;i<numberOfVertices;i++){
			visited[i]=false;
			finalize[i]=false;
		}
		for(int i=0;i<numberOfVertices;i++)
			if(!visited[i]){
				cycle=DFS_TS(i);
				if(cycle)
					return false; //DAG�� �ƴ� ��� ����
			}
		
		//�������� ��� ���
		Node first = R;
		System.out.print("\n�������� ��� : ");
		while(first!=null){
			System.out.print(first.vertex+" ");
			first=first.next;
		}
		return true;
	}
	public boolean DFS_TS(int v){
		visited[v] = true;
		Node first = list[v];
		while(first!=null){
			if(!visited[first.vertex])
				DFS_TS(first.vertex);
			if(visited[first.vertex] && !finalize[first.vertex]) //visited �ε� finalize�� �ƴ϶�� cycle�� �����ϴ� ���̴�.
				return true;
			first=first.next;
		}
		//���� ����Ʈ R�� �� �տ� ���� V�� �����Ѵ�.
		Node newnode = new Node();
		newnode.vertex=v;
		newnode.next=R;
		R=newnode;
		finalize[v] = true; //������ ���� finalize
		return false;
	}
}
