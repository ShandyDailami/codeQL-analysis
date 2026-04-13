import java.io.File;
import java.util.Scanner;

public class java_20678_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory:");
        String directory = scanner.nextLine();
        scanner.close();

        File startingDirectory = new File(directory);
        listDirectory(startingDirectory, 0);
    }

    private static void listDirectory(File directory, int indentation) {
        for (int i = 0; i < indentation; i++) {
            System.out.print("  ");
        }
        System.out.println(directory.getName());

        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    listDirectory(file, indentation + 1);
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