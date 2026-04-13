import java.io.File;
import java.util.Objects;
import java.util.Scanner;

public class java_04007_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the file extension to scan for:");
        String fileExtension = scanner.nextLine();

        FileScanner scannerProgram = new FileScanner();
        File[] foundFiles = scannerProgram.scanFiles("." + fileExtension);

        if (foundFiles.length == 0) {
            System.out.println("No files found with the extension " + fileExtension);
        } else {
            System.out.println("Files found with the extension " + fileExtension + ":");
            for (File file : foundFiles) {
                System.out.println(file.getPath());
            }
        }

        scanner.close();
    }
}

class FileScanner {
    public File[] scanFiles(String fileExtension) {
        File directory = new File(".");
        return directory.listFiles((dir, name) -> name.endsWith(fileExtension));
    }
}