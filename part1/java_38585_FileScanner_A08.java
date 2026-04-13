import java.io.File;
import java.util.Iterator;
import java.util.Scanner;

public class java_38585_FileScanner_A08 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory:");
        String dirPath = scanner.nextLine();

        File dir = new File(dirPath);
        if (!dir.exists()) {
            System.out.println("The directory does not exist");
            return;
        }

        File[] files = dir.listFiles();
        if (files == null) {
            System.out.println("No files in the directory");
            return;
        }

        Iterator<File> it = new Iterator<File>() {
            int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < files.length && (files[currentIndex] == null || !files[currentIndex].isFile());
            }

            @Override
            public File next() {
                return files[currentIndex++];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };

        System.out.println("Files in the directory:");
        while (it.hasNext()) {
            File file = it.next();
            System.out.println(file.getName());
        }

        scanner.close();
    }
}