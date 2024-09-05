public class BirthdayCalculator {
	public static void main(String[]args){
		int birthMonth = 1;
		int birthDay = 23;
		int birthYear = 1996;
		int bdayCalculation = birthMonth;
		bdayCalculation += 18;
		bdayCalculation *= 25;
		bdayCalculation -= 333;
		bdayCalculation *= 8;
		bdayCalculation -= 554;
		bdayCalculation /= 2;
		bdayCalculation += birthDay;
		bdayCalculation *= 5;
		bdayCalculation += 692;
		bdayCalculation *= 20;
		bdayCalculation += (birthYear % 100);
		bdayCalculation -= 32940;
		System.out.println("Birthday: " + bdayCalculation);
	}
}