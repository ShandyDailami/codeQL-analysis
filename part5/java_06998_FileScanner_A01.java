import java.io.File;
import java.util.Scanner;
import java.util.Iterator;

public class java_06998_FileScanner_A01 {
    public static void main(String[] args) {
        File file = new File("."); // Use the current directory
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of file:");
        String fileName = scanner.nextLine();
        file = new File(fileName);

        if (!file.exists()) {
            System.out.println("File does not exist.");
            System.exit(1);
        }

        if (file.isDirectory()) {
            System.out.println("It is a directory.");
            File[] files = file.listFiles();

            if (files != null) {
                Iterator<File> iterator = ((Iterable<File>) files).iterator();
                while (iterator.hasNext()) {
                    File nextFile = iterator.next();
                    System.out.println(nextFile.getName());
                }
            }
        } else {
            System.out.println("It is not a directory.");
        }
    }
}