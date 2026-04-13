import java.io.File;
import java.util.Scanner;

public class java_09073_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter directory path: ");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            System.out.println("Reading files from directory...");

            String[] files = directory.list();

            if (files != null) {
                for (String file : files) {
                    File fileObject = new File(directoryPath + "/" + file);

                    if (fileObject.isFile() && fileObject.canRead()) {
                        System.out.println("File name: " + fileObject.getName());

                        Scanner fileScanner = new Scanner(fileObject);
                        while (fileScanner.hasNextLine()) {
                            System.out.println(fileScanner.nextLine());
                       
                        }
                        fileScanner.close();
                    }
                }
            }
        } else {
            System.out.println("Invalid directory path or directory does not exist.");
        }

        scanner.close();
    }
}