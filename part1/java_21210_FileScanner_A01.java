import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class java_21210_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String dirPath = scanner.nextLine();
        scanner.close();

        File dir = new File(dirPath);
        if (!dir.exists() || !dir.isDirectory()) {
            System.out.println("The provided path does not exist or is not a directory");
            return;
        }

        List<File> txtFiles = new ArrayList<>();
        File[] txtFilesInDir = dir.listFiles((dir1, name) -> name.endsWith(".txt"));

        if (txtFilesInDir != null) {
            for (File txtFile : txtFilesInDir) {
                if (txtFile.isFile() && txtFile.canRead()) {
                    txtFiles.add(txtFile);
                }
            }
        }

        if (txtFiles.isEmpty()) {
            System.out.println("No .txt files in the directory");
        } else {
            System.out.println("The following .txt files are in the directory:");
            for (File txtFile : txtFiles) {
                System.out.println(txtFile.getAbsolutePath());
            }
        }
    }
}