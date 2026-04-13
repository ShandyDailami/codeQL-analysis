import java.io.File;
import java.io.FilenameFilter;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_30092_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (!directory.exists()) {
            System.out.println("Directory does not exist");
            return;
        }

        if (!directory.isDirectory()) {
            System.out.println("Entered path is not a directory");
            return;
        }

        FilenameFilter filter = (dir, name) -> name.endsWith(".txt");

        try {
            findFiles(directory, filter);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void findFiles(File directory, FilenameFilter filter) throws FileNotFoundException {
        File[] listOfFiles = directory.listFiles(filter);

        if (listOfFiles == null) {
            return;
        }

        for (File file : listOfFiles) {
            if (file.isFile()) {
                System.out.println("File found: " + file.getAbsolutePath());
            } else {
                findFiles(file, filter);
            }
        }
    }
}