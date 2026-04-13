import java.io.File;
import java.util.Scanner;

public class java_15604_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && file.getName().endsWith(".txt")) {
                        FileReader reader = null;
                        try {
                            reader = new FileReader(file);
                            int data;
                            while ((data = reader.read()) != -1) {
                                System.out.print((char) data);
                            }
                            reader.close();
                        } catch (Exception e) {
                            System.out.println("Error occurred while reading the file: " + file.getName());
                        }
                    }
                }
            } else {
                System.out.println("No files found in the directory: " + directoryPath);
            }
        } else {
            System.out.println("Invalid directory path or no such directory exists: " + directoryPath);
        }

        scanner.close();
    }
}