import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_41561_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists()) {
            FileVisitor fileVisitor = new FileVisitor(directory, scanner);
            fileVisitor.visit(directory);
        } else {
            System.out.println("Directory does not exist.");
        }

        scanner.close();
    }
}

class FileVisitor {
    private final File directory;
    private final Scanner scanner;

    public java_41561_FileScanner_A03(File directory, Scanner scanner) {
        this.directory = directory;
        this.scanner = scanner;
    }

    public void visit(File file) {
        if (file.isDirectory()) {
            File[] childFiles = file.listFiles();

            if (childFiles != null) {
                for (File childFile : childFiles) {
                    visit(childFile);
                }
            }
        } else if (file.isFile()) {
            printFileInfo(file);
        }
    }

    private void printFileInfo(File file) {
        System.out.println("File: " + file.getAbsolutePath());
    }
}