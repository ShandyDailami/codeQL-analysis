import java.io.File;
import java.util.Scanner;

public class java_27796_FileScanner_A01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists()) {
            listFiles(directory, 0);
        } else {
            System.out.println("Directory does not exist.");
        }

        scanner.close();
    }

    private static void listFiles(File directory, int indentation) {
        for (int i = 0; i < indentation; i++) {
            System.out.print("  ");
        }

        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    listFiles(file, indentation + 1);
                } else {
                    for (int i = 0; i < indentation + 1; i++) {
                        System.out.print("  ");
                    }
                    System.out.println(file.getName());
                }
            }
        }
    }
}