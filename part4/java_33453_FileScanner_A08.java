import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class java_33453_FileScanner_A08 {
    public static void main(String[] args) throws IOException {
        String directoryPath = "/path/to/directory";  // replace with your directory path
        File directory = new File(directoryPath);
        printFilesSortedByModificationTime(directory);
    }

    private static void printFilesSortedByModificationTime(File directory) throws IOException {
        File[] files = directory.listFiles();
        if (files != null) {
            List<File> sortedFiles = Arrays.stream(files)
                    .sorted((file1, file2) -> {
                        if (file1.isDirectory() && file2.isFile()) {
                            return -1;
                        } else if (file2.isDirectory() && file1.isFile()) {
                            return 1;
                        } else if (file1 instanceof File && file2 instanceof File) {
                            BasicFileAttributes attr1 = Files.readAttributes(Paths.get(file1.getPath()), BasicFileAttributes.class);
                            BasicFileAttributes attr2 = Files.readAttributes(Paths.get(file2.getPath()), BasicFileAttributes.class);
                            return attr1.lastModifiedTime().compareTo(attr2.lastModifiedTime());
                        } else {
                            return file1.lastModified() > file2.lastModified() ? 1 : -1;
                        }
                    })
                    .collect(Collectors.toList());

            for (File file : sortedFiles) {
                if (file.isFile()) {
                    Path path = Paths.get(file.getPath());
                    BasicFileAttributes attr = Files.readAttributes(path, BasicFileAttributes.class);
                    LocalDateTime lastModified = attr.lastModifiedTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
                    System.out.println(file.getName() + ": " + lastModified.format(DateTimeFormatter.ISO_DATE_TIME));
                }
            }
        }
    }
}