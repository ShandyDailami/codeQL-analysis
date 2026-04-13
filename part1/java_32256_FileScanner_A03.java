import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class java_32256_FileScanner_A03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String directoryPath = scanner.nextLine();

        List<String> fileNames = getFileNames(new File(directoryPath));
        for (String fileName : fileNames) {
            System.out.println(fileName);
        }
    }

    private static List<String> getFileNames(File file) {
        List<String> fileNames = new ArrayList<>();
        File[] files = file.listFiles();
        if (files != null) {
            for (File f : files) {
                if (f.isFile()) {
                    fileNames.add(f.getAbsolutePath());
                } else if (f.isDirectory()) {
                    fileNames.addAll(getFileNames(f));
                }
            }
        }
        return fileNames;
    }
}