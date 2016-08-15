//****************************************************************
// ���ϸ�: Hash.java
// �ۼ���:���ؿ�
// �ۼ���:2016-05-09
// ����: �����迭,���̺� ũ��� �������� �޼ҵ带 ���� �ִ� Hash Ŭ����
//****************************************************************

public class Hash {
	private static int t[]=null;
	private static int size=0;
	
	public Hash(int size){ //������. �˰����� null�� �ǹ��ϴ� -1�� �������ݴϴ�.
		this.size=size;
		t=new int[size];
		for(int i=0;i<size;i++)
			t[i]=-1;
	}
	
	public static void insert(int x){
		int db=hashSearch(x);
		if(db==-1){
			int	error=hashInsert(x);
			if(error==-1){
				System.out.println("���� ����(���̺��� ���� á���ϴ�)\n");
			}else{
				System.out.println("���� ����\n");
			}
		}else{
			System.out.println("�ߺ��� ���� ������ �� �����ϴ�.\n");
		}
	}
	public static void search(int x){
		int error=hashSearch(x);
		if(error==-1){
			System.out.println("�˻� ����\n");
		}else{
			System.out.println("���̺��� "+error+"�ε����� �� "+x+"�� �����մϴ�.\n");
		}
	}
	public static void delete(int x){
		int db=hashSearch(x);
		if(db==-1){
			System.out.println("������ ���� �������� �ʽ��ϴ�.\n");
		}else{
			hashDelete(db);
			System.out.println("���� ����\n");
		}
	}
	public static void print(){
		hashPrint();
	}
	
	//���� �޼ҵ�
	private static int h(int i,int x){
		return (i+x)%size;
	}
	private static int hashInsert(int x){
		int i=0;
		int j=0;
		do{
			j=h(i,x);
			if(t[j]==-1 || t[j]==-2){ //null �̰ų� DELETED �϶��� ���� ����.
				t[j]=x;
				return j;
			}else{
				i++;
			}
		}while(i<size);
		
		System.out.println("���̺� �����÷ο�");
		return -1;
	}
	private static int hashSearch(int x){
		int i=0;
		int j=0;
		do{
			j=h(i,x);
			if(t[j]==x){
				return j;
			}else{
				i++;
			}
		}while(t[j]!=-1 && i<size);
		
		return -1;
	}
	private static void hashDelete(int x){
		t[x]=-2; //DELETED �� �ǹ��ϴ� -2�� ����.
	}
	private static void hashPrint(){
		for(int i=0;i<size;i++){
			if(t[i]==-1){
				System.out.println("index "+i+":null");
			}else if(t[i]==-2){
				System.out.println("index "+i+":DELETED");
			}else{
				System.out.println("index "+i+":"+t[i]);
			}
			
		}
		System.out.println();
	}
}
