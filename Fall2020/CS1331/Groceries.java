public class Groceries {
	public static void main(String[]args){
		String name = "Brad";
		int cash = 50;
        double taxRate = 0.1;
        double subtotal = 42.3;
        double change = cash - ((1 + taxRate) * subtotal);
        System.out.printf(name + " has $%3.2f dollars remaining!\nBrad started with $" + cash + " dollars!", change);
	}
}