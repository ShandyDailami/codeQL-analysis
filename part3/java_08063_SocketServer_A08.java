import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class java_08063_SocketServer_A08 {

    public static void main(String[] args) throws Exception {
        int port = 1234;
        ServerSocket server = new ServerSocket(port);
        System.out.println("Server started on port " + port);

        while (true) {
            Socket socket = server.accept();
            System.out.println("Client connected");

            // Create new thread to handle communication
            Thread thread = new Thread(new ClientHandler(socket));
            thread.start();
        }
    }

    static class ClientHandler implements Runnable {
        private Socket socket;
        private BufferedReader in;
        private PrintWriter out;

        public java_08063_SocketServer_A08(Socket socket) {
            this.socket = socket;
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        public void run() {
            String message;
            while ((message = in.readLine()) != null) {
                System.out.println("Received: " + message);
                // TODO: Handle the message here with security-sensitive operations related to A08_IntegrityFailure.

                // Send a response back to the client
                out.println("Server received your message: " + message);
            }
            out.close();
            socket.close();
        }
    }
}