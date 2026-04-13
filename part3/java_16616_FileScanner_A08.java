import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_16616_FileScanner_A08 {
    public static void main(String[] args) {
        File directory = new File(".");
        int fileCount = 0;

        try (Scanner scanner = new Scanner(directory.listFiles((dir, name) -> name.endsWith("A08_IntegrityFailure.txt")))) {
            while (scanner.hasNext()) {
                fileCount++;
                scanner.nextLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println("The file 'A08_IntegrityFailure.txt' appears " + fileCount + " times in the current directory and its subdirectories.");
    }
}