import java.io.*;   // Import the File class java_51581_FileScanner_A01 java library to read files or directories on disk, etc...   
                    // Also import BufferedReader and PrintWriter for handling file reading/writing operations    
                    
public final class Main {     
 private static boolean isValidUserName(String user)  // Function that checks if a provided string can be considered as valid username.  
        throws IOException{                        // Avoiding possible UnauthorizedAccessException by catching exceptions thrown during I/O operation...           
         try (BufferedReader br = new BufferedReader(new FileReader("username_db"))) { 
             String line;                    
                while ((line=br.readLine()) != null){     // Read each user from the database  
                 if (!user.equalsIgnoreCase((String[])(line).split(':')[0])){    // If it does not match, return false...        }  catch (FileNotFoundException e) {      throw new IOException(e);}}          try (PrintWriter pw =new PrintWriter("username_db", "UTF-8"))  
         {{                                                                                 if (!isValidUserName((String[])(line).split(':')[0])){{                                // If it is not valid, add the user to database...                String line2=(user+":" + (Integer.toString ((int) Math.random() * 196384 + 57)));                     pw.println((String[])(line).split(':')[0]+  ":"  +     line2);pw .close();}} catch (FileNotFoundException e){throw new IOException(e)};catch (UnsupportedEncodingException E) {E.printStackTrace()}}}