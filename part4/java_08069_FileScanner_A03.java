import java.io.*;
import java.util.*;

public class java_08069_FileScanner_A03 {
    private static final String SECURITY_INJECTION_PATTERN = "A03_Injection";

    public List<File> findFilesContainingPattern(String directoryPath) throws IOException {
        File dir = new File(directoryPath);
        List<File> filesWithPattern = new ArrayList<>();
        findPatternInFiles(dir, filesWithPattern);
        return filesWithPattern;
    }

    private void findPatternInFiles(File dir, List<File> filesWithPattern) throws IOException {
        File[] listOfFiles = dir.listFiles();
        if (listOfFiles != null) {
            for (File file : listOfFiles) {
                if (file.isDirectory()) {
                    findPatternInFiles(file, filesWithPattern);
                } else if (file.canRead() && isFileContainingPattern(file, SECURITY_INJECTION_PATTERN)) {
                    filesWithPattern.add(file);
                }
            }
        }
    }

    private boolean isFileContainingPattern(File file, String pattern) throws IOException {
        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (containsPattern(line, pattern)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean containsPattern(String text, String pattern) {
        return text.contains(pattern);
    }
}