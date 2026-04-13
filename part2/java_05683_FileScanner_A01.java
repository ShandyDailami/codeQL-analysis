import java.io.File;
import java.util.Scanner;

public class java_05683_FileScanner_A01 {

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
                        if (file.getName().endsWith(".txt")) {
                            try {
                                Scanner textScanner = new Scanner(file);

                                while (textScanner.hasNextLine()) {
                                    String line = textScanner.nextLine();
                                    System.out.println(line);
                               
                                    if (line.contains("password")) {
                                        System.out.println("Access denied for file: " + file.getName());
                                    }
                                }
                                textScanner.close();
                            } catch (Exception e) {
                                System.out.println("Error reading file: " + file.getName());
                            }
                        }
                    }
                }
            }
        } else {
            System.out.println("Directory does not exist.");
        }
    }
}