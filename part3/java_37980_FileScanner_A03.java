import java.io.File;
import java.util.Scanner;

public class java_37980_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the path to the directory: ");
        String path = scanner.next();
        scanner.close();

        File file = new File(path);

        if (file.exists()) {
            if (file.isDirectory()) {
                System.out.println("Directory: " + file.getAbsolutePath());
                String[] directories = file.list();
                if (directories != null) {
                    for (String directory : directories) {
                        System.out.println(directory);
                        File dirFile = new File(file.getAbsolutePath() + "/" + directory);
                        if (dirFile.isDirectory()) {
                            printDirectory(dirFile, " - ");
                        } else {
                            System.out.println(dirFile.getAbsolutePath());
                        }
                    }
                }
            } else {
                System.out.println("File: " + file.getAbsolutePath());
            }
        } else {
            System.out.println("The given path does not exist");
        }
    }

    private static void printDirectory(File dir, String indent) {
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    System.out.println(indent + file.getName());
                    printDirectory(file, indent + " - ");
                } else {
                    System.out.println(indent + file.getName());
                }
            }
        }
    }
}