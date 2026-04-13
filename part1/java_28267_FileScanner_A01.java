import java.io.File;
import java.util.Scanner;

public class java_28267_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.nextLine();

        File file = new File(path);

        if (file.exists()) {
            if (file.isDirectory()) {
                System.out.println("Directory scanning...");
                listFiles(file, scanner);
            } else {
                System.out.println("File found!");
                scanFile(file);
            }
        } else {
            System.out.println("Directory not found!");
        }

        scanner.close();
    }

    private static void listFiles(File file, Scanner scanner) {
        File[] listFiles = file.listFiles();

        if (listFiles != null) {
            for (File f : listFiles) {
                if (f.isDirectory()) {
                    listFiles(f, scanner);
                } else {
                    System.out.println("Found file: " + f.getName());
                }
            }
        }
    }

    private static void scanFile(File file) {
        try {
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }

            scanner.close();
        } catch (Exception e) {
            System.out.println("Error scanning file: " + file.getName());
        }
    }
}