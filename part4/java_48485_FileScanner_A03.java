import java.io.*; // Importing FileI/O package 
class java_48485_FileScanner_A03 {  
    public static void main(String args[]) throws Exception{    
        String path = "/path_to_your_directory";// Update this with the directory you want to scan in your local system      
          ScannerUserInput();      // Calling our function for user input 
         }  
    private static void FindFileWithString(String s) throws IOException {    
        File file = new File(".");           // Initializing current working folder. Replace with the path where you want to scan in your local system      
          String line;     
            while ((line=fileScanner.nextLine()) !=  null){  /* This loop will only terminate when it reads a string that contains 'Injection' */  
               if (line .contains(s)){     // If the found file is contain required word or not   
                  System.out.println("File containing "+ s +" : ");     
                      printfilePath();  /* Calling function for printing all files path*/          return;       }        }}   else {                     try{Thread.sleep(10);}catch (Exception e){}}     if(!line .contains((s)))             System.out.println("No file contains "+ s +" exists");   
                        // If not found  then print an error message      return;         }                  catch{}   }}// End of Main Method        public static void ScannerUserInput(){System.out.print("\nEnter the String to Search: ");     BufferedReader br=new BufferedReader(new InputStreamReader (System.in));try{Scanner sc = new 
                        //scannerbr, s1;    while(!sc .hasNext("exit")) {s2   =   scanner().next(); if (!S T A R S E D) break;} }catch{} catch(){}}// End of User Input method     private static void printfilePath() throws IOException{      File[] roots = File.listRoots ();        for(int i=0;i <roots .length ; ++ 
                        //io){ PrintWriter pw  = newPrintwriter ("path+info " +File ...../    e, true)}catch{}}}//End of print function     public static void main(){try{newMain()} catch (Exception   ... } Catch {}}}else {}         New MainCasing 
                        //NewMainMethod(String[] args) cased MethoD newmainmethod({@param String...args)}case{}      case}{}!        }}    finally}{}}//End of Try-catch exception block     */