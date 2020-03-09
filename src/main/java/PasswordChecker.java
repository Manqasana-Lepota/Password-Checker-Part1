import java.util.Scanner;

public class PasswordChecker {

    public static void main(String[] args) throws Exception {
        String user_password ="";
        Scanner kb = new Scanner(System.in);
        try {

            System.out.println("Please enter your password:");
            user_password = kb.nextLine();

            System.out.println("Password : " + user_password);
            System.out.println(passwordIsOK(user_password));

        }
        catch (PasswordException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static boolean passwordIsValid(String password) throws PasswordException {
        if(password.length() < 8) {
            throw new PasswordException("Oops! your password is too short , " + " " +
                    "password should be longer than 8 characters.");
        }

        String SpecialCharacters = "[!@#$%&*()_+=|<>?{}\\\\[\\\\]~-]";
        boolean digit = false;
        boolean uppercase = false;
        boolean lowercase = false;
        boolean specialchars = false;

        for(char currentChar : password.toCharArray()) {
            if (Character.isDigit(currentChar)) {
                digit = true;
            }
            else if (Character.isUpperCase(currentChar)) {
                uppercase = true;
            }
            else if (Character.isLowerCase(currentChar)) {
                lowercase = true;
            }
            else if (SpecialCharacters.contains(String.valueOf(currentChar))) {
                specialchars = true;

            }
        }

        if (!digit) {
            throw new PasswordException("Password should have at least one digit.");
        }
        if (!uppercase) {
            throw new PasswordException("Password should have at least one uppercase.");
        }
        if (!lowercase) {
            throw new PasswordException("Password should have at least one lowercase.");
        }
        if (!specialchars) {
            throw new PasswordException("Password should have at least one special character.");
        }
        return digit && uppercase && lowercase && specialchars;

    }

    public static String passwordIsOK(String password) throws PasswordException {
        if(passwordIsValid(password)) {
            return "Password is valid";
        }
        else {
            return "Password is not valid";
        }
    }

    public static class PasswordException extends Exception {
        public PasswordException(String message){
            super("Invalid Password : " + message);
        }
    }
}
