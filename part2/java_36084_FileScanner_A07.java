import java.io.File;
import java.util.Scanner;

public class java_36084_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.nextLine();

        File directory = new File(path);

        if (directory.exists()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.getName().endsWith(".txt")) {
                        try {
                            Scanner fileScanner = new Scanner(file);
                            while (fileScanner.hasNextLine()) {
                                String line = fileScanner.nextLine();
                                if (line.contains("AuthFailure")) {
                                    System.out.println("Potential AuthFailure detected in file: " + file.getPath());
                                }
                            }
                            fileScanner.close();
                        } catch (Exception e) {
                            System.out.println("Error scanning file: " + file.getPath());
                        }
                    }
                }
            }
        } else {
            System.out.println("Directory does not exist.");
        }
    }
}