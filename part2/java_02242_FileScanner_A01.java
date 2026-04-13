import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class java_02242_FileScanner_A01 {

    private String username;
    private List<File> accessibleFiles = new ArrayList<>();

    public java_02242_FileScanner_A01(String username) {
        this.username = username;
    }

    public void scanDirectory(String directoryPath) {
        File directory = new File(directoryPath);

        getAccessibleFiles(directory);

        for (File file : accessibleFiles) {
            System.out.println(file.getAbsolutePath());
        }
    }

    private void getAccessibleFiles(File directory) {
        File[] files = directory.listFiles();

        for (File file : files) {
            if (file.isFile() && isFileAccessAllowed(file)) {
                accessibleFiles.add(file);
            } else if (file.isDirectory()) {
                getAccessibleFiles(file);
            }
        }
    }

    private boolean isFileAccessAllowed(File file) {
        try (Scanner scanner = new Scanner(file.toPath())) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.contains(username)) {
                    return true;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return false;
    }
}