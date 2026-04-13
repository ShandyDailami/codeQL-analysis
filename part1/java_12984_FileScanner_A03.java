import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class java_12984_FileScanner_A03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();
        File startingDirectory = new File(dirPath);
        FileScanner(startingDirectory);
    }

    public static void FileScanner(File directory) {
        File[] foundFiles = directory.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return !pathname.isHidden() && pathname.isFile() && (pathname.getName().endsWith(".java") || pathname.getName().endsWith(".txt"));
            }
        });

        if (foundFiles != null) {
            for (File file : foundFiles) {
                if (file.isDirectory()) {
                    FileScanner(file);
                } else {
                    printFileContent(file);
                }
            }
        }
    }

    public static void printFileContent(File file) {
        try (FileReader reader = new FileReader(file)) {
            int c;
            while ((c = reader.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}