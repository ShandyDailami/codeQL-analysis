import java.io.File;
import java.util.Scanner;

public class java_34152_FileScanner_A03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File file = new File(directoryPath);

        if (file.exists()) {
            if (file.isDirectory()) {
                System.out.println("Searching for injection vulnerabilities...");

                file.listFiles((dir, name) -> name.endsWith(".java") || name.endsWith(".java.db") || name.endsWith(".class"));

            } else {
                System.out.println("The provided path is not a directory.");
            }
        } else {
            System.out.println("The provided path does not exist.");
        }
    }
}