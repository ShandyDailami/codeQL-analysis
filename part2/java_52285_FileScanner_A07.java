import java.io.*; // importing necessary classes 
implements FilenameFilter {// defining an interface to filter files by name and type  
    public static void main (String args[]){    
        File file = new File(".");      
	FileScanner scan;     
         if(file.canRead() && file.isDirectory()) // checking whether we have the right permission 
            {         
                System.out.println ("Looking for files in current directory");          
             String userInput="";    
                 do{       
                     try  
                      {    Scanner scan_string = new Scanner(System.in);      //getting input from the user 
                         System.out.print("Enter search string: ");      
                          userInput  =scan_string .nextLine();              
                           if (userInput == null) break;                   
                      }     catch (Exception e){                            
                        printStackTrace(e);                                 //exception handling  
                     }        
                         System.out.println("Searching for files with names containing :"+ userInput ); 
                          scan=new FileScanner();   
                           boolean b =scan .findFilesWithNameContaining (userInput, this,".");//using filter method to find the file name    
                              if(b) System.out.println ("File found"); else         //displaying appropriate message  
                                  {         
                                      System.out.println("No files with names containing :"+ userInput );      }  }) ;                   while (true);            }}//closes the loop end     )    };                      });                  try{new FileScanner();}catch(Exception e){System . out . println ("Error " +e)