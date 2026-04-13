import java.io.File;
import java.util.Scanner;

public class java_21937_FileScanner_A03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.nextLine();
        scanner.close();

        File file = new File(path);

        if (file.exists()) {
            if (file.isDirectory()) {
                System.out.println("Directory listing:");
                listDirectory(file, "");
            } else {
                System.out.println("File content:");
                printFileContent(file);
            }
        } else {
            System.out.println("Directory not found");
        }
    }

    private static void listDirectory(File directory, String indent) {
        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    System.out.println(indent + "Directory: " + file.getName());
                    listDirectory(file, indent + "  ");
                } else {
                    System.out.println(indent + "File: " + file.getName());
                }
            }
        }
    }

    private static void printFileContent(File file) {
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("Error while reading file: " + file.getName());
        }
    }
}