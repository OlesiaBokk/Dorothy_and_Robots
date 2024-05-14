package cy.olesiabokk.dorothyandrobotsapp.model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReaderFromFile {

    public StringBuilder read(String fileOutputName) {
        StringBuilder text = new StringBuilder();
        try (FileReader fileReader = new FileReader(fileOutputName)) {
            int charToRead = fileReader.read();
            while (charToRead != -1) {
                text.append((char) charToRead);
                charToRead = fileReader.read();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Output file not found");
            System.err.println(e.getMessage());
        } catch (IOException e) {
            System.out.println("Cannot read text from output file");
            System.err.println(e.getMessage());
        }
        return text;
    }
}
