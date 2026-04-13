import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class java_06771_FileScanner_A01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String directoryPath = scanner.nextLine();

        List<File> files = getFiles(new File(directoryPath));

        for (File file : files) {
            System.out.println(file.getName());
        }
    }

    private static List<File> getFiles(File directory) {
        List<File> files = new ArrayList<>();
        File[] filesInDirectory = directory.listFiles();

        for (File file : filesInDirectory) {
            if (file.isFile()) {
                files.add(file);
            } else if (file.isDirectory()) {
                files.addAll(getFiles(file));
            }
        }

        return files;
    }
}