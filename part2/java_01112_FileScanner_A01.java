import java.io.File;
import java.util.Scanner;
import java.util.Iterator;

public class java_01112_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.nextLine();

        File directory = new File(path);

        if (directory.exists()) {
            if (directory.isDirectory()) {
                File[] listOfFiles = directory.listFiles();
                if (listOfFiles != null) {
                    Iterator<File> iterator = ((List<File>) listOfFiles).iterator();

                    while (iterator.hasNext()) {
                        File file = iterator.next();
                        if (file.isFile()) {
                            System.out.println("File: " + file.getPath());
                        } else if (file.isDirectory()) {
                            System.out.println("Directory: " + file.getPath());
                        }
                    }
                }
            } else {
                System.out.println("Not a directory");
            }
        } else {
            System.out.println("Directory does not exist");
        }
    }
}