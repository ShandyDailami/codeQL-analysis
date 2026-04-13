import java.io.File;
import java.util.Scanner;

public class java_41679_FileScanner_A03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter directory path: ");
        String path = scanner.nextLine();

        FileScanner(new File(path));
    }

    private static void FileScanner(File file) {
        if (file.isDirectory()) {
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File f : listFiles) {
                    FileScanner(f);
                }
            }
        } else {
            System.out.println(file.getPath());
        }
    }
}