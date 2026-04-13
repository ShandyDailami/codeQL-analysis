import java.io.File;
import java.util.Scanner;

public class java_28738_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            System.out.println("Reading files in " + directoryPath);
            String[] files = directory.list();

            if (files != null) {
                for (String fileName : files) {
                    File file = new File(directoryPath + "/" + fileName);

                    if (file.exists() && file.isFile()) {
                        System.out.println("Content of " + fileName + ":");
                        Scanner fileScanner = new Scanner(file);
                        while (fileScanner.hasNextLine()) {
                            System.out.println(fileScanner.nextLine());
                        }
                        fileScanner.close();
                    }
                }
            }
        } else {
            System.out.println("Directory not found.");
        }

        scanner.close();
    }
}