package Unit_Arithmetic;

import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.lang.Math;

public class arithmetic_Unit {
	public static void main(String[] args) throws IOException{
		System.out.println("�����ܲ������£�\n"+"Myapp.exe -n:����n����Ŀ\n"+"Myapp.exe -r:������Ŀ����ֵ�ķ�Χ\n");
		Scanner s= new Scanner(System.in);
		System.out.println("��������Ŀ��Ŀ��Myapp.exe -");
		int num=s.nextInt();
		System.out.println("��������Ŀ��ֵ��Χ��Myapp.exe -");
		int limits=s.nextInt();
		int r=0;  //��ȷ����
	    int w=0;  //�������
	    String []input=new String[num];  //��������Ĵ�
	    int []rLocation=new int[num];  //��ȷ�������
	    int []wLocation=new int[num];  //�����������
	    String maths=null;  //��ѧ���ʽ
	    String[] result=new String[num];
	    File m=new File("Exersies.txt");  //������ϰ�ļ�
	    File n=new File("Answer.txt");  //�������ļ�
	    for(int i=0;i<num;i++){
	    	String k=String.valueOf(i+1);  ///����Ŀ�ʹ���ű���ַ���
	        int operator= (int) (Math.random()*4);;//�����,0��1��2��3�ֱ��ʾ�Ӽ��˳�
	        int a1= (int) (Math.random()*limits);//��һ�����ķ���
	        int a2= (int) (Math.random()*limits);//��һ�����ķ�ĸ
	        int b1= (int) (Math.random()*limits);//�ڶ������ķ���
	        int b2= (int) (Math.random()*limits);//�ڶ������ķ�ĸ
	        if(a2!=0&&b2!=0) {   //������ĸ����Ϊ0ʱ����������Ŀ��������Ŀͬʱ������
	    		Writer writer1=new FileWriter(m,i==0?false:true);  //���½��������ˢ����Ŀ�ļ�
	        if(operator==0) {   //�������Ϊ��ʱ
	            int numerator=a1*b2+a2*b1; //����������
	            int denominator=a2*b2;  //��������ĸ
	            result[i]=k+':'+calculation(numerator, denominator)+'\n';  //�Խ������Լ��
	            maths=k+':'+(String)expression(a1,a2)+'+'+(String)expression(b1,b2)+'='+'\n';
	            char[]data1=maths.toCharArray();
	            writer1.write(data1,0,data1.length);
	            writer1.flush();
	            System.out.println(maths);  //��ӡ���ʽ
	        }
	        else if(operator==1&&a1*b2-a2*b1>=0) {  //�����Ϊ��ʱ����e1>=e2
	            int numerator=a1*b2-a2*b1;  
	            int denominator=a2*b2;
	            result[i]=k+':'+calculation(numerator, denominator)+'\n';
	            maths=k+':'+(String)expression(a1,a2)+'-'+(String)expression(b1,b2)+'='+'\n';
	            char[]data1=maths.toCharArray();
	            writer1.write(data1,0,data1.length);
	            writer1.flush();
	            System.out.println(maths);      
	        } 
	        else if(operator==2) {  //�����Ϊ��ʱ
	            int numerator=a1*b1;
	            int denominator=a2*b2;  
	            result[i]=k+':'+calculation(numerator, denominator)+'\n';
	            maths=k+':'+(String)expression(a1,a2)+'��'+(String)expression(b1,b2)+'='+'\n';
	            char[]data1=maths.toCharArray();
	            writer1.write(data1,0,data1.length);
	            writer1.flush();
	            System.out.println(maths);	            
	        }
	        else if(operator==3&&b1!=0) {  //�����Ϊ��ʱ
	            int numerator=a1*b2;
	            int denominator=a2*b1;
	            result[i]=k+':'+calculation(numerator, denominator)+'\n';
	            maths=k+':'+(String)expression(a1,a2)+'��'+(String)expression(b1,b2)+'='+'\n';
	            char[]data1=maths.toCharArray();
	            writer1.write(data1,0,data1.length);
	            writer1.flush();
	            System.out.println(maths);        
	        }
	        else {  //������ԭ�������ɵ����������0������i-1������������Ŀ��Ŀ
	        	i--;	            
	        }
	        if(i>=0) {  //��ֹ����Խ��
	        if(result[i]!=null) {  //�˴�������������Ŀ�򽫴���������ĵ���
	        	Writer writer2=new FileWriter(n,i==0?false:true);  //��һ�ν�����ˢ�´��ĵ�
	        	char[]data2=result[i].toCharArray();
	            writer2.write(data2,0,data2.length);
	            writer2.flush();
	            writer2.close();
	        }
	       }
	        writer1.close();
	      }   
	     else {
	    	 i--;
	        }
	     }
	    File g=new File("Grade.txt");  //��������ɼ��ļ�
	    Writer writer3=new FileWriter(g);
	    System.out.println("��������Ĵ𰸣�\n");
	    for(int j=0;j<num;j++) {
	    	String p=String.valueOf(j+1);  ///��ѧ��������ű���ַ���
	    	input[j]=p+':'+s.next()+'\n';
	    	if(input[j].equals(result[j])) {
	    		rLocation[r++]=j+1;	
	    	}
	    	else {
	    		wLocation[w++]=j+1;
	    	}
	    }
	    s.close();
	    String r1=String.valueOf(r);
	    String w1=String.valueOf(w);
	    String sBegin1="Correct:"+r1+"(";
	    String sBegin2="Wrong:"+w1+"(";
	    writer3.write(sBegin1);
	    for(int i=0;i<r;i++) {
            if(i<r-1)  //��ֹ���һ����ź�����Ŷ���
               writer3.write(rLocation[i]+",");
            else writer3.write(rLocation[i]+"");
	    }
	    writer3.append(")\n");
	    writer3.write(sBegin2);
	    for(int j=0;j<w;j++) {
	    	if(j<w-1)   //��ֹ���һ����ź�����Ŷ���
	           writer3.write(wLocation[j]+",");
	    	else writer3.write(wLocation[j]+"");
	    }
	    writer3.append(")\n");
        writer3.flush();
        writer3.close();
        System.out.println("---����������ϣ�����ɼ����Grade.txt�ĵ�---");
	}
	
	public static String calculation(int a1,int a2) {  //������Ľ������Լ��
	    int common = 1;  //�ñ���Ϊ���Լ��������ֵΪ1
	    for (int i=a1; i>=1;i--) {
	        if (a1%i==0&&a2%i==0) {
	            common=i;
	            break;
	        }
	    }
	    int numerator=a1/common;// Լ�ֺ�ķ���
	    int denominator=a2/common;// Լ�ֺ�ķ�ĸ
	    if (numerator==0) {
	        return "0";
	    }
	    if(denominator==1) 
	    return numerator+"";
	    else  
	    return expression(numerator,denominator);   //��������������󷵻�
	}
	public static String expression(int a1,int a2) {   //�жϷ����Ƿ�Ϊ���������������ת��
	    if(a1>=a2) {  //�����������
	        int b=a1/a2;
	        int c=a1%a2;
	        {if(c==0) {return b+"";}
	        return b+"'"+c+"/"+a2;}
	    }
	    return a1+"/"+a2;  
	}   

}
