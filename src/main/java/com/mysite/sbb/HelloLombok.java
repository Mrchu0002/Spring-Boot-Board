package com.mysite.sbb;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class HelloLombok {
	
	private final String hello;
	private final int lombok;
	
	public static void main(String[] args) {
		HelloLombok hellolombok = new HelloLombok("헬로", 5);

		System.out.println(hellolombok.getHello());
		System.out.println(hellolombok.getLombok());
		
		
	}//end of main
}