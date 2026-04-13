import java.io.File;
import java.util.Scanner;

public class java_15398_FileScanner_A08 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the directory path:");
        String directoryPath = scanner.next();

        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        if (isFileIntegritySafe(file)) {
                            System.out.println("File integrity is safe for file: " + file.getName());
                        } else {
                            System.out.println("File integrity could be compromised for file: " + file.getName());
                        }
                    }
                }
            } else {
                System.out.println("Directory does not exist: " + directoryPath);
            }
        } else {
            System.out.println("Directory does not exist: " + directoryPath);
        }

        scanner.close();
    }

    private static boolean isFileIntegritySafe(File file) {
        try {
            byte[] fileBytes = new byte[(int) file.length()];
            Scanner scanner = new Scanner(file);
            scanner.nextBytes(fileBytes);
            scanner.close();

            byte[] expectedBytes = new byte[]{(byte) 1, (byte) 2, (byte) 3, (byte) 4};

            for (int i = 0; i < fileBytes.length; i++) {
                if (fileBytes[i] != expectedBytes[i % expectedBytes.length]) {
                    return false;
                }
            }

            return true;
        } catch (Exception e) {
            return false;
        }
    }
}