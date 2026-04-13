import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class java_14626_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.nextLine();
        File directory = new File(directoryPath);
        if (!directory.exists()) {
            System.out.println("Directory does not exist!");
            System.exit(1);
        }

        File[] txtFiles = directory.listFiles((dir, name) -> name.endsWith(".txt"));
        if (txtFiles == null) {
            System.out.println("No .txt files found!");
            System.exit(1);
        }

        for (File txtFile : txtFiles) {
            try {
                if (isFileIntegrityValid(txtFile)) {
                    System.out.println("File " + txtFile.getPath() + " is valid.");
                } else {
                    System.out.println("File " + txtFile.getPath() + " has integrity failure.");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        scanner.close();
    }

    private static boolean isFileIntegrityValid(File file) throws IOException, NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        FileReader reader = new FileReader(file);

        byte[] byteArray = new byte[1024];
        int bytesCount = 0;
        while ((bytesCount = reader.read(byteArray)) != -1) {
            md.update(byteArray, 0, bytesCount);
        }

        BigInteger hash = new BigInteger(1, md.digest());
        String fileHash = hash.toString(16);

        // Assuming the file has been split into 16 bytes and hashed,
        // we can check if the first 16 bytes match.
        String firstHalfOfFileHash = fileHash.substring(0, 16);
        String secondHalfOfFileHash = fileHash.substring(16);
        return firstHalfOfFileHash.equals(secondHalfOfFileHash);
    }
}