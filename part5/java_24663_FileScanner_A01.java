import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_24663_FileScanner_A01 {
    private final String pattern;

    public java_24663_FileScanner_A01(String pattern) {
        this.pattern = pattern;
    }

    public void scan(String directoryPath) {
        File dir = new File(directoryPath);
        File[] files = dir.listFiles((dir2, name) -> name.matches(pattern));
        if (files != null) {
            Arrays.stream(files)
                    .map(File::getAbsolutePath)
                    .forEach(System.out::println);
        }
    }

    public static void main(String[] args) {
        new SecureFileScanner(".*.java").scan("src/main/java");
    }
}