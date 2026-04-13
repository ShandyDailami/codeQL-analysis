import java.io.*; // For handling file I/O operations and exception processing  
public Class Main { 
    public static void main(String[] args) throws IOException{    
        FileScanner fs = new MyFileScanner();            
            while (fs.hasNext())               
                    System.out.println("Access to the file: " + fs.next());   // This is a line of code that could be potentially dangerous, but we'll just print it out for now           }  catch(Exception e){System.err...}            finally{fs.close();}}