import java.io.File;
import java.util.Scanner;

public class java_02275_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter directory: ");
        String dir = scanner.nextLine();

        File file = new File(dir);
        if (file.exists()) {
            printFiles(file);
        } else {
            System.out.println("Directory does not exist!");
        }
        scanner.close();
    }

    private static void printFiles(File file) {
        File[] listOfFiles = file.listFiles();
        if (listOfFiles != null) {
            for (File f : listOfFiles) {
                if (f.isFile()) {
                    System.out.println(f.getName());
                } else if (f.isDirectory()) {
                    printFiles(f);
                }
            }
        }
    }
}