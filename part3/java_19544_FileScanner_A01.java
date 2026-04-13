import java.io.File;
import java.util.Scanner;

public class java_19544_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();

        File dir = new File(dirPath);

        if (dir.exists()) {
            File[] files = dir.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        String name = file.getName();

                        if (name.endsWith(".txt")) {
                            try {
                                Scanner fileScanner = new Scanner(file);

                                while (fileScanner.hasNextLine()) {
                                    String line = fileScanner.nextLine();

                                    if (line.contains("password")) {
                                        System.out.println("Found a line containing 'password': " + line);
                                    }
                                }

                                fileScanner.close();
                            } catch (Exception e) {
                                System.out.println("Error reading file: " + file.getPath());
                            }
                        }
                    }
                }
            }
        } else {
            System.out.println("The specified directory does not exist.");
        }

        scanner.close();
    }
}