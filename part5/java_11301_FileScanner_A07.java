import java.io.File;
import java.io.FileFilter;
import java.util.Scanner;

public class java_11301_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory:");
        String directory = scanner.nextLine();

        System.out.println("Enter the file to search for:");
        String fileToSearch = scanner.nextLine();

        searchFile(new File(directory), fileToSearch);
    }

    public static void searchFile(File directory, String fileToSearch) {
        FileFilter fileFilter = new FileFilter() {
            public boolean accept(File pathname) {
                return pathname.getName().equals(fileToSearch);
            }
        };

        File[] foundFiles = directory.listFiles(fileFilter);
        if (foundFiles != null) {
            for (File file : foundFiles) {
                if (file.isFile()) {
                    System.out.println("File found: " + file.getAbsolutePath());
                } else if (file.isDirectory()) {
                    System.out.println("Directory found: " + file.getAbsolutePath());
                    searchFile(file, fileToSearch);
                }
            }
        }
    }
}