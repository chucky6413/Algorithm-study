/*
 * �ִ� ���� �κ� ����
 * ��� ȣ��� ���� ���α׷��� �� ®�µ�..
 * ��� ���� ó���� ���..
 * ���� : algospot �� �Է� �߰��� ���� ����ϸ� Ʋ��.. �������� �ѹ��� ���� �������� success..
 */
import java.io.*;

public class Lis {
	
	static int arr[];
	static int max[];
	static int size;
	static int result[];
	
	public static void main(String arg[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int C = Integer.parseInt(br.readLine());
		result = new int[C];
		for(int c=0;c<C;c++){
			size = Integer.parseInt(br.readLine());
			arr = new int[size];
			max = new int[size];
			String[] temp = br.readLine().split(" ");
			for(int i=0;i<size;i++){
				arr[i] = Integer.parseInt(temp[i]);
			}
			for(int i=0;i<size;i++){
				int value = lis(i);
				if(value>result[c])
					result[c] = value;
			}
		}
		for(int print:result){
			System.out.println(print);
		}
	}
	static int lis(int index){
		if(max[index]>0)
			return max[index];
		
		int maxValue = 1;
		int temp = 0;
		
		for(int i=index;i<arr.length;i++){
			if(arr[i]>arr[index]){
				temp=lis(i)+1;
				if(temp>maxValue)
					maxValue=temp;
			}
		}
		
		max[index] = maxValue;
		
		return max[index];
	}
}
