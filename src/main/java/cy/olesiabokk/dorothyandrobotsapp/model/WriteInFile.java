package cy.olesiabokk.dorothyandrobotsapp.model;

import java.io.FileWriter;
import java.io.IOException;

public class WriteInFile {
    public void write(String fileName, String input){
        try (FileWriter fileWriter = new FileWriter(fileName)) {
            fileWriter.write(input);
        } catch (IOException e){
            System.out.println("Got an exception while writing text");
            System.err.println(e.getMessage());
        }
    }
}
