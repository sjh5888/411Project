package data;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Laptop
 */

import java.net.*;
import java.io.*;

public class ClientSocket {
    protected static Socket socket;
    protected InputStream iStream;            // Instance variables
    protected OutputStream oStream;
    
    public ClientSocket(String url, int port)  {
        try {
             socket = new Socket(url, port);
             System.out.println(port);
             System.out.println("CLIENT: connected to " + url + ":" + port);
             System.out.println("CLIENT: port number " + socket.getLocalPort());
             //newPort = newPort + 1;
             
         } catch (Exception e) {
             e.printStackTrace();
             System.exit(1);
         }
     } //ClientSocket
    public void start(String cc) {
         try {
             requestService(socket, cc);  
             socket.close();
             System.out.println("CLIENT: connection closed");
             
         } catch (IOException e) { 
             System.out.println(e.getMessage());
         }
         
     } // run()
protected void requestService(Socket socket, String cc) throws IOException {         
        String servStr = readFromSocket(socket);          // Check for "Hello"
        System.out.println("SERVER: " + servStr);         // Report the server's response
        if (servStr.substring(0,5).equals("Hello")) {
            //System.out.println("CLIENT: type a line or 'goodbye' to quit"); // Prompt the user
            String userStr = "";
            do {
                //userStr = readFromSocket(socket);                   // Get input from socket
                userStr = String.valueOf(cc);
                writeToSocket(socket, userStr);          // Send it to server  +"\n"/////////
                //writeToSocket(socket, "goodbye");
                servStr = readFromSocket(socket);               // Read the server's 
                test1 t1 = new test1();        
                t1.returnStatement("Return: " + servStr);       // Report the server's response
            //} while (!userStr.toLowerCase().equals("goodbye")||!userStr.toLowerCase().equals("true")||!userStr.toLowerCase().equals("false")); // Until user says 'goodbye'
            } while (!servStr.toLowerCase().equals("true"));
            }
        
    } // requestService()
    protected String readFromSocket(Socket sock) throws IOException {
        iStream = sock.getInputStream();
        String str="";
        char c;
        while (  ( c = (char) iStream.read() ) != '\n') 
            str = str + c + "";
        return str;
        }

    /**
     *  writeToSocket() reads a String to a given socket
     *  @param sock -- a reference to the Socket object
     *  @param str -- the string to be written
     * @throws java.io.IOException
     */
    protected void writeToSocket(Socket sock, String str) throws IOException {
        oStream = sock.getOutputStream();
        if (str.charAt( str.length() - 1 ) != '\n')
            str = str + '\n';
        for (int k = 0; k < str.length() ; k++)
            oStream.write(str.charAt(k));
    } // writeToSocket()
//public static void main (String args[]) {
  //      ClientSocket client = new ClientSocket("localhost", 10001);
    //    client.start();
    //} // main()
    
}


