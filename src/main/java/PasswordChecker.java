import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasswordChecker {
    private static final String PATTER = "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20})";

    public static void main(String[] args) throws Exception {

        String userPassword = "";
        Scanner kb = new Scanner(System.in);

        try {

            System.out.println("Please enter your password:");
            userPassword = kb.nextLine();

            System.out.println("Password : " + userPassword);
            System.out.println(passwordIsOK(userPassword));

        } catch (PasswordException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static boolean passwordIsValid(String password) throws PasswordException {

        if (password.isEmpty() || password.length() < 8) {
            throw new PasswordException("Oops! your password is too short , " + "" +
                    "password should be longer than 8 characters.");
        }
        Pattern pattern = Pattern.compile(PATTER);
        Matcher match = pattern.matcher(password);

        if (match.matches()) {
            return match.matches();
        }
        if (!password.matches(".*\\d.*")) {
            throw new PasswordException("Password should have at least one digit.");
        }
        if (!password.matches(".*[A-Z].*")) {
            throw new PasswordException("Password should have at least one uppercase.");
        }
        if (!password.matches(".*[a-z].*")) {
            throw new PasswordException("Password should have at least one lowercase.");
        }
        if (!password.matches(".*[!@#$%^&*+=?-].*")) {
            throw new PasswordException("Password should have at least one special character.");
        }
        return false;
    }




    public static boolean passwordIsOK(String password) throws PasswordException {

        if(passwordIsValid(password)) {
            return true;
        }
        else {
            return false;
        }
    }

    public static class PasswordException extends Exception {
        public PasswordException(String message){
            super("Invalid Password : " + message);
        }
    }
}
