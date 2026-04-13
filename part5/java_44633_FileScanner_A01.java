import java.io.*; // Import File and IO stream classes  
public class java_44633_FileScanner_A01 {    
    public static void main(String[] args) throws Exception{       
            String directoryPath = ".";         
            	File dir = new File(directoryPath);             		          			     									 															       if (dir.exists())                            	    System.out.println("Directory exists:"); else                              	  System.err.println("Given Directory does not exist!");                       }                   catch (Exception e) {         	System.err.printf("%s\n",e );   }}