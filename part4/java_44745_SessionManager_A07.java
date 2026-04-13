import javax.servlet.*;
import java.io.IOException;
import org.apache.catalina.Context;
public class java_44745_SessionManager_A07 implements SessionListener {   //define a new Class "MySessionManger" to handle sessions 
    public void sessionCreated(javax.servlet.http.HttpSessionEvent se) {}     //this function will be called when any HttpServletRequest is made which doesn't have associated http-session object yet (when the client connects or opens a new tab in browser and then request goes to server).
   public void sessionDestroyed(javax.servlet.http.HttpSessionEvent se) {}     //this function will be called when any HttpServletRequest is closed, ie whenever user closes their web page directly from the URL bar or by clicking on 'F5' in browser console and then request goes to server).
}  public static void main(String[] args){    }   private java_44745_SessionManager_A07() {} //make constructor私有以避免外部实例化. We will create a new object only through this class methods, not from outside the program via 'new' keyword directly due in accordance with Java Bean design principle