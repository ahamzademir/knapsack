import java.io.*;
import java.util.ArrayList;

public class writeOutput {

    File file;
    FileWriter fw;
    BufferedWriter bw;

    public  void createOutputFile(int largestNo, ArrayList<String> output) throws IOException {

        try {
            file = new File("output.txt");

            //dosya mevcut değilse oluştur
            if (!file.exists()) {
                file.createNewFile();
            }
            else if(file.exists()) {
                FileWriter fileWriter = new FileWriter("output.txt", false);
                PrintWriter printWriter = new PrintWriter(fileWriter, false);
                printWriter.flush();
                printWriter.close();
                fileWriter.close();

            }
            fw = new FileWriter(file);
            bw = new BufferedWriter(fw);

            bw.write(largestNo + "\n");

            for (String i : output) {
                bw.write(i);
                bw.write("\n");
            }
            System.out.println("\nOutput file written successfully.");

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        finally
        {
            try{
                if(bw!=null)
                    bw.close();
            }catch(Exception ex){
                System.out.println("Error in closing the BufferedWriter"+ex);
            }
        }
    }
}
