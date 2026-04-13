import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_38968_FileScanner_A07 {
    public static void main(String[] args) throws FileNotFoundException {
        File directory = new File(".");

        // Use FileScanner to scan directory
        FileScanner fileScanner = new FileScanner() {
            @Override
            public void visitFile(File file) {
                if (file.isFile() && file.getName().endsWith(".txt")) {
                    System.out.println("File name: " + file.getName());
                    System.out.println("File contents:");
                    Scanner scanner = new Scanner(file);
                    while (scanner.hasNextLine()) {
                        System.out.println(scanner.nextLine());
                    }
                    scanner.close();
                }
            }
        };

        fileScanner.visit(directory);
    }
}