import java.io.File;
import java.util.HashSet;
import java.util.Set;
import java.util.Scanner;

public class java_25926_FileScanner_A03 {

    private static final String DIRECTORY_PATH = "src/main/resources";
    private static final String FILE_EXTENSION = ".*\\.java";
    private static final Set<String> SAFE_FILE_NAMES = new HashSet<String>() {{
        add("FileScanner.java");
        add("FileScanner.java");
        // add other safe file names here
    }};

    public static void main(String[] args) {
        File directory = new File(DIRECTORY_PATH);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the file name:");
        String fileName = scanner.nextLine();
        File file = new File(directory, fileName);
        if (file.exists() && file.isFile() && isSafeFile(file)) {
            System.out.println("The file is safe for scanning!");
        } else {
            System.out.println("The file is not safe for scanning!");
        }
    }

    private static boolean isSafeFile(File file) {
        String name = file.getName();
        if (name.endsWith(".java")) {
            return SAFE_FILE_NAMES.contains(name);
        }
        return false;
    }
}