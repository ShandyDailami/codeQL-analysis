import java.io.*;
import java.net.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class java_07703_SocketServer_A07 {

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8080);
        while (true) {
            Socket socket = server.accept();
            System.out.println("Accepted a connection from: " + socket.getRemoteSocketAddress());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            out.println("HTTP/1.1 200 OK");
            out.println("Content-Type: text/html; charset=utf-8");
            out.println();
            out.println("<h1>Welcome to the Secure Socket Server!</h1>");
            out.println();
            out.println("<p>This is a simple web page.</p>");
            out.println();
            out.println("<p>Thanks for using our server!</p>");
            out.println();
            out.println("<hr>");
            out.println("<p>If you prefer, you can hide the page title and status message.</p>");
            out.println();
            out.println("<p>If you prefer, you can hide the page title and status message.</p>");
            out.flush();
            socket.close();
        }
    }
}