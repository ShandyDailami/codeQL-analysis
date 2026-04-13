import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_41665_FileScanner_A07 {

    public static void main(String[] args) {
        // Get the directory to scan
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the directory to scan: ");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        // If the directory does not exist, print error message and exit
        if (!directory.exists()) {
            System.out.println("Directory does not exist");
            return;
        }

        // Scan the directory and print file names
        try (FileScanner fileScanner = new FileWalker(directory)) {
            while (fileScanner.hasNext()) {
                File file = fileScanner.nextFile();
                System.out.println(file.getName());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}

class FileWalker implements java.io.FileWalkIterator {

    private java.io.FileWalker walker;

    public java_41665_FileScanner_A07(java.io.File rootDirectory) {
        this.walker = new java.io.FileWalker(FileVisitOption.FOLLOW_LINKS) {
            @Override
            public boolean shouldVisit(java.io.File file) {
                // Only visit files and not directories
                return file.isFile();
            }
        };
        walker.start(rootDirectory);
    }

    @Override
    public boolean hasNext() {
        return walker.hasNext();
    }

    @Override
    public File nextFile() {
        return walker.nextFile();
    }

    @Override
    public FileVisitOption nextOption() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean hasNext(java.nio.file.DirectoryIterator.LinkHandlingOption linkHandlingOption) {
        return walker.hasNext();
    }

    @Override
    public File next() {
        return walker.next();
    }

    @Override
    public void end() {
        walker.end();
    }
}