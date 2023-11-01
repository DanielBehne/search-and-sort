/*
 * othelloCopyMyPlayer class project competition
 * Copyright 2017 Roger Jaffe
 * All rights reserved
 */
package main.java.com.mrjaffesclass.othello;

/**
 * othelloCopyMyPlayer class project competition
 * @author Roger Jaffe
 * @version 1.0
 */
public class othelloCopyMyPlayer {

  /**
   * @param args the command line arguments
   */
  public static void main(String[] args) {
    Controller c = new Controller( 
      new Player(Constants.BLACK), 
      new TestPlayer(Constants.WHITE)
    );
    c.displayMatchup();
    int result = c.run();
    System.exit(0);
  }
  
}
