package translator;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.LinkedHashMap;


public class Translator {
	private static Translator trans = null;
	private static HashMap<String, String> mapping = new HashMap<>();
	private LinkedHashMap<String,String> historyTranslation = new LinkedHashMap<>();
	
	private Translator() {
		mapping.put("one", "eins");
		mapping.put("two", "zwei");
		mapping.put("three", "drei");
		mapping.put("four", "vier");
		mapping.put("five", "fünf");
		mapping.put("six", null);
		mapping.put("seven", "sieben");
		mapping.put("eight", "acht");
		mapping.put("nine", "neun");
		mapping.put("ten", "zehn");
		mapping.put("eleven", "elf");
		mapping.put("twelve", "zwölf");
		mapping.put("thirteen", "dreizehn");
		mapping.put("fourteen", "vierzehn");
		mapping.put("fifteen", "fünfzehn");
		mapping.put("sixteen", "sechzehn");
		mapping.put("seventeen", "siebzehn");
		mapping.put("eighteen", "achtzehn");
		mapping.put("nineteen","neunzehn" );
		mapping.put("twenty", "zwanzig");
	}
	
	public static Translator getInstance(){
		if(trans == null) {
			trans = new Translator();
		}
		return trans;
	}
	
	public String translate(String input) {
		String result;
		if(mapping.containsKey(input)) {
			result = mapping.get(input);
			historyTranslation.put(input, result);
		}
		else result = "I don't understand";
		return result;
	}
	
	public void StorePerformedTranslations() throws IOException {
		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream("G:\\testout.txt"));
	        oos.writeObject(historyTranslation);
	        System.out.println("Success...");
	    } catch (IOException ex) {
	        ex.printStackTrace();
	    } finally {
	        oos.close();
	    }
	}
	
	public LinkedHashMap<String,String> LoadPerformedTranslations() throws IOException, ClassNotFoundException {
		ObjectInputStream ois = null;
		LinkedHashMap<String,String> loadedTranslation = new LinkedHashMap<String,String>();
		try {
			ois = new ObjectInputStream(new FileInputStream("G:\\testout.txt"));
			loadedTranslation = (LinkedHashMap<String, String>) ois.readObject();
			for(String key: loadedTranslation.keySet()) {
				System.out.println(key+ " " +loadedTranslation.get(key));
			}	
		} catch(IOException ex) {
			ex.printStackTrace();
		} finally {
			ois.close();
		}
		return loadedTranslation;
	}
	
	public LinkedHashMap<String,String> getHistoryTranslation(){
		return historyTranslation;
	}

}
