/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socket.based.communication.client;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author unrealWombat
 */
public class Client {

    private String host = "localhost";
    private int port = 22222;

    private Socket server;

    // Constructor
    public Client() {
        run();
    }

    private void run() {
        try {
            System.out.println("Connecting to server...");

            // Create a Socket Object
            server = new Socket(host, port);
            System.out.println("Connected to server: " + server.getInetAddress());

        } catch (IOException ex) {
            System.err.println("Coudnt connect to server...");
        }
    }

    public void receiveData() {
        PrintWriter out = null;
        try {
            System.out.println("Waiting for input...");

            // Create I/O streams for communicating to the client
            BufferedReader in = new BufferedReader(new InputStreamReader(server.getInputStream()));

            String inputLine = in.readLine();
            System.out.println("Server: " + inputLine);

            System.out.println("Finished receiving!");

        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void sendData(String text) {
        PrintWriter printWriter = null;
        try {
            // Create I/O streams for communicating to the client
            printWriter = new PrintWriter(server.getOutputStream(), true);
            System.out.println("Sending to server: " + text);
            printWriter.println(text);
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void closeSocket() throws IOException {
        // Close the socket when done.
        server.close();
    }
}
