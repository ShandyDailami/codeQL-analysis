import java.io.File;
import java.util.Scanner;
import java.util.Iterator;

public class java_05253_FileScanner_A01 {
    public static void main(String[] args) {
        String directoryPath = "/path/to/directory"; // Replace with your directory path
        File directory = new File(directoryPath);

        if (!directory.exists()) {
            System.out.println("Directory does not exist!");
            return;
        }

        File[] files = directory.listFiles();

        if (files == null) {
            System.out.println("Could not list files!");
            return;
        }

        System.out.println("Files in directory:");

        for (File file : files) {
            if (file.isFile()) {
                System.out.println(file.getName());
            }
        }

        System.out.println("Enter filename to read:");
        Scanner scanner = new Scanner(System.in);
        String filename = scanner.next();
        File targetFile = new File(directory, filename);

        if (!targetFile.exists()) {
            System.out.println("File does not exist!");
            return;
        }

        Iterator<String> iterator = new FileScanner(targetFile);
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}