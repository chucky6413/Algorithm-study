//****************************************************************
// ���ϸ�: HashTest.java
// �ۼ���:���ؿ�
// �ۼ���:2016-05-09
// ����: �ؽ����̺��� �̿��Ͽ� ����,�˻�,����,��ȸ ��� ���� �����ϴ� ���α׷�
//****************************************************************

import java.util.Scanner;

public class HashTest {
	public static void main(String arg[]){
		System.out.println("hw6_1 : ���ؿ�\n");
		int size;
		Scanner input = new Scanner(System.in);
		System.out.print("���̺� ũ�� �Է�:");
		size=input.nextInt();
		Hash hash = new Hash(size);
		int sel=0;
		int x;
		while(sel!=5){
			System.out.println("1:���� 2:�˻� 3:���� 4:��ü��� 5:����");
			System.out.print("����:");
			sel=input.nextInt();
			switch(sel){
			case 1:
				System.out.print("������ �й�:");
				x=input.nextInt();
				hash.insert(x);
				break;
			case 2:
				System.out.print("�˻��� �й�:");
				x=input.nextInt();
				hash.search(x);
				break;
			case 3:
				System.out.print("������ �й�:");
				x=input.nextInt();
				hash.delete(x);
				break;
			case 4:
				hash.print();
				break;
			case 5:
				System.out.println("�����մϴ�.");
				break;
			}
		}
		
	}
}
