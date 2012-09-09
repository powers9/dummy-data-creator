package org.opensrc.utility.dummydata;


public class Util {

	public static Integer randomInt(int min, int max){
		
		return (int) Math.floor(Math.random()*(max-min)) + min;
	}
	
	public static Long randomLong(Long min, Long max){
		
		return (long) Math.floor(Math.random()*(max-min)) + min;
	}
	public static Integer randomInt(int value){
		
		return (int) Math.floor(Math.random()*value);
	}
	
	public static Long randomLong(Long value){
		
		return (long) Math.floor(Math.random()*value);
	}
}
