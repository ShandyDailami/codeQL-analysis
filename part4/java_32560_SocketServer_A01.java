import java.io.*;
import java.net.*;

public class java_32560_SocketServer_A01 {
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8080);
        while (true) {
            Socket socket = serverSocket.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Echo client input
            String clientInput;
            while ((clientInput = in.readLine()) != null) {
                out.println(clientInput);
            }
       
            socket.close();
        }
    }
}