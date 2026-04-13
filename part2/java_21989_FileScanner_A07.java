import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_21989_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the root directory: ");
        String root = scanner.nextLine();

        // Create a FileFilter that only matches .txt files
        FileFilter filter = new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                return pathname.getName().endsWith(".txt");
            }
        };

        try {
            // Use the recursive method to read all files in the directory
            File file = new File(root);
            readFiles(file, filter);
        } catch (FileNotFoundException e) {
            System.out.println("Directory not found!");
        } finally {
            scanner.close();
        }
    }

    private static void readFiles(File file, FileFilter filter) throws FileNotFoundException {
        File[] listFiles = file.listFiles(filter);
        if (listFiles != null) {
            for (File f : listFiles) {
                if (f.isDirectory()) {
                    readFiles(f, filter);
                } else {
                    // Print the name of each file
                    System.out.println(f.getAbsolutePath());
                }
            }
        }
    }
}