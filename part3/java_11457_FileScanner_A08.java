import java.io.File;
import java.util.Scanner;

public class java_11457_FileScanner_A08 {

    public static void main(String[] args) {

        File directory = new File(".");
        File[] listOfFiles = directory.listFiles();

        for (File file : listOfFiles) {
            if (file.isFile()) {
                System.out.println("\nContents of " + file.getName() + ":");
                try (Scanner scanner = new Scanner(file)) {
                    while (scanner.hasNextLine()) {
                        System.out.println(scanner.nextLine());
                   
                    }
                }
            }
        }
    }
}