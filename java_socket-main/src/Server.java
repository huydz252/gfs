import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public Server() throws Exception {
        ServerSocket serverSocket = new ServerSocket(12345);
        System.out.println("Server is running on port 12345");
        Scanner sc = new Scanner(System.in);
        String output; System.out.print("nhap output!: ");
        output = sc.nextLine();
        sc.close();
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Client connected");
            BufferedReader fromClient = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line = fromClient.readLine();
            System.out.println("Received: " + line);    
            DataOutputStream toClient = new DataOutputStream(socket.getOutputStream());
            toClient.writeBytes(output);
            socket.close();
        }
    }
    public static void main(String[] args) throws Exception {
        new Server();
    }
}
