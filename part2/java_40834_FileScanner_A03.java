import java.io.File;
import java.util.Scanner;
import java.io.FileFilter;
import java.io.FileNotFoundException;

public class java_40834_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter directory path: ");
        String directoryPath = scanner.nextLine();
        System.out.print("Enter extension: ");
        String extension = scanner.nextLine();

        File directory = new File(directoryPath);

        File[] txtFiles = directory.listFiles(new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(extension);
            }
        });

        if (txtFiles != null) {
            for (File txtFile : txtFiles) {
                try {
                    Scanner fileScanner = new Scanner(txtFile);
                    while (fileScanner.hasNextLine()) {
                        String line = fileScanner.nextLine();
                        System.out.println(line);
                    }
                    fileScanner.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        } else {
            System.out.println("No .txt files found in the specified directory!");
        }
    }
}