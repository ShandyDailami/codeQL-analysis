import java.io.File;
import java.util.Scanner;

public class java_07168_FileScanner_A01 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the directory path:");
            String path = scanner.nextLine();

            File dir = new File(path);

            if (dir.exists() && dir.isDirectory()) {
                String[] files = dir.list();
                for (String file : files) {
                    File currentFile = new File(dir.getPath() + "/" + file);
                    if (currentFile.isFile()) {
                        if (currentFile.canRead()) {
                            System.out.println("File: " + currentFile.getName());
                            System.out.println("Path: " + currentFile.getAbsolutePath());
                            System.out.println("Readable: " + currentFile.canRead());
                            System.out.println("Writable: " + currentFile.canWrite());
                            System.out.println("Executable: " + currentFile.canExecute());
                            System.out.println("---------------------------");
                        } else {
                            System.out.println("File: " + currentFile.getName() + " is not readable.");
                        }
                    } else if (currentFile.isDirectory()) {
                        System.out.println("Directory: " + currentFile.getName());
                    }
                }
            } else {
                System.out.println("Provided path does not exist or it is not a directory.");
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}