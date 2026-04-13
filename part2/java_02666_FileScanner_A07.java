import java.io.File;
import java.util.Scanner;

public class java_02666_FileScanner_A07 {
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
                            Scanner fileScanner = new Scanner(file);
                            while (fileScanner.hasNextLine()) {
                                String line = fileScanner.nextLine();
                                if (line.contains("A07_AuthFailure")) {
                                    System.out.println("AuthFailure found in file: " + file.getPath());
                                }
                            }
                            fileScanner.close();
                        } catch (Exception e) {
                            System.out.println("Error occurred while scanning file: " + file.getPath());
                        }
                    }
                }
            }
        } else {
            System.out.println("Directory does not exist.");
        }
        scanner.close();
    }
}