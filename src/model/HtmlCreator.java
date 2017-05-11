package model;

import java.io.BufferedWriter;
import java.io.FileWriter;

public class HtmlCreator {

    public void createHtmlFile(String source){
        FileWriter fWriter = null;
        BufferedWriter writer = null;
        try {
            fWriter = new FileWriter("fileName.html");
            writer = new BufferedWriter(fWriter);
            writer.write("<html>");
            writer.write("<head><meta charset=\"utf-8\">\n" +
                    "  <title>Video Shop</title></head>");
            writer.write("<body>");
            writer.write(source);
            writer.newLine(); //this is not actually needed for html files - can make your code more readable though
            writer.write("</body>");
            writer.write("</html>");
            writer.close(); //make sure you close the writer object
        } catch (Exception e) {
            //catch any exceptions here
        }
    }
}
