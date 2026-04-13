import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_16600_FileScanner_A07 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] listOfFiles = directory.listFiles();

            if (listOfFiles != null) {
                for (File file : listOfFiles) {
                    if (file.isFile() && file.canRead() && !file.getName().endsWith(".java")) {
                        try {
                            Scanner fileScanner = new Scanner(file);
                            while (fileScanner.hasNextLine()) {
                                String line = fileScanner.nextLine();
                                if (line.contains("AuthFailure") && !line.contains("A07_AuthFailure")) {
                                    System.out.println("File: " + file.getAbsolutePath());
                                    System.out.println("Line: " + line);
                                }
                            }
                            fileScanner.close();
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                }
            } else {
                System.out.println("No files in directory!");
            }
        } else {
            System.out.println("Directory not found!");
        }

        scanner.close();
    }
}