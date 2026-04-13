import java.io.File;
import java.util.Scanner;

public class java_14001_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter directory path: ");
        String directoryPath = input.nextLine();
        System.out.print("Enter file extension: ");
        String fileExtension = input.nextLine();

        File directory = new File(directoryPath);

        File[] txtFiles = directory.listFiles((dir, name) -> name.endsWith(fileExtension));

        if (txtFiles != null) {
            for (File txtFile : txtFiles) {
                if (txtFile.isFile()) {
                    try (Scanner fileScanner = new Scanner(txtFile)) {
                        while (fileScanner.hasNextLine()) {
                            System.out.println(fileScanner.nextLine());
                        }
                    }
                }
            }
        }
    }
}