import java.io.*;
import java.net.*;

public class java_32699_SocketServer_A07 {
    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(6000);

        while(true) {
            Socket socket = server.accept();

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String clientMsg, serverMsg;

            // Read from client
            clientMsg = in.readLine();

            // Simulate an authentication failure
            if (clientMsg.equals("auth fail")) {
                serverMsg = "auth fail";
                out.println(serverMsg);
            } else {
                serverMsg = "auth success";
                out.println(serverMsg);
            }

            // Close the connection
            socket.close();
        }
    }
}