//****************************************************************
// ���ϸ�: BsTest.java
// �ۼ���:���ؿ�
// �ۼ���:2016-05-13
// ����: �����˻�Ʈ���� �̿��Ͽ� �˻��� ���Ա�� ���� �����ϴ� ���α׷�
//****************************************************************
import java.util.Scanner;

public class BsTest {
	public static void main(String arg[]){
		System.out.println("hw5_1 : ���ؿ�\n");
		Scanner input = new Scanner(System.in);
		
		BinarySearchTree tree = new BinarySearchTree();
		int sel=0;
		int id=0;
		
		while(true){
			System.out.println("1.ȸ������ 2.����Ʈ��ȸ 3.����Ʈ���� 4.��ü��ȸ 5.ȸ������ȸ 6.ȸ��Ż�� 7.����");
			System.out.print("�Է� : ");
			sel=input.nextInt();
			if(sel==7){
				System.out.println("�����մϴ�.");
				break;
			}
			switch(sel){
				case 1:
					System.out.println("1.ȸ������");
					System.out.print("������ id �Է� : ");
					id=input.nextInt();
					if(tree.add(id))
						System.out.println("����\n");
					else
						System.out.println("����\n");
					break;
				case 2:
					System.out.println("2.����Ʈ��ȸ");
					System.out.print("id �Է� : ");
					id=input.nextInt();
					if(tree.get(id)==-1)
						System.out.println("����\n");
					else
						System.out.println("����Ʈ : "+tree.get(id)+"\n");
					break;
				case 3:
					System.out.println("3.����Ʈ����");
					System.out.print("id �Է� : ");
					id=input.nextInt();
					System.out.print("������ ����Ʈ : ");
					int point=input.nextInt();
					if(tree.set(id,point))
						System.out.println("����\n");
					else
						System.out.println("����\n");
					break;
				case 4:
					System.out.println("4.��ü��ȸ");
					tree.print();
					break;
				case 5:
					System.out.println("5.ȸ������ȸ");
					System.out.println(tree.size()+"\n");
					break;
				case 6:
					System.out.println("6.ȸ��Ż��");
					System.out.println("�������� ����\n");
					break;
			}
		}
	}
}
	