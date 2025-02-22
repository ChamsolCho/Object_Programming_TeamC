package com.refrigerator;
import java.util.ArrayList;
import java.util.Scanner;

import mgr.Manageable;

public class Recipe implements Manageable{
	Scanner tmpscan = new Scanner(System.in);
	
	String name;
	String cookName;
	
	ArrayList<String> recstr = new ArrayList<>();
	ArrayList<RecFd> recList = new ArrayList<>();
	ArrayList<String> userinfo = new ArrayList<>();
	

	
	@Override
	public void print() {
		// 요리할 음식과 필요한 식재료 출력
		System.out.printf("\n=== %s === / 작성자 : %s\n", name,cookName);
		for(String str : userinfo) {
			System.out.print("#"+str+" ");
		}
		System.out.printf("\n<< 재료 >>\n");
		for (RecFd r : recList) {
			r.print();
		}
		System.out.printf("<< 레시피 >>");
		for(String str : recstr) {
			System.out.println(str);
		}
	}

	@Override
	public void read(Scanner scan) {
		String s = null;
		RecFd rfd = null;
		name = scan.next();
		cookName = scan.next();
		while(true) {
			s = scan.next();
			if(s.contentEquals("end"))
				break;
			rfd = new RecFd(s);
			rfd.read(scan);
			recList.add(rfd);
		}
		while(true) {
			s = scan.nextLine();
			if(s.contentEquals("end"))
				break;
			recstr.add(s);
		}
		while(true) {
			s = scan.next();
			if(s.contentEquals("end"))
				break;
			userinfo.add(s);
		}

	}


	public boolean usermatch(String kwd) {
		for(String str : userinfo) {
			if(str.contains(kwd)) {
				return true;
			}
		}
		return false;
	}
	
	@Override
	public boolean matches(String kwd) {
		if(kwd.contentEquals(name)) {
			return true;
		}
		if(kwd.contentEquals(cookName)) {
			return true;
		}
		for(RecFd r : recList) {
			if(kwd.contentEquals(r.type)) 
				return true;
		}
		return false;
	}


}