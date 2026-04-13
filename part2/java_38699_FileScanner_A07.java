import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_38699_FileScanner_A07 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("authFailure.log"));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains("Failed password for user")) {
                    String username = getUsername(line);
                    String password = getPassword(line);
                    String ip = getIpAddress(line);
                    System.out.println("Username: " + username);
                    System.out.println("Password: " + password);
                    System.out.println("IP Address: " + ip);
                    System.out.println("-----------------------------------");
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static String getUsername(String line) {
        return line.substring(line.indexOf("user ") + 5, line.indexOf(" for", line.indexOf("user ") + 5));
    }

    private static String getPassword(String line) {
        return line.substring(line.indexOf("for ") + 4, line.indexOf(" at", line.indexOf("for ") + 4));
    }

    private static String getIpAddress(String line) {
        return line.substring(line.indexOf("at ") + 3, line.indexOf(" ", line.indexOf("at ") + 3));
    }
}