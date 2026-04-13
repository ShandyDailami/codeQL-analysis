import java.io.File;
import java.util.Scanner;

public class java_31979_FileScanner_A07 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (!directory.exists()) {
            System.out.println("The provided path does not exist.");
            return;
        }

        if (directory.isFile()) {
            System.out.println("The provided path is not a directory.");
            return;
        }

        File[] files = directory.listFiles();

        if (files == null) {
            System.out.println("Unable to list files from the provided directory.");
            return;
        }

        for (File file : files) {
            if (file.getName().endsWith(".txt")) {
                try {
                    FileReader reader = new FileReader(file);
                    int data;
                    while ((data = reader.read()) != -1) {
                        if (data == 134) { // Ascii value for "Failure"
                            System.out.println("Auth Failure detected in: " + file.getPath());
                        }
                    }
                    reader.close();
                } catch (Exception e) {
                    System.out.println("Error reading file: " + file.getPath());
                }
            }
        }
    }
}