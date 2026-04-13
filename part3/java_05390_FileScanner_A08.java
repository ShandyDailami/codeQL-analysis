import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.NoSuchElementException;
import java.io.FileFilter;

public class java_05390_FileScanner_A08 {

    public static void main(String[] args) {
        File dir = new File(".");
        countFiles(dir, (File file) -> file.getName().endsWith(".txt"));
    }

    public static void countFiles(File dir, FileFilter filter) {
        if (!dir.exists()) {
            System.out.println("Directory does not exist");
            return;
        }

        if (!dir.canRead()) {
            System.out.println("You do not have permission to read this directory");
            return;
        }

        File[] files = dir.listFiles(filter);
        if (files == null) return;

        int count = 0;
        for (File file : files) {
            if (file.isFile()) {
                count += checkFileIntegrity(file);
            } else if (file.isDirectory()) {
                count += countFiles(file, filter);
            }
        }

        System.out.println("Number of files with integrity failure: " + count);
    }

    private static int checkFileIntegrity(File file) {
        try (Scanner scanner = new Scanner(file)) {
            int total = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.equals("A08_IntegrityFailure")) {
                    return 1;
                }
                total += line.length();
            }
            return total == 0 ? 0 : 1;
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + file.getPath());
            return 0;
        } catch (NoSuchElementException e) {
            System.out.println("Error reading file: " + file.getPath());
            return 0;
        }
    }
}