import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_38421_FileScanner_A03 {
    public static void main(String[] args) {
        File directory = new File(".");
        findFiles(directory, new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().endsWith(".txt");
            }
        });
    }

    private static void findFiles(File directory, FileFilter filter) {
        File[] listFiles = directory.listFiles(filter);
        if (listFiles != null) {
            for (File file : listFiles) {
                try {
                    printFileContents(file);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void printFileContents(File file) throws FileNotFoundException {
        System.out.println("File: " + file.getPath());
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        }
    }
}