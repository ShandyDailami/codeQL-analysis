import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class java_35073_FileScanner_A01 {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a directory path:");
        String directoryPath = input.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists()) {
            String[] fileList = directory.list();
            if (fileList != null) {
                Arrays.sort(fileList);
                for (String fileName : fileList) {
                    File file = new File(directoryPath + "/" + fileName);
                    System.out.println(file.getAbsolutePath());
                }
            } else {
                System.out.println("No files in this directory.");
            }
        } else {
            System.out.println("Directory does not exist.");
        }
    }
}