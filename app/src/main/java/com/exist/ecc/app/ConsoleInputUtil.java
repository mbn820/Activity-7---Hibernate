package com.exist.ecc.app;

import java.util.Scanner;
import java.util.Set;
import java.util.Arrays;

public class ConsoleInputUtil {
	private static Scanner scan = new Scanner(System.in);
	public static final String DEFAULT_ERROR_MESSAGE = "ERROR: Invalid Input";
	public static final String DEFAULT_MESSAGE = "";

	public static String getAll(String message) {
		System.out.print(message);
		String input = scan.nextLine();
		return input;
	}

	public static String getAnyString(String message) {
		String input;
		do {
			input = getAll(message);
		} while ( input.isEmpty() );

		return input;
	}

	public static String getAnyStringExcept(String message, Set<String> undesiredInputs, String errorMessage) {
		String correctInput;
		do {
			correctInput = getAnyString(message);
			if(undesiredInputs.contains(correctInput)) {
				System.out.println(errorMessage);
			}
		} while (undesiredInputs.contains(correctInput));

		return correctInput;
	}

	public static String getDesiredPattern(String message, String pattern, String errorMsg) {
		String correctInput;
		do {
			correctInput = getAnyString(message);
			if(!correctInput.matches(pattern)) {
				System.out.println(errorMsg);
			}
		} while (!correctInput.matches(pattern));
		return correctInput;
	}

	public static String getDesiredString(String message, String...desiredInputs) {
		String correctInput;

		do {
			correctInput = getAnyString(message);
			if(!isDesired(correctInput, desiredInputs)) {
				System.out.print(DEFAULT_ERROR_MESSAGE + "/Valid: ");
				System.out.println(Arrays.toString(desiredInputs));
			}
		} while (!isDesired(correctInput, desiredInputs));

		return correctInput;
	}

	public static String getFixedStringLength(String message, int desiredStringLength) {
		String correctInput;
		do {
			correctInput = getAnyString(message);
			if(correctInput.length() != desiredStringLength)
			System.out.println("ERROR: String length should be " + desiredStringLength);
		} while (correctInput.length() != desiredStringLength);

		return correctInput;
	}


	public static int getAnyInteger(String message) {
		String input;

		do {
			input = getAnyString(message);
			if(!isInteger(input)) System.err.println(DEFAULT_ERROR_MESSAGE);
		} while (!isInteger(input));

		int correctInput = Integer.parseInt(input);
		return correctInput;
	}

	//desired minimum and maximum input
	public static int getIntegerBetween(String message, int desiredMin, int desiredMax, String errorMessage) {
		int input;

		do {
			input = getAnyInteger(message);
			if(input < desiredMin || input > desiredMax)
				System.err.println(errorMessage);
		} while (input < desiredMin || input > desiredMax);

		return input;
	}

	public static int getIntegerBetween(String message, int desiredMin, int desiredMax) {
		String errorMessage = "Invalid input";
		return getIntegerBetween(message, desiredMin, desiredMax, errorMessage);
	}

	public static double getAnyDouble(String message) {
		String input;

		do {
			input = getAnyString(message);
			if(!isDouble(input)) { System.out.println(DEFAULT_ERROR_MESSAGE); }
		} while(!isDouble(input));

		return Double.parseDouble(input);
	}

	public static double getDoubleBetween(String message, double desiredMin, double desiredMax, String errorMessage) {
		double input;

		do {
			input = getAnyDouble(message);
			if(input < desiredMin || input > desiredMax) { System.err.println(errorMessage); }
		} while (input < desiredMin || input > desiredMax);

		return input;
	}

	public static double getDoubleBetween(String message, double desiredMin, double desiredMax) {
		String errorMessage = "Invalid input";
		return getDoubleBetween(message, desiredMin, desiredMax, errorMessage);
	}

	private static boolean isInteger(String str) {
		try {
			Integer.parseInt(str);
		} catch(Exception e) {
			return false;
		}

		return true;
	}

	private static boolean isDouble(String str) {
		try {
			Double.parseDouble(str);
		} catch(Exception e) {
			return false;
		}

		return true;
	}

	private static boolean isDesired(String str, String...desiredValues) {
		for(String elem : desiredValues) {
			if (str.equalsIgnoreCase(elem)) return true;
		}
		return false;
	}




}//endClass
