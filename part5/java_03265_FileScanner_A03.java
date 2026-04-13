import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_03265_FileScanner_A03 {
    public static void main(String[] args) {
        try {
            System.out.println("Enter the directory path:");
            Scanner scanner = new Scanner(System.in);
            String dirPath = scanner.nextLine();
            scanner.close();

            File dir = new File(dirPath);

            if (dir.exists() && dir.isDirectory()) {
                String[] fileList = dir.list();

                if (fileList != null) {
                    for (String fileName : fileList) {
                        File file = new File(dirPath + "/" + fileName);

                        if (file.isFile() && file.canRead()) {
                            Scanner fileScanner = new Scanner(file);

                            while (fileScanner.hasNextLine()) {
                                String line = fileScanner.nextLine();
                                System.out.println(line);
                            }
                            fileScanner.close();
                        }
                    }
                } else {
                    System.out.println("No files in the directory.");
                }
            } else {
                System.out.println("Directory does not exist.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }
    }
}