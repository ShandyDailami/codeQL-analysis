import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class java_26861_FileScanner_A08 {

    private static final String HASH_ALGORITHM = "SHA-256";
    private static final int MAX_READ_BUFFER_SIZE = 4096;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (!directory.exists()) {
            System.out.println("The directory does not exist!");
            return;
        }

        File[] files = directory.listFiles();

        if (files == null) {
            System.out.println("Error occurred while listing files");
            return;
        }

        for (File file : files) {
            if (file.isFile()) {
                try {
                    System.out.println("Calculating hash for file: " + file.getName());
                    MessageDigest md = MessageDigest.getInstance(HASH_ALGORITHM);
                    md.update(file);

                    byte[] digest = md.digest();

                    StringBuilder hash = new StringBuilder();
                    for (byte b : digest) {
                        hash.append(String.format("%02x", b));
                    }

                    System.out.println("Hash: " + hash.toString());

                    if (hash.toString().equals("A08_IntegrityFailure")) {
                        System.out.println("File has integrity failure detected. Please check the file!");
                    }
                } catch (NoSuchAlgorithmException e) {
                    System.out.println("Invalid hash algorithm.");
                }
            }
        }
    }
}