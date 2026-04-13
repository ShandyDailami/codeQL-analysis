import java.io.File;
import java.util.Scanner;

public class java_15726_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a file path: ");
        String path = scanner.nextLine();
        File file = new File(path);

        if (!file.exists()) {
            System.out.println("File does not exist!");
            return;
        }

        if (file.isDirectory()) {
            System.out.println("Entered path is a directory, not a file!");
            return;
        }

        try {
            FileScanner fileScanner = new FileScanner(file, ".txt");
            fileScanner.scan();
            System.out.println("Files in " + file.getPath() + ": " + fileScanner.getFilesFound());
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }

        scanner.close();
    }
}

class FileScanner {
    private File file;
    private String extension;
    private String[] filesFound;

    public java_15726_FileScanner_A03(File file, String extension) {
        this.file = file;
        this.extension = extension;
    }

    public void scan() {
        File[] files = file.listFiles((dir, name) -> name.endsWith(extension));
        if (files != null) {
            filesFound = new String[files.length];
            for (int i = 0; i < files.length; i++) {
                filesFound[i] = files[i].getPath();
            }
        }
    }

    public String[] getFilesFound() {
        return filesFound;
    }
}