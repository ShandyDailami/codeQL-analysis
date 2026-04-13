import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class java_05244_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter directory path: ");
        String dirPath = scanner.nextLine();

        File dir = new File(dirPath);

        if (dir.exists() && dir.isDirectory()) {
            List<File> files = new ArrayList<>();
            getAllFiles(dir, files);

            for (File file : files) {
                System.out.println(file.getAbsolutePath());
            }
        } else {
            System.out.println("Directory not found!");
        }

        scanner.close();
    }

    private static void getAllFiles(File directory, List<File> files) {
        File[] listOfFiles = directory.listFiles();

        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isFile()) {
                    files.add(file);
                } else if (file.isDirectory()) {
                    getAllFiles(file, files);
                }
            }
        }
    }
}