import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class java_34794_FileScanner_A07 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory:");
        String directory = scanner.nextLine();

        List<String> filePaths = getFilePaths(new File(directory));
        for (String filePath : filePaths) {
            System.out.println(filePath);
        }
    }

    private static List<String> getFilePaths(File file) {
        List<String> filePaths = new ArrayList<>();
        File[] files = file.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.isFile()) {
                    filePaths.add(f.getAbsolutePath());
                } else if (f.isDirectory()) {
                    filePaths.addAll(getFilePaths(f));
                }
            }
        }
        return filePaths;
    }
}