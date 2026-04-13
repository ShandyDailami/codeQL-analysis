import java.io.File;
import java.util.Scanner;

public class java_01163_FileScanner_A07 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.nextLine();

        File directory = new File(path);
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    try {
                        Scanner fileScanner = new Scanner(file);
                        while (fileScanner.hasNextLine()) {
                            String line = fileScanner.nextLine();
                            if (line.contains("A07_AuthFailure")) {
                                System.out.println("Found auth failure in file: " + file.getPath());
                            }
                        }
                        fileScanner.close();
                    } catch (Exception e) {
                        System.out.println("Error reading file: " + file.getPath());
                    }
                }
            }
        }

        scanner.close();
    }
}