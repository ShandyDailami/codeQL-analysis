import java.io.File;
import java.util.Scanner;

public class java_39395_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = input.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            String[] files = directory.list();

            if (files != null) {
                for (String file : files) {
                    File fileObject = new File(directoryPath + "/" + file);

                    if (fileObject.canRead()) {
                        System.out.println("File name: " + fileObject.getName());
                        System.out.println("File path: " + fileObject.getPath());
                        System.out.println("File size: " + fileObject.length() + " bytes");
                        System.out.println("----------------------");
                    }
                }
            } else {
                System.out.println("No files in this directory");
            }
        } else {
            System.out.println("This is not a valid directory");
        }

        input.close();
    }
}