//******************************************************
 // ���ϸ�: hw11_1.java
 // �ۼ���: ���ؿ�
 // �ۼ���: 2015.11.29
 // ����:  �ܾ����� ��Ű�� ��������
 //******************************************************

import java.util.*;

class Sort{
	public static void insertionSort(String a[],int size){
		int i,j;
		String item;
		for(i=1;i<size;i++){
			item=a[i];
			j=i;
			while((j>0)&&((a[j-1].compareToIgnoreCase(item)>0))){
				a[j]=a[j-1];
				j--;
			}
			a[j]=item;
		}
	}
}
public class InsertionSort {
	@SuppressWarnings("static-access")
	public static void main(String arg[]){
		System.out.println("hw11_1:���ؿ�\n");
		Scanner input=new Scanner(System.in);
		int num;
		Sort s1=new Sort();
		
		System.out.print("�ܾ� �� �Է� : ");
		num=input.nextInt();
		input.nextLine();
		String s[] = new String[num];
			
		System.out.println(num+"���� �ܾ� �Է� : ");
		for(int i=0;i<num;i++){
			s[i]=input.nextLine();
		}
		
		s1.insertionSort(s, num);

		System.out.println("\n���� �� ��� : ");
		for(int i=0;i<num;i++){
			System.out.println(s[i]);
		}
	}
}
