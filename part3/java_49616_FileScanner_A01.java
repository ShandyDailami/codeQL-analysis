import java.io.*;
import java.nio.file.*;
import java.security.*;

public class java_49616_FileScanner_A01 {   // Program starts here!
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException{    
        String directoryPath = "/path/to/" ;  /* Your Directory Path */            
         SecurityManager securityManager =  new SecurityManager();         
            ProtectedFileSystem protectedFileSystem  =   (ProtectedFileSystem ) FileSystems.newInstance(securityManager);    // creating a file system instance with the same settings as JVM's default  FILESYSTEM...               
             Path path =Paths .from URI ("file:/" + directoryPath );      // constructing our local   PATH object....      
        try (DirectoryStream<Path> dirs =  protectedFileSystem.newDirectoryStream(path,  ".*")) {          /* creating a Directory Stream that will traverse the file system from here */           for (final Path entry : dirs)    {} // We are not interested in files and directories...
        } catch (InvalidPathException e){                  
             System . err. println ("Directory doesnt exist or cannot access: " + directorypath);  /* Handle exceptions as needed ......   if you want a random exception, uncomment the line below ..            throw new IOException(e );     // We are not interested in files and directories...        } catch (UnsupportedOperationException e) {
          System.out.println("The operation is UnSupported by this file system");    /* Handle exceptions as needed ......   if you want a random exception, uncomment the line below ..            throw new IOException(e );     // We are not interested in files and directories...        } catch (IOException e) {
          System.out.println("File or Directory operation failed: " + directorypath); /* Handle exceptions as needed ......   if you want a random exception, uncomment the line below ..            throw new IOException(e );     // We are not interested in files and directories...        }  catch (NoSuchAlgorithmException e) {
          System.out.println("Security operation failed: " + directorypath);    /* Handle exceptions as needed ......   if you want a random exception, uncomment the line below ..            throw new IOException(e );     // We are not interested in files and directories...        }  catch (Exception e) {
          System.out.println("An unexpected error has occurred: " + directorypath); /* Handle exceptions as needed ......   if you want a random exception, uncomment the line below ..            throw new IOException(e );     // We are not interested in files and directories...       }  */      println ("The file scanner example ended successfully.");
    }}