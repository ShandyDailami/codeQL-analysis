import java.io.File;
import java.util.Scanner;

public class java_01623_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            System.out.println("Listing all .txt files in the directory:");

            File[] txtFiles = directory.listFiles((dir, name) -> name.endsWith(".txt"));

            if (txtFiles != null) {
                for (File file : txtFiles) {
                    if (file.canRead()) {
                        System.out.println(file.getAbsolutePath());
                    } else {
                        System.out.println("The file " + file.getAbsolutePath() + " is not readable.");
                    }
                }
            } else {
                System.out.println("No .txt files found in the directory.");
            }
        } else {
            System.out.println("The path " + directoryPath + " does not exist or is not a directory.");
        }

        scanner.close();
    }
}