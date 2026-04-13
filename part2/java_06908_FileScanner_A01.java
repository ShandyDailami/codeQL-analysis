import java.io.File;
import java.util.Scanner;

public class java_06908_FileScanner_A01 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] restrictedFiles = directory.listFiles((dir, name) -> name.endsWith(".restricted"));

            if (restrictedFiles != null) {
                for (File file : restrictedFiles) {
                    String filename = file.getName();
                    String newFilename = filename.replace(".", "_");
                    file.renameTo(new File(file.getParent() + "/" + newFilename));
                    System.out.println("File renamed: " + filename);
               
                }
            } else {
                System.out.println("No restricted files found in the directory");
            }

        } else {
            System.out.println("Directory does not exist");
        }
    }
}