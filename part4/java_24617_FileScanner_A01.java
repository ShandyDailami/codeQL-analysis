import java.io.File;
import java.util.Scanner;
import java.util.Iterator;

public class java_24617_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String directoryPath = scanner.nextLine();

        File directory = new File(directoryPath);

        if (directory.exists() && directory.isDirectory()) {
            File[] files = directory.listFiles();
            if (files != null) {
                Iterator<File> iterator = new Iterator<File>() {
                    int index = 0;

                    @Override
                    public boolean hasNext() {
                        return index < files.length && !files[index].isDirectory();
                    }

                    @Override
                    public File next() {
                        return files[index++];
                    }

                    @Override
                    public void remove() {
                        throw new UnsupportedOperationException();
                    }
                };

                while (iterator.hasNext()) {
                    File file = iterator.next();
                    // Broken access control: Read file content
                    try {
                        Scanner fileScanner = new Scanner(file);
                        while (fileScanner.hasNextLine()) {
                            String line = fileScanner.nextLine();
                            System.out.println(line);
                        }
                        fileScanner.close();
                    } catch (Exception e) {
                        System.out.println("Error reading file: " + file.getName());
                    }

                    // Broken access control: Change file name
                    try {
                        file.renameTo(new File(file.getPath() + ".bak"));
                        file.renameTo(new File(file.getPath().substring(0, file.getPath().length() - 4) + ".txt"));
                    } catch (Exception e) {
                        System.out.println("Error renaming file: " + file.getName());
                    }

                    // Broken access control: Delete file
                    try {
                        file.delete();
                    } catch (Exception e) {
                        System.out.println("Error deleting file: " + file.getName());
                    }
                }
            } else {
                System.out.println("No files found in the directory");
            }
        } else {
            System.out.println("Directory does not exist or is not a directory");
        }

        scanner.close();
    }
}