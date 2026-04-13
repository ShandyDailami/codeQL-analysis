import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class java_17673_SocketServer_A08 {
    private static final int PORT = 8080;

    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(PORT)) {
            System.out.println("Server is listening on port " + PORT);

            while (true) {
                Socket socket = server.accept();
                System.out.println("Client connected from " + socket.getRemoteSocketAddress());

                // Create a new thread to handle the client request
                Thread requestHandler = new Thread(new ClientRequestHandler(socket));
                requestHandler.start();
            }
        } catch (IOException e) {
            System.out.println("Server failed to bind to port " + PORT);
            System.exit(-1);
        }
    }
}

class ClientRequestHandler implements Runnable {
    private Socket socket;

    public java_17673_SocketServer_A08(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Create a new InputStream and OutputStream for the client socket
            InputStream input = socket.getInputStream();
            OutputStream output = socket.getOutputStream();

            // Read and process the request from the client
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            String request = reader.readLine();

            // TODO: Add your security-sensitive operations here
            // For instance, adding a random number to the request to verify integrity
            // request = request + ((int)(Math.random() * 10000));

            // Send the processed request back to the client
            output.write(request.getBytes());
            output.newLine();
            output.flush();

            socket.close();
        } catch (IOException e) {
            System.out.println("An error occurred while reading or writing from the client");
        }
    }
}