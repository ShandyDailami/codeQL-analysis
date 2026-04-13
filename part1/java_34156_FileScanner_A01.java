import java.io.File;
import java.util.Scanner;

public class java_34156_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.nextLine();

        File file = new File(path);

        if (file.exists()) {
            if (file.isDirectory()) {
                File[] files = file.listFiles();
                if (files != null) {
                    for (File f : files) {
                        if (f.isFile() && f.getName().endsWith(".txt")) {
                            System.out.println("File found: " + f.getPath());
                            readFile(f);
                        }
                    }
                }
            } else {
                System.out.println("Not a directory");
            }
        } else {
            System.out.println("File not found");
        }
    }

    private static void readFile(File file) {
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println("Line read from file: " + line);
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("Error reading file: " + file.getPath());
        }
    }
}