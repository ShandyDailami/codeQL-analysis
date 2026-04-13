import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_30596_FileScanner_A08 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = input.nextLine();
        System.out.println("Enter the file name:");
        String fileName = input.nextLine();
        System.out.println("Enter the file extension:");
        String fileExtension = input.nextLine();

        File directory = new File(directoryPath);

        try {
            FileScanner(directory, fileName, fileExtension);
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        } finally {
            input.close();
        }
    }

    public static void FileScanner(File directory, String fileName, String fileExtension) throws FileNotFoundException {
        File[] listOfFiles = directory.listFiles();

        for (File file : listOfFiles) {
            if (file.isFile() && file.getName().endsWith(fileExtension)) {
                if (file.getName().startsWith(fileName)) {
                    System.out.println("Found file: " + file.getAbsolutePath());
                }
            }
        }
    }
}