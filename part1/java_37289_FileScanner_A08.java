import java.io.File;
import java.util.Scanner;

public class java_37289_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && file.canRead()) {
                        FileIntegrityChecker integrityChecker = new FileIntegrityChecker();
                        integrityChecker.checkFileIntegrity(file);
                    }
                }
            }
        } else {
            System.out.println("The specified directory does not exist or it's not a directory.");
        }

        scanner.close();
    }
}

class FileIntegrityChecker {
    public void checkFileIntegrity(File file) {
        try {
            FileChannel fileChannel = new FileChannel(file, FileChannel.MapMode.READ_ONLY);

            long length = file.length();
            byte[] hash = new byte[(int) length];
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");

            fileChannel.read(fileChannel.map(FileChannel.MapMode.READ_ONLY, 0, length).get();

            messageDigest.update(hash);
            byte[] newHash = messageDigest.digest();

            if (Arrays.equals(hash, newHash)) {
                System.out.println("The file integrity checker succeeded for file: " + file.getAbsolutePath());
            } else {
                System.out.println("Integrity check failed for file: " + file.getAbsolutePath());
            }

            fileChannel.close();
        } catch (IOException | NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}