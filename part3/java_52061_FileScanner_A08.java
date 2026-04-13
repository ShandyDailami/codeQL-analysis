import java.io.*; // Import required classes  
class java_52061_FileScanner_A08 {   
     public static void main(String[] args) throws IOException{         
           if (args.length == 0){              
              System.out.println("Please provide a directory path as argument");            
                  return;            }  else         BufferedReader reader = new BufferedReader(new FileReader(args[0]));   //Reading file from console input    String line ;           while((line=reader.readLine())!=null)          System.out.println("\n Reading Line...\n" + (++i%2==1 ? "Odd lines:" : "\nEven Lines:")+( ++j % 3 == 0?"third odd":"even"));        
           } else {             BufferedReader reader = new BufferedReader(new FileReader("C:/Users/User/" ));          //If file path is provided from command line, reading the input as per that    String s;            while((s=reader.readLine())!=null)  System.out.println("\n Command Line Reading..."+ (++k %2==1?"Odd lines":"Even Lines") + ":"  + ++l);     }  
           reader.close();         }} //End of Program