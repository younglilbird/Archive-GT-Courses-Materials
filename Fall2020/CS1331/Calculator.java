import java.util.Scanner;
public class Calculator {
	public static void main(String[]args){
		String operation;
		int firstNumber;
		int secondNumber;
		int result;
		Scanner takesInput = new Scanner(System.in);
		System.out.println("What operation would you like to perform (Addition, Multiplication, Division, or Subtraction)?");
		operation = takesInput.next();
		operation = operation.toUpperCase();
        System.out.println("Enter your first number:");
		firstNumber = takesInput.nextInt();
		System.out.println("Enter your second number:");
		secondNumber = takesInput.nextInt();
		switch (operation) {
			case "ADDITION":
			    result = firstNumber + secondNumber;
			    System.out.println("We add " + firstNumber + " and " + secondNumber + ". The answer is " + result + ".");
			    break;
			case "MULTIPLICATION":
			    result = firstNumber * secondNumber;
			    System.out.println("Here we multiplied " + firstNumber + " and " + secondNumber + ". The answer is " + result + ".");
			    break;
			case "DIVISION":
			    result = firstNumber / secondNumber;
			    System.out.println("This time we divided " + firstNumber + " and " + secondNumber + ". The answer is " + result + ".");
                break;
            case "SUBTRACTION":
                result = firstNumber - secondNumber;
                System.out.println(firstNumber + " and " + secondNumber + " were subtracted. The answer is " + result + ".");
                break;
            default:
                System.out.println("That is not a valid operation!");
                break;
		}
	}
}