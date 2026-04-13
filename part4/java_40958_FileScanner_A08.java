import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_40958_FileScanner_A08 {
    public static void main(String[] args) {
        File dir = new File(".");
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter the directory path:");
            String path = scanner.nextLine();
            FileScanner scannerInstance = new FileScanner(new File(path));
            scannerInstance.listFiles("java", null, true);
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        }
    }
}

class FileScanner {
    private File file;

    public java_40958_FileScanner_A08(File file) {
        this.file = file;
    }

    public void listFiles(String extension, FileFilter filter, boolean recursive) {
        File[] files;
        if (recursive) {
            files = file.listFiles((dir, name) -> name.endsWith(extension));
        } else {
            files = file.listFiles(name -> name.endsWith(extension));
        }
        if (files != null) {
            for (File f : files) {
                System.out.println(f.getPath());
            }
        }
    }
}