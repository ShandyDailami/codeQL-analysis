import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.util.Scanner;

public class java_10435_CredentialValidator_A08 {
    private static String correctUsername = "admin";
    private static String correctPassword = "password";

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        System.out.println("Enter username:");
        String username = reader.readLine();

        System.out.println("Enter password:");
        String password = reader.readLine();

        if (validate(username, password)) {
            writer.write("Access granted!");
        } else {
            writer.write("Access denied!");
        }

        writer.flush();
    }

    public static boolean validate(String username, String password) {
        if (username.equals(correctUsername) && password.equals(correctPassword)) {
            return true;
        } else {
            return false;
        }
    }
}