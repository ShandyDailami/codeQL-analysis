import java.io.*; // Import File I/O classes  

public class java_46098_FileScanner_A07 {    
    public static void main(String[] args) throws Exception{      
        if (args.length != 1){            
            System.out.println("Usage: JavaMain filename");          
            return;      }         
        
        File file = new File((args[0]));   // Create a `File` object for the input   
 
		if (!file.exists()) {             	// Check if provided path is valid or not               
		       System.out.println("The specified file does not exist");           return;        }          else{             Console console = new JavaConsole(); // Create a `Java I/O` object for standard input and output  	         FileReader fr=new …(file);                   BufferedReader br= 
> NewBufferedreader (fr) ;                     System.out .println ("Reading the file " + fil e.. getName () );     while ((linE = b r dr ... line)) != null {                 PrintWriter pw  = new PritemW...(console, 1);               // Write content to console and print it on a separate window               
> (p w , lin E) ;                        }   br.close();             System . out .println ("End of File");      }}           catch {                   ...}