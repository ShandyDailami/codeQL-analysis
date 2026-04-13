import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_08497_FileScanner_A01 {

    public static void main(String[] args) throws FileNotFoundException {

        // Get the directory name from the user
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter directory name: ");
        String dirName = scanner.nextLine();

        File dir = new File(dirName);

        // Ensure the directory exists
        if (!dir.exists()) {
            System.out.println("The directory does not exist.");
            return;
        }

        // Print the names of all text files in the directory
        System.out.println("Text files in " + dir.getAbsolutePath() + ":");
        File[] txtFiles = dir.listFiles(new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.isFile() && pathname.getName().endsWith(".txt");
            }
        });

        if (txtFiles == null) return;

        for (File txtFile : txtFiles) {
            System.out.println(txtFile.getAbsolutePath());
        }
    }
}