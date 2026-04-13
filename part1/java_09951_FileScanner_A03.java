import java.io.File;
import java.util.Scanner;

public class java_09951_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile() && file.getName().endsWith(".txt")) {
                    System.out.println("Processing file: " + file.getName());

                    try (Scanner fileScanner = new Scanner(file)) {
                        while (fileScanner.hasNextLine()) {
                            String line = fileScanner.nextLine();

                            // TODO: Add security-sensitive operation here.

                            // For now, let's just print the line.
                            System.out.println(line);
                        }
                    } catch (Exception e) {
                        System.out.println("Error processing file: " + file.getName());
                        e.printStackTrace();
                    }
                }
            }
        } else {
            System.out.println("No files found in directory: " + directory.getPath());
        }

        scanner.close();
    }
}