import java.security.SecureRandom;
import java.util.Base64;
import java.util.Scanner;

public class java_42163_XMLParser_A03 {

    private static SecureRandom sr = new SecureRandom();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string to encode or 'exit' to quit:");

        String input = scanner.nextLine();

        while (!input.equals("exit")) {
            try {
                String encoded = encode(input);
                System.out.println("Encoded string: " + encoded);

                System.out.println("Enter a string to decode or 'exit' to quit:");
                input = scanner.nextLine();
            } catch (Exception e) {
                System.out.println("Error while decoding: " + e.getMessage());
            }
        }

        scanner.close();
    }

    public static String encode(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (isUnsafeCharacter(c)) {
                c = replaceUnsafeChar(c);
            }
            sb.append(c);
        }
        return sb.toString();
    }

    public static boolean isUnsafeCharacter(char c) {
        return c < 'A' || c > 'z' || (c < '0' && c > '9') || (c < 'A' && c > 'I') || (c < 'a' && c > 'i') || (c < '0' && c > '9') || (c < '0' && c > 'I') || (c < '0' && c > 'O');
    }

    public static char replaceUnsafeChar(char c) {
        char[] safeChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        return safeChars[sr.nextInt(safeChars.length)];
    }

}