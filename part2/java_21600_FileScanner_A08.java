import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_21600_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.nextLine();

        scanner.close();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            checkIntegrity(directory);
        } else {
            System.out.println("Directory does not exist or is not a directory!");
        }
    }

    private static void checkIntegrity(File directory) {
        for (File file : directory.listFiles()) {
            if (file.isFile() && file.getName().endsWith(".txt")) {
                try {
                    Scanner scanner = new Scanner(file);
                    long initialIntegrity = file.length();

                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        long lineIntegrity = line.getBytes().length;

                        if (initialIntegrity != lineIntegrity) {
                            System.out.println("Integrity failure at file: " + file.getAbsolutePath());
                        }
                    }

                    scanner.close();

                    System.out.println("File integrity checked successfully at: " + file.getAbsolutePath());
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}