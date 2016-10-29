//***************************
 // ���ϸ�: hw5_4.java
 // �ۼ���: ���ؿ�
 // �ۼ���: 2015.10.02
 // ����: ��Ҵ��׽����� ǥ���� ���׽��� ������ �ϴ� ���α׷��Դϴ�.
 //        ���� �迭�� ����� 0�� ����� �������� ������ ��½ÿ� ���ǹ��� �ɾ�
//         ����� ����� 0�ΰ͵鵵 ǥ�����ִ� ���α׷��Դϴ�.
 //***************************

class operatePx{ // ���׽� ���� Ŭ����
	private int degree_A = 0;
	private int degree_B = 0;
	private int degree_C = 0;
	private int index_A = 0;
	private int index_B = 0;
	private int index_C = 0;
	private int expo_A;
	private int expo_B;
	 
	public void Px_To_SpPx(Px C){ //� ���׽��̴� ��Ҵ��׽����� ��������.
		int count=0;
		int j=0;
		double temp[][]=new double[20][2];
		for(int i=0;i<=C.coef.length-1;i++)
		{
			if(C.getCoef(i)!=0.0){
				temp[j][1]=C.getCoef(i);
				temp[j][0]=C.getExpo(i);
				count++;
				j++;
			}	
		}
		double SpPx[][]=new double[count][2];

		for(int i=0;i<count;i++)
		{
			SpPx[i][0]=temp[i][0];
			SpPx[i][1]=temp[i][1];
		}
		C.setPx(SpPx);
		C.setDegree((int)(C.getExpo(0)));
	}
	
	public Px add(Px A,Px B) //� ���׽��̵� ������ ���缭 ������.
	{
		degree_A = A.getDegree();
		degree_B = B.getDegree();
		expo_A = degree_A;
		expo_B = degree_B;
		
		if(degree_A >= degree_B)
			degree_C = degree_A;
		else
			degree_C = degree_B;
		
		Px C = new Px(degree_C);
		
		while(index_A <= degree_A && index_B <= degree_B)
		{
			if(expo_A > expo_B)
			{
				C.setExpo(index_C,expo_A);
				C.setCoef(index_C++,A.getCoef(index_A++));
				expo_A--;
				expo_B--;
			}
			else if(expo_A==expo_B)
			{
				if(A.getExpo(index_A)==B.getExpo(index_B))
				{
					C.setExpo(index_C,expo_A);
					C.setCoef(index_C++,A.getCoef(index_A++)+B.getCoef(index_B++));
					expo_B--;
					expo_A--;
				}
				else if(A.getExpo(index_A)>B.getExpo(index_B))
				{
					C.setExpo(index_C,expo_A);
					C.setCoef(index_C++,A.getCoef(index_A++));
					expo_A--;
					expo_B--;
				}
				else
				{	
					C.setExpo(index_C,expo_B);
					C.setCoef(index_C++,B.getCoef(index_B++));
					expo_B--;
				}	
			}	
			else
			{
				C.setExpo(index_C,expo_B);
				C.setCoef(index_C++,B.getCoef(index_B++));
				expo_B--;				
			}
		}
		return C;
	}

	
	
}

class Px{ //���׽� Ŭ����.
	int degree;
	double coef[][]=new double[20][2];
	
	public Px(int degree,double coef[][]){
		this.degree=degree;
		this.coef=coef;
	}
	public Px(int degree)
	{
		this.degree = degree;
		for(int i=0;i<=degree;i++)
			for(int j=0;j<2;j++)
				coef[i][j]=0;
	}
	public void setPx(double Px[][]){
		coef=Px;
	}
	public int getDegree(){
		return degree;
	}
	public void setDegree(int degree){
		this.degree=degree;
	}
	public double getCoef(int expo){
		if(expo<coef.length)
			return coef[expo][1];
		else
			return 0;
	}
	public double getExpo(int index){
		if(index<coef.length)
			return coef[index][0];
		else
			return -1;
	}
	public void setCoef(int expo,double value){
		this.coef[expo][1]=value;
	}
	public void setExpo(int index,double expo){
		this.coef[index][0]=expo;
	}
	public void spPxPrint(String s){ //���� �迭�� ���� ������ �� �� �ְ� ������ִ� �޼ҵ�
		int j=0;
		System.out.print(s+"=");
		for(int i=0;i<=coef.length-1;i++)
		{	j=0;
			System.out.println("("+coef[i][j++]+","+coef[i][j]+")");
		}
	}
	public void valuePrint(String s){  //�迭�� ����� ����������� ���ǹ��� ���� ����� ���� ������ ���� 0.0���� �������.
		int j=0;
		System.out.print(s+"=");
		
		if(coef.length>degree){ //������ �������� Ŭ ��쿡�� �׳� ����Ѵ�.
		for(int i=0;i<=coef.length-1;i++)
			System.out.print(coef[i][1]+" ");
		}
		else if(coef.length==degree){//0�� ����� ���� �������� ���� ������ ���Ͽ� 0���� ������ֱ� ���� �����.
			j=degree;
			for(int i=degree;i>=0;i--){
				if(i==getExpo(degree-j)){
					System.out.print(coef[degree-j][1]+" ");
					j--;
				}
				else
					System.out.print(0.0+" "); //���� ����� ���������ʴ�..�迭�� �������� �ʴ����� ã�Ƽ� 0���� ������ش�.
			}
			
		}
		
		System.out.println();
	}
}
public class hw5_4 {
	public static void main(String arg[]){
		System.out.println("hw5_4:���ؿ�\n");
		
		double A1[][]={{3,9},{2,3},{1,5}};
		double B1[][]={{4,8},{3,1},{2,-3},{1,2.5},{0,1.8}};
		double A2[][]={{4,3},{3,4},{2,5},{1,6},{0,7}};
		double B2[][]={{4,-3},{3,-4},{2,4},{1,6}};
		double A3[][]={{6,7},{5,-6},{4,5},{3,4},{2,3},{1,1.5},{0,2.5}};
		double B3[][]={{6,6},{5,3},{4,2},{3,1},{1,7},{0,8}};
		
		Px a1=new Px(3,A1);
		Px b1=new Px(4,B1);
		Px a2=new Px(4,A2);
		Px b2=new Px(4,B2);
		Px a3=new Px(6,A3);
		Px b3=new Px(6,B3);
		
		operatePx opsa1=new operatePx();
		operatePx opsa2=new operatePx();
		operatePx opsa3=new operatePx();
		
		Px c1=opsa1.add(a1,b1);
		opsa1.Px_To_SpPx(c1); //���׽��� ��Ҵ��׽����� �������ش�.
		c1.valuePrint("C1");
		//c1.spPxPrint("C1");  //�̹����� ���� �迭�� ������¸� �����ָ� ����� �迭��
		                       //���� ���ҵ��� ���� �ִ� �����Դϴ�. ����� 0�� �迭�� ����� �������� ������
		                       //valuePrint �� ����ҽ� �������������� �ǳʶ� ������ ����� 0.0���� ������ְԲ� �߽��ϴ�.
		Px c2=opsa2.add(a2,b2);
		opsa2.Px_To_SpPx(c2); //���׽��� ��Ҵ��׽����� �������ش�.
		c2.valuePrint("C2");
		//c2.spPxPrint("C2"); 
		
		Px c3=opsa3.add(a3,b3);
		opsa3.Px_To_SpPx(c3); //���׽��� ��Ҵ��׽����� �������ش�.
		c3.valuePrint("C3");
		//c3.spPxPrint("C3"); 
	}
}
