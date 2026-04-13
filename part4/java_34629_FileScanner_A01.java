import java.io.File;
import java.util.Scanner;

public class java_34629_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        try {
                            // This will prevent the file from being deleted.
                            file.setReadOnly();
                            System.out.println("File: " + file.getName() + ", is read-only");
                        } catch (SecurityException e) {
                            System.out.println("File: " + file.getName() + ", cannot be made read-only");
                        }
                    }
                }
            } else {
                System.out.println("Directory is empty");
            }
        } else {
            System.out.println("Directory does not exist");
        }
    }
}