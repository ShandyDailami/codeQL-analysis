import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class java_04798_SocketServer_A01 {

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(8080);
        System.out.println("Waiting for client...");

        while (true) {
            Socket socket = server.accept();
            System.out.println("Connected to " + socket.getRemoteSocketAddress());

            // Create a new thread to handle communication
            Thread t = new Thread(new ClientHandler(socket));
            t.start();
        }
    }

    static class ClientHandler implements Runnable {

        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;

        public java_04798_SocketServer_A01(Socket socket) {
            this.socket = socket;
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
            } catch (Exception e) {
                // Handle exception
            }
        }

        @Override
        public void run() {
            try {
                String request;
                while ((request = in.readLine()) != null) {
                    if (request.equals("BREAK")) {
                        break;
                    }

                    // Perform security-sensitive operations
                    // For example, check if the request contains certain keywords
                    if (request.contains("password")) {
                        out.println("Access Denied: Contains password!");
                    } else {
                        out.println("Hello, Client!");
                    }
                }

                socket.close();
            } catch (Exception e) {
                // Handle exception
            }
        }
    }
}