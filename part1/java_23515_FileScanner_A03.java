import java.io.File;
import java.util.Scanner;

public class java_23515_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] secureFiles = directory.listFiles((dir, name) -> {
                File file = new File(dir, name);
                return file.isFile() && file.canRead() && !file.getName().contains("..");
            });

            if (secureFiles != null) {
                for (File secureFile : secureFiles) {
                    System.out.println("File: " + secureFile.getPath());
                }
            } else {
                System.out.println("No secure files found.");
            }
        } else {
            System.out.println("Directory does not exist.");
        }

        scanner.close();
    }
}