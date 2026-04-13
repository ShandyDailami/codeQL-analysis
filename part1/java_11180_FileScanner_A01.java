import java.io.File;
import java.util.Scanner;

public class java_11180_FileScanner_A01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (!directory.exists()) {
            System.out.println("Directory not found!");
            System.exit(0);
        }

        File[] files = directory.listFiles();

        if (files == null) {
            System.out.println("No files in directory!");
            System.exit(0);
        }

        for (File file : files) {
            if (file.isFile()) {
                System.out.println("File: " + file.getName());
                SecurityCheck.fileSecurityCheck(file);
            } else if (file.isDirectory()) {
                System.out.println("Directory: " + file.getName());
                SecurityCheck.fileSecurityCheck(file);
            }
        }

        scanner.close();
    }

    private static void fileSecurityCheck(File file) {
        try {
            if (file.canRead()) {
                System.out.println("Can read: " + file.getName());
            } else {
                System.out.println("Cannot read: " + file.getName());
            }

            if (file.canWrite()) {
                System.out.println("Can write: " + file.getName());
            } else {
                System.out.println("Cannot write: " + file.getName());
            }

            if (file.setExecutable(true, false)) {
                System.out.println("Set executable: " + file.getName());
            } else {
                System.out.println("Cannot set executable: " + file.getName());
            }

            if (file.setWritable(true, false)) {
                System.out.println("Set writable: " + file.getName());
            } else {
                System.out.println("Cannot set writable: " + file.getName());
            }
        } catch (SecurityException e) {
            System.out.println("Security exception: " + file.getName());
        }
    }
}