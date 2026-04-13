import java.io.*;

public class java_11725_FileScanner_A08 {
    public static void main(String[] args) {
        File file = new File(".");

        FileScanner fileScanner = new FileScanner() {
            @Override
            public File[] listFiles() {
                return file.listFiles();
            }

            @Override
            public FileVisitResult visitFile(File file, BasicFileAttributes attrs) throws IOException {
                // Check if the file is a directory
                if (file.isDirectory()) {
                    return FileVisitResult.CONTINUE;
                }

                // Check if the file is a hidden file
                if (file.getName().startsWith(".")) {
                    return FileVisitResult.CONTINUE;
                }

                // Check if the file is not a text file
                if (!file.getName().endsWith(".txt")) {
                    return FileVisitResult.CONTINUE;
                }

                // Check if the file is not a regular file
                if (!file.canRead()) {
                    return FileVisitResult.CONTINUE;
                }

                // Check if the file size is too large
                if (file.length() > 1000) {
                    return FileVisitResult.CONTINUE;
                }

                // Check if the file is not in the correct directory
                if (!file.getParentFile().equals(file)) {
                    return FileVisitResult.CONTINUE;
                }

                // File is valid, print its name
                System.out.println(file.getAbsolutePath());
                return FileVisitResult.TERMINATE;
            }
        };

        fileScanner.visit(file, new BasicFileAttributes(0));
    }
}