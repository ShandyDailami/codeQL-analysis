import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_40494_FileScanner_A08 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);
        printFiles(directory, "");
    }

    private static void printFiles(File directory, String indentation) {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println(indentation + file.getName());
                } else if (file.isDirectory()) {
                    System.out.println(indentation + file.getName() + "/");
                    printFiles(file, indentation + "  ");
                }
            }
        }
    }
}