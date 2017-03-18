/*
 * 2017.03.18
 * ����,�����佺�׳׽��� ü
 *
 * @problem https://www.acmicpc.net/problem/2960
 * @github https://github.com/chucky6413
 * @author chucky3
 */
import java.util.*;

public class Main {
	static int lastP; //������ ������ �Ҽ�
	static int n,k,count,next,result;
	static int arr[];
	public static void main(String arg[]){
		Scanner input = new Scanner(System.in);
		n = input.nextInt();
		k = input.nextInt();
		
		arr = new int[n+1];
		
		for(int i=2;i<=n;i++){
			arr[i] = i;
		}
		
		while(count!=(n-1)){ //���� ���� n-1�� �� �� ���� �ݺ�
			primeSearch();
			next = lastP;
			int multi = 2; //��� ���� ��.
			while(next<=n){
				if(arr[next]!=0){ //������ ���� �ֵ�.
					arr[next] = 0;
					count++;
				}
				if(count==k){ //ã���� ��,
					result = next;
					break;
				}
				next = lastP * multi++; //��� ���ϱ�
			}
			if(result!=0){ //�ݺ��� ��.
				break;
			}
		}
		System.out.println(result);
	}
	public static void primeSearch(){
		for(int i=lastP;i<=n;i++){
			if(arr[i]!=0){ //�������� �ʾ��� ����,
				for(int j=i-1;j>=1;j--){
					if(j==1){
						lastP = i;
						return;
					}
					if(i%j==0){ //�Ҽ� �ƴϸ� �ѱ��.
						break;
					}else{ // ���.
						continue;
					}
				}
			}
		}
	}
}