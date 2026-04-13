import java.io.File;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class java_02754_FileScanner_A01 {
    private static final String FOLDER_PATH = "/path/to/folder";
    private static final Set<String> ALLOWED_EXTENSIONS = new HashSet<>() {{
        add("txt");
        add("doc");
        add("docx");
    }};

    public static void main(String[] args) {
        File folder = new File(FOLDER_PATH);
        Set<File> textFiles = new HashSet<>();

        if (folder.exists() && folder.isDirectory()) {
            for (File file : folder.listFiles()) {
                if (file.isFile() && isAllowedExtension(file.getName())) {
                    textFiles.add(file);
                }
            }
        }

        System.out.println("Text files in " + folder.getPath() + ":");
        for (File file : textFiles) {
            System.out.println(file.getAbsolutePath());
        }
    }

    private static boolean isAllowedExtension(String fileName) {
        int lastDotIndex = fileName.lastIndexOf(".");
        if (lastDotIndex == -1) {
            return false;
        }
        String extension = fileName.substring(lastDotIndex + 1);
        return ALLOWED_EXTENSIONS.contains(extension);
    }
}