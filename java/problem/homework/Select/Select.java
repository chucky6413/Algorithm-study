//***************************
// ���ϸ�: Select.java
// �ۼ���: ���ؿ�
// �ۼ���: 2016/04/06
// ���α׷� ����: selection algorithm �� �̿��Ͽ� i��° ���Ҹ� ã�� ���α׷� �Դϴ�.
//***************************
import java.util.Scanner;
import java.io.*;

public class Select {
	public static void main(String arg[]) throws IOException{
		System.out.println("hw4_1 : ���ؿ�\n");
		
		Scanner fs;
		Scanner input=new Scanner(System.in);
		fs=new Scanner(new File("hw4_1.txt"));
		int n=fs.nextInt();
		int a[]=new int[n];
		
		System.out.println(" ����Ʈ");
		for(int i=0;i<n;i++){
			a[i]=fs.nextInt();
			System.out.printf("%3d ",a[i]);
			if((i+1)%10==0)
				System.out.println();
		}
		System.out.println();
		System.out.print("�� ��°�� ���� ���� ã���ʴϱ�? ");
		int i=input.nextInt();
		int answer=select(a,0,n-1,i);
		System.out.println("�� : "+answer);
	}
	public static int select(int a[],int p,int r,int i){
		if(p==r)
			return a[p];
		int q=partition(a,p,r);
		int k=q-p+1;
		
		if(i<k)
			return select(a,p,q-1,i);
		else if(i==k)
			return a[q];
		else
			return select(a,q+1,r,i-k);
	}
	public static int partition(int a[],int p,int r){
		int x=a[r];
		int i=p-1;
		int temp=0;
		
		for(int j=p;j<r;j++){
			if(a[j]<=x){
				temp=a[++i];
				a[i]=a[j];
				a[j]=temp;
			}
		}
		temp=a[++i];
		a[i]=a[r];
		a[r]=temp;
		
		return i;
	}
}
