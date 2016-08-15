import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.Random;

public class NTS {
	public static void main(String arg[]) throws IOException{
		
		HashMap<String,Integer> nts_hashTable = new HashMap<String,Integer>();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int count;
		Random random = new Random();
		
		System.out.print("java RecordMaker [count]\n");
		st=new StringTokenizer(in.readLine());
		st.nextToken();st.nextToken(); //java RecordMaker ������
		count=Integer.parseInt(st.nextToken()); //�Է� ���� count ������ ����
		
		String e_Num,e="";
		int r,score;
		
		for(int i=0;i<count;){ //���� ���ǽ��� ���� �ݺ����Դϴ�. �Ʒ��� �ߺ����� ���� �� ���Խ� �������� ����˴ϴ�.
			r=random.nextInt(99999)+1;
			e=Integer.toString(r);
			if(r<10000){ //5�ڸ� ������ ������ ��� 0���� ä��ϴ�.
				r=e.length();
				switch(r){
				case 1:
					e="0000"+e;
					break;
				case 2:
					e="000"+e;
					break;
				case 3:
					e="00"+e;
					break;
				case 4:
					e="0"+e;
					break;
				}
			}
			
			e_Num="NT"+e;
			if(!nts_hashTable.containsKey(e_Num)){ //�ߺ��� ���� ���ٸ� �ؽ����̺� �����մϴ�.
				score=random.nextInt(100);
				nts_hashTable.put(e_Num,score);
				sb.append(e_Num+" "+score+"\n");
				i++; //�ش� ������ ��츸 i++
			}
		}
		System.out.println(sb.toString().substring(0,sb.length())); //��½ð��� ���̱� ���� ���� �� �ѹ��� ����մϴ�.
	}
}
