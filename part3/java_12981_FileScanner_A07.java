import java.io.File;
import java.util.Scanner;

public class java_12981_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter directory path: ");
        String directoryPath = input.nextLine();
        File directory = new File(directoryPath);

        if (directory.exists()) {
            File[] listOfFiles = directory.listFiles();

            if (listOfFiles != null) {
                for (File file : listOfFiles) {
                    if (file.isFile() && file.canRead() && !file.isHidden() && file.getName().endsWith(".txt")) {
                        System.out.println("Found file: " + file.getAbsolutePath());
                    }
                }
            }
        } else {
            System.out.println("Directory does not exist.");
        }
    }
}