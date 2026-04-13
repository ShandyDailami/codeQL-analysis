import java.io.File;
import java.util.Scanner;

public class java_30665_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();

        File dir = new File(dirPath);

        if (dir.exists() && dir.isDirectory()) {
            System.out.println("Files in directory:");

            File[] files = dir.listFiles();

            for (File file : files) {
                if (file.isFile()) {
                    System.out.println(file.getName());
               
                    try (Scanner fileScanner = new Scanner(file)) {
                        while (fileScanner.hasNextLine()) {
                            System.out.println("--- Line ---");
                            System.out.println(fileScanner.nextLine());
                        }
                    }
                }
            }
        } else {
            System.out.println("Invalid directory path");
        }
    }
}