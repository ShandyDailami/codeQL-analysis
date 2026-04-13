import java.io.File;
import java.util.Scanner;

public class java_00278_FileScanner_A03 {
    public static void main(String[] args) {
        FileScanner fs = new FileScanner();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter directory path: ");
        String path = scanner.nextLine();
        System.out.print("Enter file name: ");
        String fileName = scanner.nextLine();
        File dir = new File(path);
        File file = new File(dir, fileName);
        fs.scanFile(file, "txt");
    }
}

class FileScanner {
    public void scanFile(File file, String extension) {
        try {
            if (file.isFile() && file.getName().endsWith(extension)) {
                Scanner scanner = new Scanner(file);
                while (scanner.hasNextLine()) {
                    System.out.println(scanner.nextLine());
                }
                scanner.close();
            } else {
                System.out.println("File not found or not a text file.");
            }
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}