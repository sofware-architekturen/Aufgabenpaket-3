package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// Klasse liest Eingaben von der Konsole
public class Console
{
  private static BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
  
  public static String read() throws IOException
  {
    String line = null;
    line = input.readLine();

    return line;
  }
}
