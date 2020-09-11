package com.vrizzo.port;

import com.vrizzo.port.formatter.PortInfoFormatter;

import java.util.Scanner;

public class Main
{
  public static void main(String[] args)
  {
    final Train train = new Train(3);
    Port port = new Port(train, new ContainerStorage(6), new Crane(), new Crane(), new PortInfoFormatter());
    // create a scanner so we can read the command-line input
    Scanner scanner = new Scanner(System.in);

    //  prompt for the user's name
    System.out.print("Enter your command: ");

    // get their input as a String
    while (scanner.hasNext())
    {
      String command = scanner.next();
      executeCommand(port,command);
      port.show();
    }
  }

  private static void executeCommand(Port port, String command)
  {
              switch (command)
              {
                case "receive_ship" :
                  port.receiveShip(new Ship(4));
                  break;
                case "unload" :
                  port.unload();
                  break;
                case "show" :
                  System.out.println(port.show());
                  break;
                case "train_send" :
                  port.trainSend();
                  break;
                default:
                  System.out.println("wrong command! accepted command ; receive_ship,unload,show,train_send");
              }
  }
}
