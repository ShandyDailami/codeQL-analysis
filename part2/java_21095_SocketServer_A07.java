import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class java_21095_SocketServer_A07 {

    private static final int PORT = 8080;
    private static final int THREAD_POOL_SIZE = 5;

    private final ExecutorService executorService;

    public java_21095_SocketServer_A07() {
        executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
    }

    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected!");
                ObjectOutputStream outputStream = new ObjectOutputStream(clientSocket.getOutputStream());
                ObjectInputStream inputStream = new ObjectInputStream(clientSocket.getInputStream());
                AuthenticationRequest authenticationRequest = (AuthenticationRequest) inputStream.readObject();
                AuthenticationResponse authenticationResponse = authenticate(authenticationRequest);
                outputStream.writeObject(authenticationResponse);
                outputStream.flush();
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) {
        // This is a placeholder for actual authentication logic
        // Here we're just checking if the username and password match
        if ("admin".equals(authenticationRequest.getUsername()) && "password".equals(authenticationRequest.getPassword())) {
            return new AuthenticationResponse("Success", "Welcome back!");
        } else {
            return new AuthenticationResponse("Failed", "Invalid username or password");
        }
    }

    public static void main(String[] args) {
        SocketServer server = new SocketServer();
        server.start();
    }
}