import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_29501_FileScanner_A07 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.nextLine();
        scanner.close();

        File file = new File(path);

        if (file.exists()) {
            printDirectoryContents(file, "");
        } else {
            System.out.println("The directory does not exist.");
        }
    }

    private static void printDirectoryContents(File file, String indentation) {
        File[] files = file.listFiles();

        if (files != null) {
            for (File f : files) {
                if (f.isDirectory()) {
                    System.out.println(indentation + f.getName() + "/");
                    printDirectoryContents(f, indentation + "  ");
                } else {
                    System.out.println(indentation + f.getName());
                }
            }
        }
    }
}