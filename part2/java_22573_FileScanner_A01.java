import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_22573_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = input.nextLine();

        File directory = new File(path);

        if (directory.isDirectory()) {
            System.out.println("Files with 'txt' extension:");
            try {
                FileScanner(directory);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Please enter a valid directory path.");
        }

        input.close();
    }

    private static void FileScanner(File directory) throws FileNotFoundException {
        File[] files = directory.listFiles();

        for (File file : files) {
            if (file.getName().endsWith(".txt")) {
                System.out.println(file.getName());
            }
        }
    }
}