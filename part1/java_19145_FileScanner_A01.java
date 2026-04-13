import java.io.File;
import java.util.Scanner;

public class java_19145_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String dirPath = scanner.nextLine();

        File dir = new File(dirPath);

        if (dir.exists() && dir.isDirectory()) {
            System.out.println("Files in directory: " + dir.list().length);

            System.out.println("Enter file name:");
            String fileName = scanner.nextLine();
            File file = new File(dir, fileName);

            if (file.exists() && file.isFile()) {
                try (Scanner fileScanner = new Scanner(file)) {
                    while (fileScanner.hasNextLine()) {
                        System.out.println(fileScanner.nextLine());
                    }
                }
            } else {
                System.out.println("File not found.");
            }
        } else {
            System.out.println("Directory not found.");
        }
    }
}