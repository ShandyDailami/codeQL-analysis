import java.net.ServerSocket;
import java.net.Socket;

public class java_27634_SocketServer_A07 {

    public static void main(String[] args) throws Exception {
        ServerSocket server = new ServerSocket(4444);
        System.out.println("Server is listening on port 4444");

        while (true) {
            Socket socket = server.accept();
            System.out.println("A client has connected!");

            // Here we create a new thread to handle the client
            Thread t = new Thread(new ClientHandler(socket));
            t.start();
        }
    }
}

class ClientHandler implements Runnable {

    private Socket socket;

    public java_27634_SocketServer_A07(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Here we create a new stream to handle the client's request
            // This is a very basic example and a real server would need to use SSL or a more advanced protocol
            // Also, for security, we need to handle the authentication here
            // This is not included in the minimalist style provided below
            // We would typically use a library or service to handle authentication
            // Here we're just demonstrating the concept, not implementing security
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream writer = new DataOutputStream(socket.getOutputStream());

            String message;
            while ((message = reader.readLine()) != null) {
                System.out.println("Received: " + message);
                writer.writeBytes("Server says: " + message + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}