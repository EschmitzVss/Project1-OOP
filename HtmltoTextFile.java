// CS 2365 OOP Spring 2020
// Ethan Schmitz

import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class HtmltoTextFile {
  public static void main(String[] args) throws Exception
  {
    String inputFileName = "complicatedExampleCustomersTable.html";
    String formattingString = "";
    formattingString = new String(Files.readAllBytes(Paths.get(inputFileName)));

    String outputFileName = "output.txt";
    PrintWriter outputFile = new PrintWriter(outputFileName);

    formattingString = formattingString.replaceAll("\"", "").replaceAll("\\s{1,}", " ").replaceAll("\n", "").replaceAll("\r", "").replaceAll("\t", "").replaceAll("<br>", "\r\n").replaceAll("</h\\d>", "\n").replaceAll("<h\\d>", "\n")
      .replaceAll("<h[^>]*>", "\n").replaceAll("</li>", "\n").replaceAll("<p>", "\n").replaceAll("</p>", "\n").replaceAll("</th>", ",").replaceAll("<title>[^>]*</title>", "").replaceAll("&#160"," ").replaceAll("</b>", " ").replaceAll("</td>", ", ").replaceAll("<b>", " ").replaceAll("</tr>", "\n")
      .replaceAll("&nbsp;", " ").replaceAll("“", "\"").replaceAll("”", "\"").replaceAll("\"", "\'").replaceAll("<ul>", "\n").replaceAll("<[^>]*>", "");

    System.out.println("Transferring Html \"Parsed Data\" from the HTML file " + inputFileName + " to the text file " + outputFileName);
    System.out.println("Printing a preview of the data here: " + formattingString);
    outputFile.println(formattingString);
    outputFile.close();
  }
}
