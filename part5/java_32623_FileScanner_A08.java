import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class java_32623_FileScanner_A08 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String path = scanner.nextLine();
        List<String> filePaths = new ArrayList<>();
        getAllFilePaths(new File(path), filePaths);
        for (String filePath : filePaths) {
            System.out.println(filePath);
        }
    }

    private static void getAllFilePaths(File file, List<String> filePaths) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File f : files) {
                    getAllFilePaths(f, filePaths);
                }
            }
        } else {
            filePaths.add(file.getPath());
        }
    }
}