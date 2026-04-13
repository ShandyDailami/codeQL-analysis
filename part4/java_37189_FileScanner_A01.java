import java.io.File;
import java.util.Scanner;

public class java_37189_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter directory path: ");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.isDirectory()) {
            String[] files = directory.list();

            for (String file : files) {
                File fileObject = new File(directoryPath + "/" + file);

                if (fileObject.isFile()) {
                    System.out.println("File: " + fileObject.getAbsolutePath());

                    try {
                        Scanner fileScanner = new Scanner(fileObject);

                        while (fileScanner.hasNextLine()) {
                            System.out.println("Content: " + fileScanner.nextLine());
                        }

                        fileScanner.close();
                    } catch (Exception e) {
                        System.out.println("An error occurred while reading the file: " + fileObject.getAbsolutePath());
                    }
                }
            }
        } else {
            System.out.println("The provided path is not a directory.");
        }

        scanner.close();
    }
}