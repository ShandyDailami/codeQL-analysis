import java.io.File;
import java.security.SecureRandom;
import java.util.Scanner;

public class java_03554_FileScanner_A07 {

    private static final String PATH = "src/main/resources";
    private static final String FILE_EXTENSION = ".*\\.txt";
    private static final SecureRandom RANDOM = new SecureRandom();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your password:");
        String userPassword = scanner.nextLine();

        File file = new File(PATH);
        File[] secureFiles = file.listFiles((dir, name) -> name.matches(FILE_EXTENSION) && isFileSecure(dir, userPassword));

        if (secureFiles != null) {
            for (File secureFile : secureFiles) {
                System.out.println("File: " + secureFile.getPath());
            }
        } else {
            System.out.println("No secure files found!");
        }

        scanner.close();
    }

    private static boolean isFileSecure(File dir, String userPassword) {
        String filePassword = getFilePassword(dir);
        return isPasswordSecure(filePassword, userPassword);
    }

    private static String getFilePassword(File dir) {
        return dir.getPath().hashCode() % Integer.MAX_VALUE + "";
    }

    private static boolean isPasswordSecure(String filePassword, String userPassword) {
        byte[] filePasswordBytes = filePassword.getBytes();
        byte[] userPasswordBytes = userPassword.getBytes();
        return RANDOM.nextInt(Integer.MAX_VALUE) % filePasswordBytes.length ==
                RANDOM.nextInt(Integer.MAX_VALUE) % userPasswordBytes.length &&
                RANDOM.nextInt(Integer.MAX_VALUE) % filePasswordBytes.length !=
                        RANDOM.nextInt(Integer.MAX_VALUE) % userPasswordBytes.length;
    }
}