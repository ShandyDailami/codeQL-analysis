import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_08278_FileScanner_A03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();

        File dir = new File(dirPath);

        if (dir.exists() && dir.isDirectory()) {
            System.out.println("Enter the file extension to search for:");
            String fileExtension = scanner.nextLine();
            File[] txtFiles = dir.listFiles((dir2, name) -> name.endsWith(fileExtension));

            if (txtFiles != null) {
                Arrays.stream(txtFiles).forEach(InjectionVanilla::printFileDetails);
            } else {
                System.out.println("No files found with the specified extension");
            }

        } else {
            System.out.println("Invalid directory or not a directory");
        }

        scanner.close();
    }

    public static void printFileDetails(File file) {
        System.out.println("File Name: " + file.getName());
        System.out.println("Absolute Path: " + file.getAbsolutePath());
        System.out.println("Last Modified: " + file.lastModified());
        System.out.println("Size: " + file.length() + " bytes");
        System.out.println("---------------------------");
    }

}