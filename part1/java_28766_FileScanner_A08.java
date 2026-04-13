import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileReader;

public class java_28766_FileScanner_A08 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.nextLine();
        scanner.close();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile() && file.canRead()) {
                        System.out.println("File path: " + file.getPath());
                        System.out.println("File content: ");
                        FileReader fr = new FileReader(file);
                        int c;
                        while ((c = fr.read()) != -1) {
                            System.out.print((char) c);
                        }
                        fr.close();
                        System.out.println();
                    } else if (!file.canRead()) {
                        System.out.println("File path: " + file.getPath() + " is not readable");
                    }
                }
            } else {
                System.out.println("No files found in the directory");
            }
        } else {
            System.out.println("The provided path is not a valid directory");
        }
    }
}