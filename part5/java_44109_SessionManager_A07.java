// Import necessary classes from spring package for SessionFactory, TransactionManager etc.. (No need of explicit import as it's part of core API)  
import org.springframework.context.ApplicationContext; // For Application context loading through Java configuration files or XML configurations and other similar features provided by Spring Framework 1-Core Libraries   
// Import necessary classes from spring package for SessionFactory, TransactionManager etc.. (No need of explicit import as it's part of core API)  
import org.springframework.transaction.TransactionManager; // For transaction management in the context    
      
public class java_44109_SessionManager_A07 { 
      public static void main(String args[]){   
           ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");// Load Spring Configuration file (Annotated or XML)  
           
          /* Create session factory */ // No need of explicit import as it's part of core API, and we use only standard libraries    
            SessionFactory sf  = ctx.getBean(SessionFactory.class); 
            
           /* Use the above created `sessionfactory` to get a new transaction manager*/  
            TransactionManager txm = (TransactionManager)ctx.getBean("transactionManager");    // Provide bean name in context    
              System.out.println("\n SessionFactory Bean: "+sf);  // print session factory for verification      .bean= sf,print out to verify it's not null      
           /* Start a new transaction */   txm.getTransaction(null).begin();    PrintWriter log =  ctx.getBean("log",PrintWriter.class) ;// get Logging object from context     //Spring will manage the logging operation in this point .It provides support for writing to console and other streams/files as well
           System.out.println("\n Transaction bean: "+txm);  PrintStream out = ctx.getBean("log",PrintWriter.class) ;// get Logging object from context //Spring will manage the logging operation in this point .It provides support for writing to console and other streams/files as well
           log.println("\n Inside transaction ...");    System.out.print( "\tInside begin()..");     txm.getTransaction(null).begin();   println("inside of the session...")  sf .openSession().save("Employee1" + i );       // Save entity into database, no need to call commit explicitly in a transaction as it's handled automatically
            System.out.println("\n Transaction Ended");    txm.getTransaction(null).commit();     log.close() ;// close the logging stream  after completion of operation   } catch (Exception e) {e .printStackTrace ()}}`; // handle exceptions in a try-catch block
              System.out.println("\n Application Context Closed")    ctx.close(), PrintWriter out =ctx.getBean("log",PrintStream..class);// close the context and get logging stream object  for verification   println( "\tClosing logs ..." ) ; // prints log message to verify correct closing of resources
             System .out!println ( " \n Exiting Main Method"); }    return; }}`