/*
 * �˰� �� ��. ���� ��ȹ �˰������� ������ Ǯ �� ..
 * 1. ���� Ž��
 * 2. �ֺ��� �κ� ������ �� ���� ����ϵ��� �޸������̼��� ���� ..
 * 
 * but visited �迭�� .. boolean ���� true,false �θ� ó���� �� ���� ,,
 * int ������ �Ͽ� �湮���� ���� ���, false �� ���, true �� ��� 3������ ������
 * ó�� �Ҷ��� �ӵ��� �� ������ ������ �ذ� �� �� �־���.
 *
 * @author chucky3
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Jumpgame {
	static int arr[][];
	static int visited[][];
	static final int YES = 2;
	static final int NO = 1;
	static final int NOT_VISITED = 0;
	static int size;
	static boolean answer;
	
	public static void main(String arg[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int c = Integer.parseInt(br.readLine());
		
		while(c-- > 0){
			size = Integer.parseInt(br.readLine());
			arr = new int[size][size];
			visited = new int[size][size];
			for(int i=0;i<size;i++){
				String tmp[] = br.readLine().split(" ");
				for(int j=0;j<size;j++){
					arr[i][j] = Integer.parseInt(tmp[j]);
				}
			}
			answer = jump(0,0);
			if(answer)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}
	static boolean jump(int x,int y){
		if(x>=size || y>=size)
			return false;
		if(x==size-1 && y==size-1)
			return true;
		if(visited[x][y] != NOT_VISITED)
			return visited[x][y]==YES;
	
		visited[x][y] = jump(x+arr[x][y],y) || jump(x,y+arr[x][y]) ? YES:NO;
		
		return visited[x][y]==YES;
	}
}
