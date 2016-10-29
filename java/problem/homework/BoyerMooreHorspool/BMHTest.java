//***************************
// ���ϸ�: BMHTest.java
// �ۼ���: ���ؿ�
// �ۼ���: 2016.06.04
// ���α׷� ����:���̾�-����-ȣ��Ǯ �˰����� �̿��� ���ڿ� ��Ī
//***************************
import java.util.Scanner;
import java.util.HashMap;

public class BMHTest {
	public static void main(String arg[]){
		System.out.println("hw10_2 : ���ؿ�\n");
		
		Scanner input = new Scanner(System.in);
		String line;
		char[] text,pattern;
		
		System.out.print("�ؽ�Ʈ:");
		line=input.next();
		text = line.toCharArray();
		
		System.out.print("����:");
		line=input.next();
		pattern = line.toCharArray();
		
		BoyerMooreHorspool(text,pattern); //�Լ� ȣ��
	
		
	}
	public static void BoyerMooreHorspool(char[] text,char[] pattern){
		int n=text.length;
		int m=pattern.length; //������ ���� jump�� ��Ÿ ��
		HashMap<Character,Integer> jump = new HashMap<Character,Integer>();
		
		computeJump(pattern,jump); //��ó�� : ����ð� O(m)
		int i=0,j,k,count=0;
		System.out.print("��Ī ��ġ:");
		while(i<n-m+1){
			j=m-1;
			k=i+m-1;
			while(j>=0 && pattern[j]==text[k]){
				j--;
				k--;
			}
			if(j==-1){
				System.out.print((k+1)+" ");
				count++;
			}
			if(jump.get(text[i+m-1])!=null)
				i=i+jump.get(text[i+m-1]);
			else
				i=i+m;
		}
		if(count==0)
			System.out.println("��Ī�� �Ͼ�� ����.");
		
	}
	public static void computeJump(char[] pattern,HashMap jump){
		int m=pattern.length;
		System.out.println(m);
		for(int i=1;i<m;i++){
			if(jump.get(pattern[m-i-1])==null) //���� ������ ��� ���������� �����ϱ� ������
				jump.put(pattern[m-i-1],i);  //���� ������ ������ �����Ѵ�. pattern�� �ڿ��� 2��° �ڸ�����
		}
		if(jump.get(pattern[m-1])==null) //���� ���� ���� ���
			jump.put(pattern[m-1],m);  //������ ������ �ڸ����� pattern�� ������ m�̴�.
	}
}
