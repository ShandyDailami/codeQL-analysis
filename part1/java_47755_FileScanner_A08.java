import java.io.*; // for the BufferedReader and InputStream classes that can read files into strings or arrays of characters respectively  
// import necessary Java packages from other file if any are required by your program such as: IOException, FileNotFoundException etc;   
public class java_47755_FileScanner_A08 { 
     public static void main(String[] args) throws Exception{ //main method is a good practice for starting execution of the code. It helps to break down complex problems into smaller and manageable parts which makes it easier to debug, read etc;  
         try (BufferedReader br = new BufferedReader(new FileReader("exampleFile.txt"))) { 
             //The 'with' statement in Java8 can be used for resource management where you want the underlying resources available when necessary or explicitly close them once done with them to prevent memory leaks;  
                String line ;   
                 while ((line = br.readLine()) != null){     /* read a whole row */  //while loop is good practice over reading multiple rows at one time, it ensures that all data are processed and no more than needed due limit set by the file size or buffer capacity;  
                     System.out.println(line);    }      br .close();//always close your resources in a finally block to prevent memory leaks.;     //Prints each line of text from 'exampleFile' until there is nothing left  ;} catch (IOException e) {e.printStackTrace()  
             /* Your code will be here */    }catch(Exception ex){ex.getmessage();/*Your exception handling*/}}//This catches all exceptions and prints out the error message;     //Use appropriate try/catche to handle your own custom errors instead of using e or println in catch block, make sure you have a meaningful description for it;} 
 }   */`}