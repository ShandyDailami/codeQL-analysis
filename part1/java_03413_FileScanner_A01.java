import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class java_03413_FileScanner_A01 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path: ");
        String path = scanner.nextLine();

        File file = new File(path);

        if (file.exists()) {
            if (file.isDirectory()) {
                File[] listFiles = file.listFiles();

                if (listFiles != null) {
                    for (File f : listFiles) {
                        if (f.isFile() && f.getName().endsWith(".txt")) {
                            System.out.println("Processing file: " + f.getName());
                            processFile(f);
                        }
                    }
                } else {
                    System.out.println("Error: " + file.getPath() + " is not a directory.");
                }
            } else {
                System.out.println("Error: " + file.getPath() + " is not a directory.");
            }
        } else {
            System.out.println("Error: " + file.getPath() + " does not exist.");
        }

        scanner.close();
    }

    private static void processFile(File file) {
        try {
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains("sensitive information")) {
                    System.out.println("Warning: Sensitive information found in file: " + file.getName());
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error: Unable to process file: " + file.getName());
        }
    }
}