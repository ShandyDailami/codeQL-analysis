import java.io.File;
import java.util.Scanner;

public class java_31406_FileScanner_A01 {
    public static void main(String[] args) {
        File directory = new File(".");
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Enter the directory path:");
        String path = scanner.nextLine();
        
        FileScannerExample scanner = new FileScannerExample();
        scanner.scanDirectory(directory, path);
        
        scanner.displayFiles();
    }
    
    File directory;
    String path;
    File[] files;
    
    public java_31406_FileScanner_A01() {
        this.directory = new File(".");
        this.path = "";
    }
    
    public java_31406_FileScanner_A01(File directory, String path) {
        this.directory = directory;
        this.path = path;
    }
    
    public void scanDirectory(File directory, String path) {
        if (directory.isDirectory()) {
            files = directory.listFiles();
            
            for (File file : files) {
                if (file.isFile() && file.getPath().startsWith(path)) {
                    // Do something with the file here
                } else if (file.isDirectory()) {
                    scanDirectory(file, path);
                }
            }
        }
    }
    
    public void displayFiles() {
        for (File file : files) {
            if (file.isFile()) {
                System.out.println(file.getPath());
            }
        }
    }
}