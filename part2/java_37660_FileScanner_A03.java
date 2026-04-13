import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class java_37660_FileScanner_A03 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the directory path:");
        String path = scanner.nextLine();

        List<String> fileList = getFileList(new File(path));

        List<File> fileListObj = new ArrayList<>();
        for (String fileName : fileList) {
            fileListObj.add(new File(fileName));
        }

        fileListObj.sort((file1, file2) -> file1.getName().compareTo(file2.getName()));

        for (File file : fileListObj) {
            System.out.println(file.getName());
        }
    }

    private static List<String> getFileList(File directory) {
        List<String> fileList = new ArrayList<>();
        for (File file : directory.listFiles()) {
            if (file.isFile()) {
                fileList.add(file.getAbsolutePath());
            } else if (file.isDirectory()) {
                fileList.addAll(getFileList(file));
            }
        }
        return fileList;
    }
}