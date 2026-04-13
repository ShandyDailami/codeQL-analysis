import java.net.*;
import java.io.*;

public class java_13470_SocketServer_A08 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8080);
        while (true) {
            Socket socket = server.accept();
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                out.println("Server: " + inputLine);
           .
            out.close();
            in.close();
            socket.close();
            server.close();
        }
    }
}