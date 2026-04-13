import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Scanner;

public class java_06830_FileScanner_A07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory:");
        String dir = scanner.next();

        File startingDirectory = new File(dir);

        printFiles(startingDirectory, "");
    }

    private static void printFiles(File dir, String indent) {
        File[] files = dir.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String name) {
                return new File(dir, name).isFile();
            }
        });

        for (File file : files) {
            System.out.println(indent + file.getName());

            File[] subFiles = file.listFiles(new FilenameFilter() {
                public boolean accept(File dir, String name) {
                    return new File(dir, name).isDirectory();
                }
            });

            printFiles(file.getAbsoluteFile(), indent + "  ");

            for (File subFile : subFiles) {
                printFiles(subFile.getAbsoluteFile(), indent + "  ");
            }
       <｜begin▁of▁sentence｜>		}
		}
	}
}