package utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
	
	
	
public static Object[][] readData (String filePath) {
        
        
        BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(filePath));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        String line = "";
        
        List <String[]> list = new ArrayList<>();
        int colCount = 0;
        try {
			while( (line = reader.readLine()) != null ) {
			    
			    String[] split = line.split(",");
			    colCount = split.length;
			    list.add(split);
			    
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        int rowCount = list.size();
        
        Object [][] data = new Object[rowCount][colCount];
        
        for (int i = 0; i < data.length; i++) {
            data [i] = list.get(i);
        }
        
        return data;
        
    }




}
