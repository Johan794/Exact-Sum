import java.io.BufferedReader;
//import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.io.OutputStreamWriter;
import java.util.ArrayList;
import  java.util.Arrays;

public class Main {

    public static  void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int [] bookPrices;
        String [] inPut;
        String line;
        //String aux=" ";
        //String out;
        int size;
        int peterMoney;
        line= br.readLine();
        /*
         * Hay tres cosas que no se pueden ocultar por mucho tiempo:
         * el sol, la luna y la verdad (Buddha)
         * y la verdad es que no hay una forma de hacer que el ciclo no pare sin pulsar ctrl+d o ctrl+z
         */
        do {
            if (!line.equals("")){
                //System.out.println("La linea tiene 'size': "+line);
                size = Integer.parseInt(line);
                bookPrices = new int[size];
                line = br.readLine();
                //System.out.println("La linea tiene 'input': "+line);
                inPut = line.split(" ");
                for (int i = 0; i <inPut.length ; i++) {
                    bookPrices[i]= Integer.parseInt(inPut[i]);
                }
                line = br.readLine();
                //System.out.println("La linea tiene 'money': "+line);
                peterMoney = Integer.parseInt(line);
                System.out.println(peterShouldBuy(bookPrices,peterMoney));

                //line = br.readLine();
                //System.out.println("La linea tiene 'salto de linea': "+line);

            }
            line = br.readLine();

        } while (line!=null);



        //bw.write(out.toString());
        br.close();
        //bw.close();

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
                if((bookPrices[m]+bookPrices[n])==peterMoney && (m!=n)){
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

        out = "Peter should buy books whose prices are "+k+" and "+l+".\n";
        return out;
    }


}
