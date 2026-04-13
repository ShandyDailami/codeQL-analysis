import java.io.*;
import java.net.*;

public class java_04315_SocketServer_A08 {
    public static void main(String[] args) {
        ServerSocket server = null;
        Socket socket = null;

        try {
            // create a server socket
            server = new ServerSocket(8080);

            System.out.println("Server is listening on port 8080");

            while (true) {
                // accept a client socket
                socket = server.accept();

                // create an input stream from the socket
                BufferedReader in = new BufferedReader(
                        new InputStreamReader(socket.getInputStream()));

                // create an output stream to the client socket
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

                // read a line from the client
                String line = in.readLine();

                // echo the line back to the client
                out.println("Server received: " + line);

                // close the connection
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (server != null) server.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}