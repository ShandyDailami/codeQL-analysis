import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_29143_FileScanner_A08 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the path to a file:");
        String path = scanner.nextLine();
        scanner.close();

        File file = new File(path);

        if (file.exists()) {
            printFiles(file, "");
        } else {
            System.out.println("The file does not exist!");
        }
    }

    private static void printFiles(File file, String indentation) {
        for (int i = 0; i < indentation.length(); i++) {
            System.out.print("--");
        }
        System.out.println(file.getName());

        if (file.isDirectory()) {
            File[] subFiles = file.listFiles();
            if (subFiles != null) {
                for (File subFile : subFiles) {
                    printFiles(subFile, indentation + "--");
                }
            }
        }
    }
}