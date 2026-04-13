import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Scanner;

public class java_08708_FileScanner_A07 {
    private static final String HASH_ALGORITHM = "SHA-256";
    private static final int MAX_FAILED_ATTEMPTS = 3;
    private static final String[] BLOCKED_FILES = {"banned.txt", "forbidden.txt"};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter file path: ");
            String filePath = scanner.nextLine();

            if (filePath.equalsIgnoreCase("quit")) {
                System.out.println("Exiting...");
                break;
            }

            if (fileExistsAndNotBlocked(filePath)) {
                try {
                    System.out.println("File content: " + getFileContent(filePath));
                    System.out.println("Hash: " + getFileHash(filePath));
                } catch (Exception e) {
                    System.out.println("Error occurred while processing file: " + e.getMessage());
                }
            } else {
                System.out.println("File is blocked or does not exist.");
            }
        }

        scanner.close();
    }

    private static boolean fileExistsAndNotBlocked(String filePath) {
        File file = new File(filePath);
        return file.exists() && !Arrays.asList(BLOCKED_FILES).contains(file.getName());
    }

    private static String getFileContent(String filePath) throws Exception {
        File file = new File(filePath);
        byte[] byteFile = new byte[(int) file.length()];
        FileInputStream fis = new FileInputStream(file);
        fis.read(byteFile);
        fis.close();
        return new String(byteFile);
    }

    private static String getFileHash(String filePath) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance(HASH_ALGORITHM);
        File file = new File(filePath);
        byte[] byteFile = new byte[(int) file.length()];
        FileInputStream fis = new FileInputStream(file);
        fis.read(byteFile);
        fis.close();
        md.update(byteFile);
        byte[] byteDigest = md.digest();
        return Arrays.toString(byteDigest);
    }
}