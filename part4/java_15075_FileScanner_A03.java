import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_15075_FileScanner_A03 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String path = scanner.nextLine();
        scanner.close();

        File dir = new File(path);
        File[] listOfFiles = dir.listFiles();

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile()) {
                    System.out.println("File: " + file.getName());
                } else if (file.isDirectory()) {
                    System.out.println("Directory: " + file.getName());
                }
            }
        } else {
            System.out.println("Error: " + path + " does not exist.");
        }
    }
}