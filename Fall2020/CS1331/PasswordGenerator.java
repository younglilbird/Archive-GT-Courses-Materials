import java.util.Scanner;
public class PasswordGenerator{
	public static void main(String[] args){
		String password;
		Scanner myScanner = new Scanner(System.in);
        System.out.println("Enter a phrase that will be converted to a password");
        password = myScanner.nextLine();
        password = password.toUpperCase();
        password = password.replace('A', '@');
        password = password.replace('E', '#');
        password = password.replace('I', '!');
        password = password.replace('O', '0');
        password = password.replace('U', '&');
        if (password.length() >= 2 && password.length() <= 5) {
        	password = password + password.substring(0, password.length()-1);
        	System.out.println("Your password could be guessed so the length was adjusted! Your new password is " + password + ".");
        } else if (password.length() >= 6) {
        	System.out.println("Your password is the perfect length! Your password is " + password + ".");
        } else if (password.length() <= 1) {
        	System.out.println("This password will not work. You should try again!");
        }
	}
}