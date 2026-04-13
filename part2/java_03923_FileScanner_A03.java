import java.io.File;
import java.util.Scanner;

public class java_03923_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String dirPath = scanner.nextLine();
        System.out.print("Enter the file extension: ");
        String fileExtension = scanner.nextLine();

        File directory = new File(dirPath);

        File[] txtFiles = directory.listFiles((dir, name) -> name.endsWith(fileExtension));

        if (txtFiles != null) {
            for (File txtFile : txtFiles) {
                readFile(txtFile);
            }
        } else {
            System.out.println("No .txt files found in the directory!");
        }

        scanner.close();
    }

    private static void readFile(File file) {
        try {
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }

            scanner.close();
        } catch (Exception e) {
            System.out.println("Error reading file: " + file.getName());
        }
    }
}