import java.io.File;
import java.util.Scanner;

public class java_20417_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        printFiles(directory, 1);
    }

    private static void printFiles(File directory, int indentation) {
        for (int i = 0; i < indentation; i++) {
            System.out.print("--");
        }
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println(file.getName());
                } else if (file.isDirectory()) {
                    System.out.println();
                    printFiles(file, indentation + 1);
                }
            }
        }
    }
}