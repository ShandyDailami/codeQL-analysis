import java.io.*; // Import necessary classes into this scope (File) 
class java_49971_FileScanner_A01 {  
    public static void main(String[] args){    
        File directory = new File(".");      /* represent current folder */         
         try{          
            String filesInDirectory[] = directory.list();       /* list all the file names in a particular path*/               
             for (int i = 0; i < filesInDirectory.length; ++i) {   //iterate through each element of array     
                 File f= new File(filesInDirectory[i]);  //getting access to one individual object      
                  if(!f.isHidden() && !((new File("./" + f.getName())).canExecute())){     /*exclude hidden files and those not executable */        
                     System.out.println ("File Name: "+(i + 1) + "-> "+  (filesInDirectory[i]));    // print out file names     
                  }         
              }            
            if (!directory.isHidden() && !((new File("./" + directory.getName())).canExecute())){  /*exclude hidden folders and those not executable */    
                 System.out.println ("Directory Name: "+ (i + 1)  + "-> "+  ((File)filesInDirectory[0]));       // print out Directory name     
             }         else {          if (!((new File("./" + directory.getName())).canExecute())){  /*exclude hidden folders and those not executable */    System.out.println ("No file or folder named " +  ((File)filesInDirectory[0]));     //print out no such case     
            }             }} catch (Exception e){          println(e);   };                   try { Thread . sleep (. 5 ) ;}} while(. true );       /* create delay for better visualization */    });        setDefaultCloseOperation ((JFrame.EXIT_ON_CLOSE));     // exit application after closing the window        
      }          protected Main (){ throw new UnsupportedOperationException();}            public static void main(String[] args ) {throw new UnsupportedOperationException() ;}} /*create a test class that calls this method*/ };};  });});    try{Thread.sleep(.5); }}catch{}while (.true ); }