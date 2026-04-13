import java.io.File;
import java.util.Scanner;

public class java_18361_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.nextLine();

        File dir = new File(path);

        if (dir.exists() && dir.isDirectory()) {
            File[] txtFiles = dir.listFiles((dir1, name) -> name.endsWith(".txt"));

            if (txtFiles != null) {
                for (File file : txtFiles) {
                    System.out.println("Reading file: " + file.getName());

                    try (Scanner fileScanner = new Scanner(file)) {
                        while (fileScanner.hasNextLine()) {
                            String line = fileScanner.nextLine();
                            System.out.println(line);
                        }
                    }

                    System.out.println("--------------------------");
                }
            } else {
                System.out.println("No .txt files in directory.");
            }
        } else {
            System.out.println("Invalid directory or no such directory exists.");
        }

        scanner.close();
    }
}