package team.dedica.currencies;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ReadConverter implements Converter{

    @Override
    public double getConversion(Currency fromCurr, Currency toCurr)  {
        BufferedReader br;
        try {

            br = new BufferedReader(new FileReader("Conversion.csv"));
        } catch (FileNotFoundException e) {
            // path is hardcoded, not expecting any errors
            return 1;
        }

        String line;
        String[] values;
        try {
            while((line = br.readLine()) != null){
                values = line.split(",");
                if(values[0].equals(fromCurr.getSymbol())){
                    if(values[1].equals(toCurr.getSymbol()) ){
                        return Double.parseDouble(values[2]);
                    }
                }
            }
        }
        catch (Exception e){
            // file is hardcoded, not expecting any errors
        }
        System.err.println("Currency pair not found, returning 1.0 as conversion value");
        return 1;
    }

}
