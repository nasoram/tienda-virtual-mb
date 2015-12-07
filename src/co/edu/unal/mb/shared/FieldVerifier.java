package co.edu.unal.mb.shared;

public class FieldVerifier {
	
	//Solo letras, 6 - 15 caracteres
	public static boolean isValidName(String name) {
		return (!name.matches("^[A-Z]{6,15}$")) ? false : true;
	}
	
	//Letras y numeros, 6 - 15 caracteres
	public static boolean isValidUsername(String username) {
		return (!username.matches("^[0-9A-Z]{6,15}$")) ? false : true;
	}
	
	//Letras y numeros, 4 - 15 caracteres
	public static boolean isValidPassword(String password) {
		return (!password.matches("^[0-9A-Z]{4,15}$")) ? false : true;
	}
	
	//Solo numeros, 7 - 15 caracteres
	public static boolean isValidId(String id) {
		return (!id.matches("^[0-9]{7,15}$")) ? false : true;
	}
	
	//Solo numeros, 4 - 6 caracteres
	public static boolean isValidOrderId(String orderid) {
		return (!orderid.matches("^[0-9]{4,6}$")) ? false : true;
	}
	
	//Solo numeros, 5 - 10 caracteres
	public static boolean isValidPrice(String price) {
		return (!price.matches("^[0-9]{5,10}$")) ? false : true;
	}
	
	public static boolean passwordsMatch(String password1, String password2){
		return (isValidPassword(password1) && isValidPassword(password2) && password1==password2);
	}
	
	public static boolean isValidEmail(String email) {
		return email.contains("@") && email.contains(".");
	}
	
}
