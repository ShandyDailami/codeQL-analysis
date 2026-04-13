import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.io.FileFilter;

public class java_28335_FileScanner_A01 {
    public static void main(String[] args) {
        String filePath = "/path/to/directory"; // Replace with your directory path
        String extension = ".txt"; // Replace with your file extension

        File directory = new File(filePath);
        File[] txtFiles = directory.listFiles(new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(extension);
            }
        });

        if (txtFiles != null) {
            for (File txtFile : txtFiles) {
                try {
                    Scanner scanner = new Scanner(new FileReader(txtFile));
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        System.out.println(line);
                    }
                    scanner.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}