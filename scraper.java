import java.io.*;

public class scraper {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\oisin\\Desktop\\tableData.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String st;
        while((st = br.readLine())!=null){

                System.out.println(st);

        }
    }





}


