package com.exist.ecc.app;

public class FindPersonForm {
	public static void show() {
		displayOptions();
		
		int choice = ConsoleInputUtil.getIntegerBetween("Enter choice: ", 1, 2);

		switch(choice) {
			case 1 : findPerson(); break;
			case 2 : viewAllPerson(); break;
		}
	}

	public static void displayOptions() {
		System.out.println("[1] Find Person");
		System.out.println("[2] View All Person");
	}

	public static void findPerson() {
		int targetPersonId = ConsoleInputUtil.getAnyInteger("Enter person id: ");
		System.out.println("Found person with id: " + targetPersonId);
	}

	public static void  viewAllPerson(){
		System.out.println("ORDER BY: ");
		System.out.println("[1] Last Name");
		System.out.println("[2] GWA");
		System.out.println("[3] Date Hired");
		int choice = ConsoleInputUtil.getIntegerBetween("Enter choice: ", 1, 3);

		switch(choice) {
			case 1 : System.out.println("ORDER BY LAST NAME"); break;
			case 2 : System.out.println("ORDER BY GWA"); break;
			case 3 : System.out.println("ORDER BY DATE HIRED"); break;
		}
	}
}