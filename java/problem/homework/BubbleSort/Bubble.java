//***************************
// ���ϸ�: Bubble.java
// �ۼ���: ���ؿ�
// �ۼ���: 2016/03/20
// ���α׷� ����: ���Ͽ��� �Է¹��� �ܾ���� �����Ͽ� ����ϴ� ���α׷� �Դϴ�. �ּ��� ��츦 ����մϴ�.
//***************************

import java.util.Scanner;
import java.io.*;

public class Bubble {
	public static void main(String arg[])throws IOException{
		int num,count=0;
		Scanner fs;
		String words[],temp;
		boolean sorted;
		
		System.out.println("hw3_1 : ���ؿ�\n");
		fs=new Scanner(new File("hw3_1.txt"));
		num=Integer.parseInt(fs.next());
		words=new String[num];
		//���� �� ���
		System.out.print("���� �� : ");
		for(int i=0;i<num;i++){
			words[i]=fs.next();
			System.out.print(words[i]+" ");
		}
		System.out.println();
		
		//bublesort �� ����
		for(int last=num;last>1;last--){
			sorted=true;
			for(int i=0;i<last-1;i++){
				if(words[i].compareToIgnoreCase(words[i+1])>0){
					temp=words[i];
					words[i]=words[i+1];
					words[i+1]=temp;
					sorted=false;
					count++;
				}
			}
			if(sorted==true) break;
		}
		
		//���� �� ���
		System.out.print("���� �� : ");
		for(int i=0;i<num;i++){
			System.out.print(words[i]+" ");
		}
		System.out.println();
		System.out.println("�ܾ� ��ȯ Ƚ�� : "+count);
	}
}
