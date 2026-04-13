import java.io.*;
import java.net.*;

public class java_00741_SocketServer_A01 {

    public static void main(String[] args) throws IOException {
        // Create a socket server at port 1234
        ServerSocket server = new ServerSocket(1234);

        while (true) {
            // Wait for a client to connect
            Socket client = server.accept();

            // Create a new thread for handling the client
            Thread thread = new Thread(new SocketHandler(client));
            thread.start();
        }
    }

    static class SocketHandler implements Runnable {
        Socket socket;

        public java_00741_SocketServer_A01(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                // Create input and output streams
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                // Read a line of text from the client
                String line = in.readLine();

                // Process the received text (in this case, just echo it back to the client)
                out.println("Server received: " + line);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}