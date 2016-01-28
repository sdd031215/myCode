package com.ledu.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main3 {

	private List<StudentScore> listss = new ArrayList<StudentScore>();
	
	public Main3(List<StudentScore> list) {
		this.listss = list;
	}
	
	public String[] panduan(){
		if(listss.size()<=0)
			return new String[]{"请输入学生成绩"};
		
		String[] str = new String[listss.size()];
		int i = 0;
		Iterator it = listss.iterator();
		while(it.hasNext()){
			StudentScore ss = (StudentScore)it.next();
			int countS = ss.getS1()+ss.getS2()+ss.getS3()+ss.getS4();
			if(ss.getS1() < 60 || ss.getS2() < 60 || ss.getS3() < 90 || ss.getS4() < 90 
					|| countS < 310){
				str[i++] = "Fail";
			}else if (countS >= 310 && countS < 350){
				str[i++] = "Zifei";
			}else if(countS >= 350){
				str[i++] = "Gongfei";
			}
		}
		return str;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		String counts = sc.nextLine();
		int count = Integer.parseInt(counts);
		List<StudentScore> list = new ArrayList<StudentScore>();
		
		for(int i=0; i<count; i++){
			String temp = sc.nextLine();
			String[] scores = temp.split(" ");
			if(scores.length != 4){
				System.out.println("input error!!!");
				System.exit(0);;
			}
			
			int k = 0;
			int s1 = Integer.parseInt(scores[k++]);
			int s2 = Integer.parseInt(scores[k++]);
			int s3 = Integer.parseInt(scores[k++]);
			int s4 = Integer.parseInt(scores[k++]);
			
			StudentScore ss = new StudentScore(s1,s2,s3,s4);
			
			list.add(ss);
		}
		Main3 ks = new Main3(list);
		
		String[] str = ks.panduan();
		for(String s : str){
			System.out.println(s);
		}
	}

	
} 
class StudentScore{
	private int s1;//zhengzhi
	private int s2;//yingyu
	private int s3;//shuxue
	private int s4;//zhuanyeke
	//private int countS;//zongfen
	
	public StudentScore(){}
	
	public StudentScore(int s1, int s2, int s3, int s4){
		this.s1 = s1;
		this.s2 = s2;
		this.s3 = s3;
		this.s4 = s4;
	}
	
	public int getS1() {
		return s1;
	}
	public void setS1(int s1) {
		this.s1 = s1;
	}
	public int getS2() {
		return s2;
	}
	public void setS2(int s2) {
		this.s2 = s2;
	}
	public int getS3() {
		return s3;
	}
	public void setS3(int s3) {
		this.s3 = s3;
	}
	public int getS4() {
		return s4;
	}
	public void setS4(int s4) {
		this.s4 = s4;
	}
	
}