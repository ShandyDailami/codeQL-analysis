import java.net.*;

public class java_05905_SocketServer_A01 {
    public static void main(String[] args) {
        int port = 4445; // Default port

        // Check if port is provided, if not use default port
        if(args.length > 0) {
            port = Integer.parseInt(args[0]);
        }

        try {
            ServerSocket server = new ServerSocket(port);

            System.out.println("Server is listening on port: " + port);

            while (true) {
                Socket socket = server.accept();

                System.out.println("Client " + socket.getInetAddress().getHostAddress() + " connected");

                // Start a new thread for handling the client
                new ClientHandler(socket).start();
            }
        } catch (IOException e) {
            System.out.println("Could not listen on port " + port);
            System.exit(-1);
        }
    }
}

class ClientHandler extends Thread {
    private Socket socket;

    public java_05905_SocketServer_A01(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            // Read the incoming request
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());

            // Send a welcome message
            out.writeUTF("Welcome to the server!");

            String message;
            while((message = in.readLine()) != null) {
                System.out.println("Received: " + message);
                // Process the message here. You can use this place for security-sensitive operations
                // e.g. check if the message is a command and if so, handle it

                // Send a response back to the client
                out.writeUTF("Server received: " + message);
            }

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}