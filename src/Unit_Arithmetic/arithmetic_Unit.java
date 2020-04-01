package Unit_Arithmetic;

import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.lang.Math;

public class arithmetic_Unit {
	public static void main(String[] args) throws IOException{
		System.out.println("程序功能参数如下：\n"+"Myapp.exe -n:生成n个题目\n"+"Myapp.exe -r:控制题目中数值的范围\n");
		Scanner s= new Scanner(System.in);
		System.out.println("请输入题目数目：Myapp.exe -");
		int num=s.nextInt();
		System.out.println("请输入题目数值范围：Myapp.exe -");
		int limits=s.nextInt();
		int r=0;  //正确个数
	    int w=0;  //错误个数
	    String []input=new String[num];  //储存输入的答案
	    int []rLocation=new int[num];  //正确题号数组
	    int []wLocation=new int[num];  //错误题号数组
	    String maths=null;  //数学表达式
	    String[] result=new String[num];
	    File m=new File("Exersies.txt");  //创建练习文件
	    File n=new File("Answer.txt");  //创建答案文件
	    for(int i=0;i<num;i++){
	    	String k=String.valueOf(i+1);  ///将题目和答案序号变成字符串
	        int operator= (int) (Math.random()*4);;//运算符,0、1、2、3分别表示加减乘除
	        int a1= (int) (Math.random()*limits);//第一个数的分子
	        int a2= (int) (Math.random()*limits);//第一个数的分母
	        int b1= (int) (Math.random()*limits);//第二个数的分子
	        int b2= (int) (Math.random()*limits);//第二个数的分母
	        if(a2!=0&&b2!=0) {   //两数分母均不为0时才生成题题目，生成题目同时计算结果
	    		Writer writer1=new FileWriter(m,i==0?false:true);  //重新进入程序则刷新题目文件
	        if(operator==0) {   //运算符符为加时
	            int numerator=a1*b2+a2*b1; //运算结果分子
	            int denominator=a2*b2;  //运算结果分母
	            result[i]=k+':'+calculation(numerator, denominator)+'\n';  //对结果进行约分
	            maths=k+':'+(String)expression(a1,a2)+'+'+(String)expression(b1,b2)+'='+'\n';
	            char[]data1=maths.toCharArray();
	            writer1.write(data1,0,data1.length);
	            writer1.flush();
	            System.out.println(maths);  //打印表达式
	        }
	        else if(operator==1&&a1*b2-a2*b1>=0) {  //运算符为减时，且e1>=e2
	            int numerator=a1*b2-a2*b1;  
	            int denominator=a2*b2;
	            result[i]=k+':'+calculation(numerator, denominator)+'\n';
	            maths=k+':'+(String)expression(a1,a2)+'-'+(String)expression(b1,b2)+'='+'\n';
	            char[]data1=maths.toCharArray();
	            writer1.write(data1,0,data1.length);
	            writer1.flush();
	            System.out.println(maths);      
	        } 
	        else if(operator==2) {  //运算符为乘时
	            int numerator=a1*b1;
	            int denominator=a2*b2;  
	            result[i]=k+':'+calculation(numerator, denominator)+'\n';
	            maths=k+':'+(String)expression(a1,a2)+'×'+(String)expression(b1,b2)+'='+'\n';
	            char[]data1=maths.toCharArray();
	            writer1.write(data1,0,data1.length);
	            writer1.flush();
	            System.out.println(maths);	            
	        }
	        else if(operator==3&&b1!=0) {  //运算符为除时
	            int numerator=a1*b2;
	            int denominator=a2*b1;
	            result[i]=k+':'+calculation(numerator, denominator)+'\n';
	            maths=k+':'+(String)expression(a1,a2)+'÷'+(String)expression(b1,b2)+'='+'\n';
	            char[]data1=maths.toCharArray();
	            writer1.write(data1,0,data1.length);
	            writer1.flush();
	            System.out.println(maths);        
	        }
	        else {  //因其他原因不能生成的如除数等于0，则让i-1以满足生成题目数目
	        	i--;	            
	        }
	        if(i>=0) {  //防止数组越界
	        if(result[i]!=null) {  //此次运行有生成题目则将答案输出到答案文档里
	        	Writer writer2=new FileWriter(n,i==0?false:true);  //第一次进入则刷新答案文档
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
	    File g=new File("Grade.txt");  //创建作答成绩文件
	    Writer writer3=new FileWriter(g);
	    System.out.println("请输入你的答案：\n");
	    for(int j=0;j<num;j++) {
	    	String p=String.valueOf(j+1);  ///将学生作答序号变成字符串
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
            if(i<r-1)  //防止最后一个序号后面跟着逗号
               writer3.write(rLocation[i]+",");
            else writer3.write(rLocation[i]+"");
	    }
	    writer3.append(")\n");
	    writer3.write(sBegin2);
	    for(int j=0;j<w;j++) {
	    	if(j<w-1)   //防止最后一个序号后面跟着逗号
	           writer3.write(wLocation[j]+",");
	    	else writer3.write(wLocation[j]+"");
	    }
	    writer3.append(")\n");
        writer3.flush();
        writer3.close();
        System.out.println("---您已作答完毕，答题成绩详见Grade.txt文档---");
	}
	
	public static String calculation(int a1,int a2) {  //对运算的结果进行约分
	    int common = 1;  //该变量为最大公约数，赋初值为1
	    for (int i=a1; i>=1;i--) {
	        if (a1%i==0&&a2%i==0) {
	            common=i;
	            break;
	        }
	    }
	    int numerator=a1/common;// 约分后的分子
	    int denominator=a2/common;// 约分后的分母
	    if (numerator==0) {
	        return "0";
	    }
	    if(denominator==1) 
	    return numerator+"";
	    else  
	    return expression(numerator,denominator);   //将结果变成真分数后返回
	}
	public static String expression(int a1,int a2) {   //判断分数是否为真分数，若不是则转化
	    if(a1>=a2) {  //若不是真分数
	        int b=a1/a2;
	        int c=a1%a2;
	        {if(c==0) {return b+"";}
	        return b+"'"+c+"/"+a2;}
	    }
	    return a1+"/"+a2;  
	}   

}
