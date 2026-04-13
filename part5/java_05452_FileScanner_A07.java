import java.io.File;
import java.util.Scanner;

public class java_05452_FileScanner_A07 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the path of the directory:");
        String path = scanner.nextLine();

        findFile(new File(path), "A07_AuthFailure.txt");
    }

    private static void findFile(File file, String fileName) {
        if (file.getName().equals(fileName)) {
            System.out.println("File found at: " + file.getPath());
            return;
        }

        if (file.isDirectory()) {
            for (File childFile : file.listFiles()) {
                findFile(childFile, fileName);
            }
        }
    }
}