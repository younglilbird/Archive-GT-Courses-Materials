import java.util.Random;
public class RandomPrinter{
	public static void main(String[] args){
		Random rand4 = new Random();
		randomController(rand4);
	}
	public static void powersOfTwo(){
		System.out.println("Running the powersOfTwo method");
		int i = 1;
		int num = 0;
		while (i < 100) {
			System.out.println("    2 raised to the " + num + " is " + i);
			i = i * 2;
			num++;
		}
	}
	public static int parameterPrinter(int parameter){
		System.out.println("Running the parameterPrinter method");
		System.out.println("    Method took the parameter " + parameter);
		return parameter;
	}
	public static void randomNumber(){
		System.out.println("Running the randomNumber method");
		int result = (int)(Math.random() * 10 + 1);
		System.out.println("    Your random number is " + result);
	}
	public static void randomController(Random rand){
		System.out.println("Starting to call the methods!");
		int r1 = rand.nextInt(5) + 1;
		for (int i = 0; i < r1; i++){
			powersOfTwo();
		}
		int r2 = rand.nextInt(4) + 6;
		for (int i = 0; i < r2; i++){
			parameterPrinter(r2);
		}
		int r3 = rand.nextInt(9) + 1;
		for (int i = 0; i < r3; i++){
			randomNumber();
		}
	}
}