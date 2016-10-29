/*
 * ��ó : http://timpani.tistory.com/entry/%EC%BF%BC%EB%93%9C-%ED%8A%B8%EB%A6%AC-%EB%92%A4%EC%A7%91%EA%B8%B0-QUADTREE
 * �� ���� ���ϴ�.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
public class Quadtree{  
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int T = Integer.parseInt(br.readLine());
        while( T-- > 0 ){
            String quadTree = new String(br.readLine());
             
            System.out.println(reverse(quadTree));
        } 
    }
     
    public static String reverse(String quadTree){
        if( quadTree.charAt(0) != 'x' )
            return quadTree.charAt(0) + "";
         
        // reverseQuadTree
        String rqt[] = new String[4];
         
        // ���� �� ����
        int beginIndex = 1;
        rqt[0] = reverse(quadTree.substring(beginIndex));
         
        // ������ �� ����
        beginIndex += rqt[0].length();
        rqt[1] = reverse(quadTree.substring(beginIndex));
         
        // ���� �Ʒ� ����
        beginIndex += rqt[1].length();
        rqt[2] = reverse(quadTree.substring(beginIndex));
         
        // ������ �Ʒ� ����
        beginIndex += rqt[2].length();
        rqt[3] = reverse(quadTree.substring(beginIndex));
         
        return 'x' + rqt[2] + rqt[3] + rqt[0] + rqt[1];
    }
}