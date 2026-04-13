import java.io.File;
import java.io.FileFilter;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class java_27433_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();

        File directory = new File(dirPath);

        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("Invalid directory path.");
            return;
        }

        File[] hiddenFiles = directory.listFiles(new FileFilter() {
            @Override
            public boolean accept(File pathname) {
                // Return true to include hidden files
                // Return false to exclude them
                return pathname.isHidden();
            }
        });

        if (hiddenFiles == null) {
            System.out.println("No hidden files found in the directory.");
            return;
        }

        Arrays.sort(hiddenFiles);

        System.out.println("Hidden files in the directory:");
        for (File file : hiddenFiles) {
            System.out.println(file.getAbsolutePath());
        }

        System.out.println("Enter the name of the file you want to access (or 'quit' to exit):");
        String fileName = scanner.nextLine();

        while (!fileName.equals("quit")) {
            File targetFile = new File(directory, fileName);

            if (!targetFile.exists() || targetFile.isDirectory()) {
                System.out.println("Invalid file name or path.");
                break;
            }

            try (Scanner fileScanner = new Scanner(targetFile)) {
                while (fileScanner.hasNextLine()) {
                    String line = fileScanner.nextLine();
                    System.out.println(line);
                }
            } catch (FileNotFoundException e) {
                System.out.println("Access denied for file: " + targetFile.getAbsolutePath());
            }

            System.out.println("Enter the name of the file you want to access (or 'quit' to exit):");
            fileName = scanner.nextLine();
        }

        scanner.close();
    }
}