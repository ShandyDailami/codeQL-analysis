import java.io.File;
import java.io.FilenameFilter;
import java.util.Scanner;

public class java_40974_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists()) {
            FilenameFilter filter = (dir, name) -> name.endsWith(".txt");
            File[] txtFiles = directory.listFiles(filter);

            if (txtFiles != null) {
                for (File txtFile : txtFiles) {
                    readFile(txtFile);
                }
            } else {
                System.out.println("No .txt files found in the directory");
            }
        } else {
            System.out.println("The specified directory does not exist");
        }
    }

    public static void readFile(File file) {
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
            scanner.close();
        } catch (Exception e) {
            System.out.println("Error while reading the file: " + file.getAbsolutePath());
        }
    }
}