import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class java_15700_FileScanner_A08 {

    public static void main(String[] args) {
        File file = new File(".");
        List<String> fileNames = new ArrayList<>();
        findFiles(file, "A08_IntegrityFailure", fileNames);
        fileNames.forEach(System.out::println);
    }

    private static void findFiles(File file, String keyword, List<String> fileNames) {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File f : listFiles) {
                if (f.isFile()) {
                    if (containsKeyword(f, keyword)) {
                        fileNames.add(f.getAbsolutePath());
                    }
                } else if (f.isDirectory()) {
                    findFiles(f, keyword, fileNames);
                }
            }
        }
    }

    private static boolean containsKeyword(File f, String keyword) {
        try (Scanner scanner = new Scanner(f)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains(keyword)) {
                    return true;
                }
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }
}