package cy.olesiabokk.dorothyandrobotsapp.main;

import cy.olesiabokk.dorothyandrobotsapp.model.ReaderFromFile;
import cy.olesiabokk.dorothyandrobotsapp.model.Service;
import cy.olesiabokk.dorothyandrobotsapp.model.WriteInFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {
    public static void main(String[] args) throws IOException {
        Service service = new Service();
        service.clearDir(Path.of("data/").toFile());

        Calendar calendar = new GregorianCalendar();
        SimpleDateFormat simpleDate = new SimpleDateFormat();
        simpleDate.applyPattern("dd-MM-yyyy");
        File directoryPath = new File("data/" + simpleDate.format(calendar.getTime()));
        directoryPath.mkdirs();

        ReaderFromFile readerFromFile = new ReaderFromFile();
        WriteInFile writeInFile = new WriteInFile();
        Path outputDir = Paths.get("data/" + simpleDate.format(calendar.getTime()));
        String fileName = "src/main/resources/text.txt";
        StringBuilder initialText = new StringBuilder(readerFromFile.read(fileName));

        Files.createFile(outputDir.resolve(service.setFileName(initialText, "~.+~") + ".txt"));
        Files.createFile(outputDir.resolve(service.setFileName(initialText, "ao.+\\^p") + ".txt"));
        Files.createFile(outputDir.resolve("punctuation.txt"));

        writeInFile.write(outputDir + "/~~47$a3e2~.txt", service.getIdealString(service.getEvenNumVowelsList(initialText)));
        writeInFile.write(outputDir + "/aoi875#23^p.txt", service.getIdealString(service.getOddNumVowelsList(initialText)));
        writeInFile.write(outputDir + "/punctuation.txt", service.idealStr(service.countPunctMarks(initialText)));
    }
}


