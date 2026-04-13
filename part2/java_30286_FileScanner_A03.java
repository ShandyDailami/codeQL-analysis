import java.io.File;
import java.util.Scanner;

public class java_30286_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        listFiles(directory, 0);

        scanner.close();
    }

    private static void listFiles(File directory, int indent) {
        for (int i = 0; i < indent; i++) {
            System.out.print("  ");
        }

        System.out.println("- " + directory.getName());

        File[] files = directory.listFiles();
        if (files == null) {
            return;
        }

        for (File file : files) {
            if (file.isDirectory()) {
                listFiles(file, indent + 1);
            } else {
                for (int i = 0; i < indent; i++) {
                    System.out.print("  ");
                }
                System.out.println("  - " + file.getName());
            }
        }
    }
}