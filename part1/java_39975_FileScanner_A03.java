import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_39975_FileScanner_A03 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String path = scanner.nextLine();

        File directory = new File(path);

        if (directory.exists()) {
            if (directory.isDirectory()) {
                System.out.println("Listing files in directory: " + directory.getAbsolutePath());
                String[] files = directory.list();

                for (String file : files) {
                    File fileObject = new File(directory.getAbsolutePath() + "/" + file);

                    if (fileObject.isFile()) {
                        System.out.println(fileObject.getName());
                    }
                }
            } else {
                System.out.println(directory.getAbsolutePath() + " is not a directory");
            }
        } else {
            System.out.println("The directory does not exist");
        }

        scanner.close();
    }
}