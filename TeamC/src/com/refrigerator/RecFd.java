package com.refrigerator;
import java.util.Scanner;

import mgr.Manageable;

public class RecFd implements Manageable{
	public String type;
	public int num;
	
	public RecFd(String str){
		type = str;
	}
	
	public void print() {
		System.out.println(type + " " + num);
	}


	@Override
	public void read(Scanner scan) {
		num = scan.nextInt();
	}


	@Override
	public boolean matches(String kwd) {
		return false;
	}
}
