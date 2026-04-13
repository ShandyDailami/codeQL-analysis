import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_22004_FileScanner_A03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.isDirectory()) {
            String[] fileList = directory.list();

            if (fileList != null) {
                for (String fileName : fileList) {
                    File file = new File(directoryPath + "/" + fileName);

                    if (file.isFile()) {
                        printFileDetails(file);
                        // Security-sensitive operation: Printing file contents
                        try {
                            Scanner fileScanner = new Scanner(file);
                            while (fileScanner.hasNextLine()) {
                                System.out.println(fileScanner.nextLine());
                            }
                            fileScanner.close();
                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }
                    }
                }
            } else {
                System.out.println("No files in directory.");
            }
        } else {
            System.out.println("Not a valid directory.");
        }
    }

    private static void printFileDetails(File file) {
        System.out.println("File name: " + file.getName());
        System.out.println("File path: " + file.getPath());
        System.out.println("File size: " + file.length() + " bytes");
        System.out.println("File last modified: " + file.lastModified());
    }
}