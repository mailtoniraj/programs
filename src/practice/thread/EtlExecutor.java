package practice.thread;

import java.io.File;



public class EtlExecutor {


    public static void main(String[] args) {

        try {
            File original = new File("D:\\Practice\\input.txt");
            File processed = new File("D:\\Practice\\output.txt");
            EtlService etlService = new EtlService(original, processed);
            new Thread(() -> {
                etlService.read();
            }).start();
             new Thread(() -> {
                etlService.process();
            }).start();
            Thread writerThread = new Thread(() -> {
                etlService.write();
            });
            writerThread.start();
            System.out.println("ETL Service started ..");
            writerThread.join();
            System.out.println("ETL Service over ...");
        }
        catch (Exception ex)
        {
         ex.printStackTrace();
        }
    }

}
