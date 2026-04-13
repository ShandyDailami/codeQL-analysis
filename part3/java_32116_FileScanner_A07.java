import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_32116_FileScanner_A07 {

    public static void main(String[] args) {
        File directory = new File("."); // Let's get the current directory
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory to scan: ");
        String dir = scanner.nextLine();
        scanner.close();

        try {
            scanDirectory(new File(directory, dir));
        } catch (FileNotFoundException e) {
            System.out.println("Directory not found!");
        }
    }

    private static void scanDirectory(File directory) throws FileNotFoundException {
        if (directory.listFiles() == null) {
            throw new FileNotFoundException("No such directory");
        }

        for (File file : directory.listFiles()) {
            if (file.isDirectory()) {
                scanDirectory(file); // recursion for subdirectories
            } else {
                printFile(file);
            }
        }
    }

    private static void printFile(File file) throws FileNotFoundException {
        if (file.canRead()) {
            System.out.println(file.getAbsolutePath());
        } else {
            throw new FileNotFoundException("Unable to read file: " + file.getAbsolutePath());
        }
    }
}