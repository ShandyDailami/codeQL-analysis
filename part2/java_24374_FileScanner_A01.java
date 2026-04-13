import java.io.File;
import java.security.AccessController;
import java.security.Access;
import java.nio.file.*;
import java.nio.file.attribute.UserAttributes;
import java.util.stream.Stream;

public class java_24374_FileScanner_A01 {
    private static final String DIRECTORY_PATH = "/path/to/directory";

    public static void main(String[] args) {
        File directory = new File(DIRECTORY_PATH);
        AccessControlContext accContext = AccessControlContext.newInstance(directory.toPath());

        try (Stream<Path> paths = Files.walk(directory.toPath(), 1)) {
            paths.forEach(path -> {
                AccessControlAction<? super Path> action = accessController -> {
                    UserAttributes userAttributes = accessController.getUserAttributes();
                    boolean isWritable = userAttributes.intersect(AccessControlContext.class::getMethod("getFileAlterWriteAccess", Path.class, AccessMode.class).invoke(accessController, path, null));
                    return !isWritable;
                };

                if (Files.isDirectory(path, LinkOption.NOFOLLOW_LINKS)) {
                    File file = path.toFile();
                    AccessControlAction<? super File> fileAction = accessController -> accessController.getFileAttributes(file.toPath(), LinkOption.NOFOLLOW_LINKS).creationTime().compareTo(Files.getLastModifiedTime(path)) < 0;
                    action = (accessController, path) -> fileAction.invoke(accessController, file);
                }

                AccessControl.ControlAction<? super Path> controlAction = action;
                controlAction = (accessController, path) -> {
                    System.out.println("File " + path + " is not writable by the current user");
                    return controlAction.invoke(accessController, path);
                };

                controlAction.invoke(AccessControl.class.getDeclaredMethod("checkAccess", AccessControl.class, Path.class).getDeclaredAnchor(), paths.iterator().toArray());
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}