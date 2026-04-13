import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class java_30674_FileScanner_A03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String dirPath = scanner.nextLine();

        File dir = new File(dirPath);
        if (!dir.exists()) {
            System.out.println("Directory does not exist");
            return;
        }

        List<File> files = getFiles(dir);
        for (File file : files) {
            System.out.println(file.getAbsolutePath());
        }

        scanner.close();
    }

    private static List<File> getFiles(File dir) {
        List<File> files = new ArrayList<>();
        for (File file : dir.listFiles()) {
            if (file.isFile()) {
                files.add(file);
            } else if (file.isDirectory()) {
                files.addAll(getFiles(file));
            }
        }
        return files;
    }
}