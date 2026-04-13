import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class java_36385_FileScanner_A07 {

    private static final String DIRECTORY = "path_to_your_directory"; // replace with your directory

    public static void main(String[] args) {
        File directory = new File(DIRECTORY);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter password to start:");
        String password = scanner.nextLine();
        MessageDigest md = null;
        try {
            md = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().endsWith(".txt")) {
                    try {
                        md.update(password.getBytes());
                        byte[] digest = md.digest();

                        StringBuilder sb = new StringBuilder();
                        for (byte b : digest) {
                            sb.append(String.format("%02x", b));
                        }

                        if (sb.toString().equals(file.getName())) {
                            System.out.println("Match found: " + file.getPath());
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}