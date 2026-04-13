import java.io.File;
import java.util.Scanner;

public class java_28198_FileScanner_A03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory path: ");
        String directoryPath = scanner.nextLine();
        System.out.print("Enter the file extension: ");
        String fileExtension = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            FileScanner fileScanner = new FileScanner(directory, fileExtension);
            fileScanner.startScanning();

            while (fileScanner.hasNext()) {
                File file = fileScanner.nextFile();
                System.out.println("File found: " + file.getPath());
            }

            fileScanner.endScanning();
        } else {
            System.out.println("Directory does not exist or it's not a directory.");
        }
    }
}

class FileScanner {
    private File directory;
    private String fileExtension;

    public java_28198_FileScanner_A03(File directory, String fileExtension) {
        this.directory = directory;
        this.fileExtension = fileExtension;
    }

    public void startScanning() {
        System.out.println("Scanning files in directory...");
    }

    public void endScanning() {
        System.out.println("Finished scanning files in directory.");
    }

    public boolean hasNext() {
        return hasNextFile();
    }

    public File nextFile() {
        File[] files = directory.listFiles((dir, name) -> name.endsWith(fileExtension));
        if (files != null) {
            for (File file : files) {
                return file;
            }
        }
        return null;
    }

    private boolean hasNextFile() {
        File[] files = directory.listFiles((dir, name) -> name.endsWith(fileExtension));
        return files != null && files.length > 0;
    }
}