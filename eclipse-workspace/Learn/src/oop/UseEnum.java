package oop;

public class UseEnum {
	public static void main(String[] args) {
		System.out.println(FirstEnum.news);
		
		//loop thru enums
		for(FirstEnum item: FirstEnum.values()) {
			System.out.println(item);
		}
	}

}
