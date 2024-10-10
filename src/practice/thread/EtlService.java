package practice.thread;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class EtlService {

    private File inputFile, outputFile;

    private BlockingQueue<String> fileReaderQueue = new LinkedBlockingQueue<String>();
    private BlockingQueue<String> fileProcessingQueue = new LinkedBlockingQueue<String>();

    private static volatile boolean isReadingOver = false;
    private static volatile boolean isProcessingOver = false;

    private static String TERMINATION_INDICATOR = "TERMINATION_UNIQUE_CODE" ;

    public EtlService(File input, File output) {
        this.inputFile = input;
        this.outputFile = output;
    }

    public boolean read() {
        System.out.println("File Reading Started");
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile.getAbsolutePath()))) {
            String text;
            while ((text = reader.readLine()) != null) {
                fileReaderQueue.put(text);
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            try {
                fileReaderQueue.put(TERMINATION_INDICATOR);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        isReadingOver = true;
        System.out.println("File Reading over");
        return true;
    }

    public void process() {
        // implement reversing the line
        String text;
        System.out.println("File Processing Started");
        try {
            while (!isReadingOver || (isReadingOver && !fileReaderQueue.isEmpty())) {
                text = fileReaderQueue.take();
                if (TERMINATION_INDICATOR.equals(text)) {
                    break;
                }
                text = new StringBuilder(text).reverse().toString();
                fileProcessingQueue.put(text);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                fileProcessingQueue.put(TERMINATION_INDICATOR);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        isProcessingOver = true;

        System.out.println("File Processing Over..");
    }

    public void write() {
        // implement writing the reversed line
        System.out.println("File Writing started..");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile.getAbsolutePath()))) {
            String text;
            while (!isProcessingOver || (isProcessingOver && !fileProcessingQueue.isEmpty())) {
                text = fileProcessingQueue.take();
                if (TERMINATION_INDICATOR.equals(text)) {
                    break;
                }
                writer.write(text);
                writer.newLine();
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("File Writing over..");


    }

}



