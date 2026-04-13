import java.io.File;
import java.util.Scanner;

public class java_24771_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists()) {
            listFiles(directory, "");
        } else {
            System.out.println("Directory not found!");
        }

        scanner.close();
    }

    private static void listFiles(File directory, String indent) {
        for (int i = 0; i < indent.length() / 4; i++) {
            System.out.print(" ");
        }
        System.out.println(directory.getName());

        File[] files = directory.listFiles();

        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    listFiles(file, indent + " ");
                } else {
                    for (int i = 0; i < indent.length(); i++) {
                        System.out.print(" ");
                    }
                    System.out.println(file.getName());
                }
            }
        }
    }
}