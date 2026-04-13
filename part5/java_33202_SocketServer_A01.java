import java.net.*;
import java.io.*;

public class java_33202_SocketServer_A01 {
    public static void main(String args[]) {
        ServerSocket server = null;
        Socket socket = null;

        try {
            server = new ServerSocket(8080);
            System.out.println("Waiting for client...");

            socket = server.accept();
            System.out.println("Connected to " + socket.getRemoteSocketAddress());

            OutputStream outToClient = socket.getOutputStream();
            PrintWriter out = new PrintWriter(outToClient, true);

            out.println("Hello, Client!");

            InputStream inFromClient = socket.getInputStream();
            BufferedReader in = new BufferedReader(new InputStreamReader(inFromClient));

            String message, response;
            while((message = in.readLine()) != null) {
                System.out.println("Received: " + message);
                response = "Server: " + message;
                out.println(response);
            }

            socket.close();
            server.close();

        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}