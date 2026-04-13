import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileFilter;

public class java_03734_FileScanner_A07 {
    public static void main(String[] args) {
        File startDir = new File("."); // start from current directory
        String startFileName = "A07_AuthFailure.txt"; // start with this file

        File[] allFiles = startDir.listFiles(new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().equals(startFileName);
            }
        });

        if (allFiles != null && allFiles.length > 0) {
            try (Scanner scanner = new Scanner(allFiles[0])) {
                while (scanner.hasNextLine()) {
                    System.out.println(scanner.nextLine());
                }
            } catch (FileNotFoundException e) {
                System.out.println("File not found: " + e.getMessage());
            } catch (IOException e) {
                System.out.println("Error reading file: " + e.getMessage());
            }
        } else {
            System.out.println("File not found.");
        }
    }
}