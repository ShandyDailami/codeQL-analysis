import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.NoSuchElementException;

public class java_25071_FileScanner_A07 {

    public static void main(String[] args) {
        File dir = new File("."); // the current directory
        scanDirectory(dir);
    }

    private static void scanDirectory(File dir) {
        try (Scanner scanner = new Scanner(dir.listFiles())) {
            while (scanner.hasNext()) {
                File file = scanner.nextFile();
                if (file.isFile() && file.canRead()) {
                    printFileContent(file, scanner);
                } else if (file.isDirectory()) {
                    scanDirectory(file);
                }
            }
        } catch (NoSuchElementException e) {
            System.out.println("End of directory scan.");
        } catch (SecurityException e) {
            System.out.println("Access denied.");
        }
    }

    private static void printFileContent(File file, Scanner scanner) {
        System.out.println("Reading content of: " + file.getAbsolutePath());
        try (Scanner contentScanner = new Scanner(file)) {
            while (contentScanner.hasNextLine()) {
                String line = contentScanner.nextLine();
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + file.getAbsolutePath());
        } catch (NoSuchElementException e) {
            System.out.println("End of file: " + file.getAbsolutePath());
        }
    }
}