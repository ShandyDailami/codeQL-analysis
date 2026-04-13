import java.io.File;
import java.util.Scanner;

public class java_15418_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        try {
            File directory = new File(directoryPath);
            File[] files = directory.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && file.canRead()) {
                        Scanner fileScanner = new Scanner(file);
                        while (fileScanner.hasNextLine()) {
                            String line = fileScanner.nextLine();
                            if (line.contains("AuthFailure") && line.matches(".*AuthFailure.*")) {
                                System.out.println("Found AuthFailure in file: " + file.getPath());
                            }
                        }
                        fileScanner.close();
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}