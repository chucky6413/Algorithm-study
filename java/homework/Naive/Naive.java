//***************************
// ���ϸ�: Naive.java
// �ۼ���: ���ؿ�
// �ۼ���: 2016.06.04
// ���α׷� ����:Naive �˰����� �̿��� ���ڿ� ��Ī
//***************************
import java.util.Scanner;

public class Naive {
	public static void main(String arg[]){
		System.out.println("hw10_1 : ���ؿ�\n");
		
		Scanner input = new Scanner(System.in);
		String line;
		char[] text,pattern;
		
		System.out.print("�ؽ�Ʈ:");
		line=input.next();
		text = line.toCharArray();
		
		System.out.print("����:");
		line=input.next();
		pattern = line.toCharArray();
		
		naiveMatching(text,pattern); //�Լ� ȣ��
		
	}
	public static void naiveMatching(char[] text,char[] pattern){
		int n=text.length;
		int m=pattern.length;
		int count=0;
		System.out.print("��Ī ��ġ:");
		//���� for�� ��� O(mn)
		for(int i=0;i<n-m+1;i++){ //O(n)
			int k=i;
			for(int j=0;j<m;j++){ //O(m)
				if(text[k]==pattern[j])
					k++;
				else
					break;
			}
			if(k==(i+m)){
				System.out.print(i+" ");
				count++;
			}
		}
		if(count==0)
			System.out.println("��Ī�� �Ͼ�� ����.");
	}
}
