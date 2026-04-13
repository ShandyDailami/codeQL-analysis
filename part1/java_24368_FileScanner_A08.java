import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_24368_FileScanner_A08 {
    public static void main(String[] args) throws FileNotFoundException {
        File currentDirectory = new File(".");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the name of the file you want to search:");
        String fileName = scanner.nextLine();

        FileFilter fileFilter = new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.getName().equals(fileName);
            }
        };

        findFile(currentDirectory, fileFilter);
    }

    private static void findFile(File dir, FileFilter fileFilter) throws FileNotFoundException {
        File[] files = dir.listFiles(fileFilter);
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    if (file.getName().equals("A08_IntegrityFailure")) {
                        System.out.println("File found: " + file.getAbsolutePath());
                    }
                } else if (file.isDirectory()) {
                    findFile(file, fileFilter);
                }
            }
        }
    }
}