import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_11929_FileScanner_A08 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter directory path: ");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] txtFiles = directory.listFiles((dir, name) -> name.endsWith(".txt"));

            for (File file : txtFiles) {
                if (file.exists() && file.canRead()) {
                    Scanner fileScanner = new Scanner(file);
                    while (fileScanner.hasNextLine()) {
                        System.out.println("File name: " + file.getName());
                    }
                    fileScanner.close();
                }
            }
        } else {
            System.out.println("Directory does not exist or is not a directory.");
        }
    }
}