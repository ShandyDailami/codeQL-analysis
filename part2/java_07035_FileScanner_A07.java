import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_07035_FileScanner_A07 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the file name you want to search:");
        String fileName = scanner.nextLine();

        String path = "."; // the path to start the search from

        search(new File(path), fileName);
    }

    private static void search(File file, String fileName) throws FileNotFoundException {
        if (file.isDirectory()) {
            File[] subFiles = file.listFiles();
            if (subFiles != null) {
                for (File subFile : subFiles) {
                    search(subFile, fileName);
                }
            }
        } else if (file.getName().equals(fileName)) {
            System.out.println("File found: " + file.getAbsolutePath());
        }
    }
}