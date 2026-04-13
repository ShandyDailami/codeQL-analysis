import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_17369_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.nextLine();
        scanner.close();

        File dir = new File(path);
        if (!dir.exists()) {
            System.out.println("Directory does not exist!");
            return;
        }

        try {
            FileScanner fileScanner = dir.newFileScanner();
            fileScanner.useDirs(true);
            fileScanner.useFiles(false);

            System.out.println("Files in directory " + dir.getAbsolutePath() + ":");
            while (fileScanner.scan()) {
                File file = fileScanner.nextFile();
                System.out.println(file.getName());
            }

            fileScanner.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}