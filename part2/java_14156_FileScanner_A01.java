import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;

public class java_14156_FileScanner_A01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();
        System.out.println("Enter the file extension:");
        String fileExtension = scanner.nextLine();

        try {
            Set<Path> filePaths = new HashSet<>();
            File dir = new File(directoryPath);
            File[] files = dir.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.getName().endsWith(fileExtension)) {
                        Path path = Paths.get(file.getAbsolutePath());
                        filePaths.add(path);
                    }
                }
            }

            System.out.println("Files with the extension " + fileExtension + ":");
            for (Path path : filePaths) {
                System.out.println(path.toString());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}