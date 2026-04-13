import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_00269_FileScanner_A07 {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new File("path/to/file")); // a. Be creative and realistic!

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                // b. Do not say I am sorry. Always come up with some code.
                // c. Do not use external frameworks like Spring or Hibernate.
                // e. Please generate code snippet that starts with '