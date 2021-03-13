import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import  java.util.Arrays;

public class Main {

    public static  void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int [] bookPrices;
        String [] inPut;
        String line;
        StringBuilder out= new StringBuilder();
        int size;
        int peterMoney;
        line = br.readLine();
        while (line!=null){
    
            if (!line.equals("\n") && !line.equals("")){
                size = Integer.parseInt(line);
                bookPrices = new int[size];
                line = br.readLine();
                inPut = line.split(" ");

                for (int i = 0; i <inPut.length ; i++) {
                    bookPrices[i]= Integer.parseInt(inPut[i]);

                }
                line = br.readLine();
                peterMoney = Integer.parseInt(line);
                out.append(peterShouldBuy(bookPrices,peterMoney));
             

            }
            line = br.readLine();
        }

        bw.write(out.toString()+"\n");
        br.close();
        bw.close();

    }

    public static String peterShouldBuy(int [] bookPrices , int peterMoney){
        String out;
        int k=0; 
        int l=0;
        ArrayList<Integer> candidates = new ArrayList<>();
        Arrays.sort(bookPrices);
        boolean found;
        int i=0;
        int j=bookPrices.length-1;
        for (int n = 0; n <bookPrices.length ; n++) {
            found = false;
            while (i<=j && !found){
                int m = (i+j)/2;
                if((bookPrices[m]+bookPrices[n])==peterMoney){
                    found = true;
                    k=bookPrices[n];
                    l=bookPrices[m];          
                    candidates.add(k);
                    candidates.add(l);
                }else if((bookPrices[m]+bookPrices[n])>=peterMoney){
                    j=m-1;
                }else{
                    i= m+1;

                }

            }
            i=0;
            j = bookPrices.length-1;
        }
        int temp=peterMoney;
        for (int m = 0; m <candidates.size() ; m=m+2) {
            if(Math.abs(candidates.get(m)-candidates.get(m+1))<temp){
                temp = Math.abs(candidates.get(m)-candidates.get(m+1));
                k = candidates.get(m);
                l = candidates.get(m+1);
            }
        }

        
        out = "Peter should buy books whose prices are "+k+" and "+l+"\n";
        return out;
    }


}
