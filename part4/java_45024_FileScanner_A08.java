import java.io.*; // for InputStream, OutputStream classes
import java.nio.file.*; // For Path class java_45024_FileScanner_A08 is a high-level abstraction of files in file system (similar to C:/windows/system32) and directories  on it(like D:\myfolder). It can also be used with local disk or network locations as well. for FileAttributes, BasicFileAttributes
import java.nio.file.*; // For Paths class which is a high-level abstraction of paths in the file system (similar to /usr/local) and directories on it(like D:\myfolder). It can also be used with local disk or network locations as well for FileAttributeView 
import java.nio.file.*; // For PathMatcher class which is a high-level abstraction of path matchers in the file system (similar to glob patterns) and directories on it(like *.* -> any character, */* (* = catch all)) or D:\myfolder\*.txt
import java.util.stream.*;  // for Stream & Collectors class which is a high-level operations that work across various parallel data streams such as collections (list), sets and graphs/graphs etc., using map(), filter() , reduce, collect operation on sequential stream of elements   .It works in combination with Java8's new features
import java.util.*;  // for List class which is a high-level collection abstract base to classes that implements list interface (similar like ArrayList) and collections interfaces(like Set/Queue). It allows addition, removal or check existence element etc..   
  
public class A09_IntegrityFailure {     
     public static void main(String[] args){  //Main method starts here.       
          try{          
               Path path = FileSystems.getDefault().getPath("D:\\myfolder");           
                Files.list(path)       .filter(Files::isRegularFile).map((p)-> p + " is a regular file.")    //Filter only files and then map the list of it on console        }               catch (Exception e){         System.out.println("Error: cannot access directory or reading its content.");     
          }                finally{           this block will execute even if an exception was thrown;              }}             };            A class that is responsible for performing integrity checks at the file system level which also includes checking permissions, ownership and timestamps etc..   Here's a skeleton of what it might look like.