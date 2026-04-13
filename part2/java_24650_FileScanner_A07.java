import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class java_24650_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter directory path: ");
        String directoryPath = scanner.nextLine();

        List<String> files = getFiles(new File(directoryPath));

        for (String file : files) {
            System.out.println(file);
        }
    }

    private static List<String> getFiles(File directory) {
        List<String> fileNames = new ArrayList<>();

        for (File file : directory.listFiles()) {
            if (file.isFile()) {
                fileNames.add(file.getPath());
            } else if (file.isDirectory()) {
                fileNames.addAll(getFiles(file));
            }
        }

        return fileNames;
    }
}