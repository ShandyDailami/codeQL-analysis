import java.io.File;
import java.util.Scanner;

public class java_08044_FileScanner_A03 {
    private static String targetWord;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the target word: ");
        targetWord = scanner.nextLine();
        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.nextLine();

        File file = new File(directoryPath);
        findTargetWord(file);
    }

    private static void findTargetWord(File file) {
        if (file.isDirectory()) {
            File[] childFiles = file.listFiles();
            if (childFiles != null) {
                for (File childFile : childFiles) {
                    findTargetWord(childFile);
                }
            }
        } else if (file.isFile() && containsTargetWord(file)) {
            System.out.println("Target word found in file: " + file.getPath());
        }
    }

    private static boolean containsTargetWord(File file) {
        try {
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains(targetWord)) {
                    return true;
                }
            }
        } catch (Exception e) {
            // Ignore exceptions for now
        }
        return false;
    }
}