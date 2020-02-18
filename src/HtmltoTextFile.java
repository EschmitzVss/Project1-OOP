// CS 2365 Object Oriented Programming, Spring 2020, Section 001
// Ethan Schmitz
// Project 1
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class HtmltoTextFile {
  //Main takes String args as its input, and will throw an exception (likely IOException) if necessary. 
  //main has no return, but will print out information to the user, and write the same information to the output file designated.
  public static void main(String[] args) throws Exception
  {                                                   //runs the actual conversion and manipulation of the string data, as well as pulls it from the input file and outputs it to the output file.
    String inputFileName = "dataStructures.html";     //String that stores the filename of the input html file.
    String formattingString = "";                     //Empty string to build a string from the file data
    formattingString = new String(Files.readAllBytes(Paths.get(inputFileName))); //Creates the string that we use to manipulate the data

    String outputFileName = "output.txt"; //String that stores the name of the output file
    PrintWriter outputFile = new PrintWriter(outputFileName); //Creates a PrintWriter to write the data into the file


    //Uses a series of replacements to manipulate the entire file at once as one continous string. Replaces end characters and unnecessary space first, and then replaces end characters with newlines,
    //does some additional formatting for the HTML conversion, as some characters require special designation (see &nbsp). Then after conversion is done, it strips the leftover html tags out.
    formattingString = formattingString.replaceAll("\"", "").replaceAll("\\s{1,}", " ").replaceAll("\n", "").replaceAll("\r", "").replaceAll("\t", "").replaceAll("<br>", "\r\n").replaceAll("</h\\d>", "\n").replaceAll("<h\\d>", "\n")
      .replaceAll("<h[^>]*>", "\n").replaceAll("</li>", "\n").replaceAll("<p>", "\n").replaceAll("</p>", "\n").replaceAll("</th>", ",").replaceAll("<title>[^>]*</title>", "").replaceAll("&#160"," ").replaceAll("</b>", " ").replaceAll("</td>", ", ").replaceAll("<b>", " ").replaceAll("</tr>", "\n")
      .replaceAll("&nbsp;", " ").replaceAll("“", "\"").replaceAll("”", "\"").replaceAll("\"", "\'").replaceAll("<ul>", "\n").replaceAll("<[^>]*>", "");

    //prints the data to the console for the user to preview, and outputs the data into the file designated in text format.
    System.out.println("Transferring Html \"Parsed Data\" from the HTML file " + inputFileName + " to the text file " + outputFileName);
    System.out.println("Printing a preview of the data here: " + formattingString);
    outputFile.println(formattingString);
    outputFile.close();
  }
}
