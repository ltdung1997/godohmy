package translator;

import java.util.HashMap;

public interface Translator {
	boolean translate(String input);
	HashMap<String, String> getMapping();
}
