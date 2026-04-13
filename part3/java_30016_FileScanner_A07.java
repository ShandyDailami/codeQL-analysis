import java.io.File;
import java.util.Scanner;

public class java_30016_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path: ");
        String path = scanner.nextLine();

        File dir = new File(path);

        if (dir.exists()) {
            File[] files = dir.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        String fileName = file.getName();

                        if (fileName.endsWith(".txt") || fileName.endsWith(".log")) {
                            try {
                                Scanner fileScanner = new Scanner(file);

                                while (fileScanner.hasNextLine()) {
                                    String line = fileScanner.nextLine();

                                    if (line.contains("error")) {
                                        System.out.println("Authentication failure detected in file: " + fileName);
                                    }
                                }

                                fileScanner.close();
                            } catch (Exception e) {
                                System.out.println("An error occurred while scanning the file: " + fileName);
                            }
                        }
                    }
                }
            }
        } else {
            System.out.println("The directory does not exist.");
        }

        scanner.close();
    }
}