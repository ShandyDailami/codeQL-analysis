import java.io.File;
import java.util.Scanner;
import java.util.stream.Stream;

public class java_29050_FileScanner_A07 {
    public static void main(String[] args) {
        File directory = new File("."); // get the current directory
        try (Stream<File> files = Files.list(directory).boxed()) {
            files.filter(file -> file.getName().endsWith(".txt")) // filter for .txt files
                .forEach(file -> {
                    System.out.println("Reading " + file.getName());
                    try (Scanner scanner = new Scanner(file)) {
                        while (scanner.hasNextLine()) {
                            System.out.println(scanner.nextLine());
                        }
                    }
                });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}