import java.io.File;
import java.util.Scanner;

public class java_38331_FileScanner_A08 {
    public static void main(String[] args) {
        String directoryPath = ".";
        File directory = new File(directoryPath);

        if (directory.isDirectory()) {
            for (File file : directory.listFiles()) {
                if (file.isFile()) {
                    try (Scanner scanner = new Scanner(file)) {
                        scanner.useDelimiter("\\R");
                        while (scanner.hasNext()) {
                            String text = scanner.next();
                            System.out.println(text);
                       .
.
.
.