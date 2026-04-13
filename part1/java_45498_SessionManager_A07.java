import javax.servlet.*;
import java.io.*;
// Import required classes from the servlets package to enable session management, HttpServletRequest & SessionListener interface etc...  
public class java_45498_SessionManager_A07 implements ServletContextListener {
    // List of books currently in stock (this is a dummy data source) – you should replace this with your real ones.     
     private static String[] BOOK_STOCK = {"Book A", "Book B"};  
        
        public void contextInitialized(ServletContextEvent sce){    //This method gets called when the web server starts and initializes a session – it's just an example, you should replace this with your real implementation.     
            System.out.println("Session Initialised");                }  
        
        public void contextDestroyed(ServletContextEvent sce){    //This method gets called when the web server stops or de-initializes a session – it's just an example, you should replace this with your real implementation..     
            System.out.println("Session Destroyed");               }    
        
        public void requestInitialized(ServletRequestEvent srse){   //This method gets called every time there is any client making a new HTTP Request – it's just an example, you should replace this with your real implementation..     
            HttpServletRequest httpReq = (HttpServletRequest)srse.getRequest();   
             String bookName =  httpReq.getParameter("book");   //Fetching the name of a requested Book – it's just an example, you should replace this with your real implementation..     
            if(Arrays.asList(BOOK_STOCK).contains(bookName)){     //Check whether book is available in stock or not (it’ll be replaced by the actual data source)   
                System.out.println("Book Available");         }   else{ 
             HttpServletResponse httpResp = (HttpServletResponse)srse.getResponse();     
              try {httpResp.sendError(401,"Unauthorized Access!");}catch(IOException e){e.printStackTrace();}}          //If not available, send an unauthorised error response   }    
         public static void main (String[] args)  throws Exception{      //Main method for testing..   
             BookStoreSessionManager b = new BookStoreSessionManager() ;      
                EventLoopGroup bossGroup=new NioEventLoopGroup();//Define a group of threads to handle I/O event  
                  try {         /*Create the server.*/          ServerBootstrap sb=        new ServerBootstrap(bossGroup,new SocketOptionLevel[] {},           ChannelInitializer<SocketChannel>(){    @Overridepublic void initChannel (SocketChannel ch) throws Exception{ch.pipeline().addLast("framed",               FrameDecoder.class ,4096);             }});         
                b.bind(8125).sync();//Bind and start the server on port 8125..        try {bossGroup .await();} finally{   //Shutdown hook    bossGroup.shutdownGracefully().awaitTerminationHierarchySeconds(5);}};
            } catch (Exception ex)     {}      }}              /*Main method*/