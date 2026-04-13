import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class java_01327_FileScanner_A01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String dirPath = scanner.nextLine();
        System.out.println("Enter the extension to exclude:");
        String ext = scanner.nextLine();

        FileScanner fileScanner = new FileScanner(dirPath, ext);
        List<String> fileList = fileScanner.getFileList();

        for (String fileName : fileList) {
            System.out.println(fileName);
        }

        scanner.close();
    }
}

class FileScanner {
    private String dirPath;
    private String ext;

    public java_01327_FileScanner_A01(String dirPath, String ext) {
        this.dirPath = dirPath;
        this.ext = ext;
    }

    public List<String> getFileList() {
        List<String> fileList = new ArrayList<>();
        File rootDir = new File(dirPath);
        getFileListRecursive(rootDir, fileList);

        return fileList;
    }

    private void getFileListRecursive(File dir, List<String> fileList) {
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile() && !file.getName().endsWith(ext)) {
                    fileList.add(file.getAbsolutePath());
                } else if (file.isDirectory()) {
                    getFileListRecursive(file, fileList);
                }
            }
        }
    }
}