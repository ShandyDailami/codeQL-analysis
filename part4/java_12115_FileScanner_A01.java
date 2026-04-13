import java.io.File;
import java.util.Scanner;

public class java_12115_FileScanner_A01 {
    private static final String DIRECTORY = "src/main/java/";
    private static final String FILE_EXTENSION = ".java";

    public static void main(String[] args) {
        File directory = new File(DIRECTORY);
        File[] javaFiles = directory.listFiles((dir, name) -> name.endsWith(FILE_EXTENSION));

        if (javaFiles != null) {
            for (File file : javaFiles) {
                try (Scanner scanner = new Scanner(file)) {
                    while (scanner.hasNextLine()) {
                        String line = scanner.nextLine();
                        if (line.startsWith("