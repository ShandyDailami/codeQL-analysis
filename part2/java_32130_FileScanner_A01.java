import java.io.File;
import java.util.Scanner;

public class java_32130_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory:");
        String directory = scanner.nextLine();

        File rootDirectory = new File(directory);

        if (rootDirectory.isDirectory()) {
            listFiles(rootDirectory, 0);
        } else {
            System.out.println("Not a directory");
        }

        scanner.close();
    }

    private static void listFiles(File directory, int indentation) {
        for (int i = 0; i < indentation; i++) {
            System.out.print("--");
        }
        System.out.println(directory.getName());

        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    listFiles(file, indentation + 1);
                } else {
                    for (int i = 0; i < indentation + 1; i++) {
                        System.out.print("--");
                    }
                    System.out.println(file.getName());
                }
            }
        }
    }
}