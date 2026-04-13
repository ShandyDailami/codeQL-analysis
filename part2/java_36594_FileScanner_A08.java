import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

public class java_36594_FileScanner_A08 {
    public static void main(String[] args) {
        Path path = Paths.get(".").resolve("test.txt");
        try (Stream<String> lines = Files.lines(path)) {
            Long lineCount = lines.count();
            Long wordCount = lines.flatMap(line -> Arrays.stream(line.split(" "))).count();
            Long charCount = lines.flatMap(line -> line.codePointCount(0, line.length())).count();

            System.out.println("Line count: " + lineCount);
            System.out.println("Word count: " + wordCount);
            System.out.println("Char count: " + charCount);
        } catch (Exception e) {
            System.out.println("Error occurred: " + e.getMessage());
        }
    }
}