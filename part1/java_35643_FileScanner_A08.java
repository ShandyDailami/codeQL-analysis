import java.io.File;
import java.util.Scanner;

public class java_35643_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();
        scanner.close();

        File dir = new File(dirPath);

        if (dir.exists() && dir.isDirectory()) {
            File[] files = dir.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        // Get the file's name and extension
                        String fileName = file.getName();
                        String extension = fileName.substring(fileName.lastIndexOf("."));

                        // Check if the file's name is unique
                        for (File f : files) {
                            if (file.isSameFile(f)) {
                                break;
                            }
                            if (file.getName().equals(f.getName())) {
                                System.out.println("The file " + fileName + " is not unique. Its extension is " + extension);
                                return;
                            }
                        }
                        System.out.println("The file " + fileName + " has an extension of " + extension);
                    }
                }
            } else {
                System.out.println("There are no files in the directory.");
            }
        } else {
            System.out.println("The specified directory does not exist.");
        }
    }
}