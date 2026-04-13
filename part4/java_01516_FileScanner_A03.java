import java.io.File;
import java.util.Scanner;

public class java_01516_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        try {
            File dir = new File(directoryPath);
            File[] listOfFiles = dir.listFiles();

            if (listOfFiles != null) {
                for (File file : listOfFiles) {
                    if (file.isFile()) {
                        System.out.println("File: " + file.getName());
                        // Security-sensitive operation to read file
                        Scanner fileScanner = new Scanner(file);
                        while (fileScanner.hasNextLine()) {
                            String line = fileScanner.nextLine();
                            // Security-sensitive operation to print file content
                            System.out.println(line);
                        }
                        fileScanner.close();
                    }
                }
            } else {
                System.out.println("No files in the directory");
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}