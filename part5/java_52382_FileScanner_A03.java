import java.io.*;  // Import required Java package

import java.util.regex.*;   // Required to use regex in our program (For Pattern and Matcher)



public class java_52382_FileScanner_A03 {    // Main Class Declaration     

     public static void main(String[] args){       //Main Method  for execution point of the Program         

         String directoryPath = "/path/to/directory";   //Directory to be scanned          

         Pattern patternToMatch=Pattern.compile("regularExpression");    // Regular Expression that we want our file name and content against    

                 

             try (FileScanner scanner =  new com.sun.nio.fs.FilesystemProvider().newFileScanner(directoryPath, StandardOpenOption.READ)) {  // Try with resources for handling File Scanner     

                 while (scanner.hasNext())    {   // While Loop to iterate through all the files present in a directory         

                     String fileName = scanner.next().toString();         // Reading and storing name of each individual document/file       

                       if(patternToMatch.matcher(fileName).find()){     // Checking whether our regular expression matched or not, for example: "regularExpression" is used to match files with .txt extension  (You can replace it)      

                         File file = new java.io.File((directoryPath + "/")+ fileName);    // Construct a Java Files object of the specific path and name  

                           System.out.println("Reading contents from: " +  file );         

                               try (BufferedReader br =  new BufferedReader(new FileReader(file)))  {     //Try with resources for handling buffer reader     

                                   String line;                     // Declare a string to hold each read text lines   

                                    while ((line = br.readLine()) != null)       // While loop reading the file content by one record at time       

                                         System.out.println(line);          // Prints Each Line of File     with this line in console     

                                 }  catch (IOException e){               

                                   e.printStackTrace();               // Catch block for handling exception      

                                }                     

                        }}catch (Exception ex) {                   

                         System.out.println(ex);                   // Exception Handling     to handle any Exceptions  

                     }            });  try ... catch in Java is used when you want a program or script, if there's an error during the execution of code inside it then this block will be executed which helps us understand where exactly our exception happened.    The 'try-catch'-block allows to handle exceptions while executing them as well provides two parts: one for handling normal flow control and other is used when errors occur at any point in program