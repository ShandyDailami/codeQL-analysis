import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_09708_FileScanner_A01 {
    public static void main(String[] args) {
        String directoryPath = "."; // change this to your directory
        File directory = new File(directoryPath);

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter directory path (or leave blank for current directory):");
            String input = scanner.nextLine();
            if (!input.isEmpty()) {
                directory = new File(input);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Invalid directory path.");
            System.exit(1);
        }

        listFiles(directory, 0);
    }

    private static void listFiles(File directory, int indentation) {
        for (int i = 0; i < indentation; i++) {
            System.out.print("  ");
        }
        System.out.println(directory.getName());

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