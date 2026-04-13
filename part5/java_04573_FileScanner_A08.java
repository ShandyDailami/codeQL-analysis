import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class java_04573_FileScanner_A08 {
    public static void main(String[] args) throws FileNotFoundException {
        File directory = new File(".");
        int totalLines = 0;

        // Use recursion to scan the directory and its subdirectories
        countLinesRecursively(directory, new File(directory.getPath() + "/counted_lines.txt"));

        // Print the total lines count
        System.out.println("Total lines: " + totalLines);
    }

    private static void countLinesRecursively(File directory, File countedLinesFile) throws FileNotFoundException {
        if (directory.listFiles() == null) {
            return;
        }

        for (File file : directory.listFiles()) {
            if (file.isFile() && file.getName().endsWith(".txt")) {
                Scanner scanner = new Scanner(file);
                int linesCount = 0;

                // Count lines in file
                while (scanner.hasNextLine()) {
                    linesCount++;
                    scanner.nextLine();
                }

                // Append lines count to file
                try (Scanner writer = new Scanner(countedLinesFile)) {
                    while (writer.hasNextInt()) {
                        writer.nextInt();
                    }
                    writer.println(linesCount);
                }

                totalLines += linesCount;
            } else if (file.isDirectory()) {
                countLinesRecursively(file, countedLinesFile);
            }
        }
    }
}