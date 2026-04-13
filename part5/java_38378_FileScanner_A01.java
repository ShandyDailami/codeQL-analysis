import java.io.File;
import java.util.Scanner;

public class java_38378_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the path:");
        String path = scanner.nextLine();

        File file = new File(path);

        if (file.exists()) {
            if (file.isDirectory()) {
                System.out.println("Directory: " + file.getAbsolutePath());

                String[] filesInDirectory = file.list();

                if (filesInDirectory != null) {
                    for (String fileName : filesInDirectory) {
                        File innerFile = new File(file.getAbsolutePath() + "/" + fileName);

                        if (innerFile.isFile() && innerFile.canRead()) {
                            System.out.println("File: " + innerFile.getAbsolutePath());
                        } else if (innerFile.isDirectory()) {
                            System.out.println("Directory: " + innerFile.getAbsolutePath());
                        }
                    }
                }
            } else if (file.isFile() && file.canRead()) {
                System.out.println("File: " + file.getAbsolutePath());
            } else {
                System.out.println("Not a readable file or directory.");
            }
        } else {
            System.out.println("No such file or directory.");
        }
    }
}