import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Scanner;

public class java_27045_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        FilenameFilter filter = new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.toLowerCase().endsWith(".txt");
            }
        };

        File[] txtFiles = directory.listFiles(filter);

        if (txtFiles != null) {
            Arrays.sort(txtFiles, File.CreationTime);

            for (File file : txtFiles) {
                System.out.println(file.getAbsolutePath());
            }
        } else {
            System.out.println("No .txt files found in the directory");
        }

        scanner.close();
    }
}