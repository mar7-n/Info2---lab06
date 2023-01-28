package lab06.src.scrabble.util;

import java.util.HashSet;
import java.util.Set;

public class SubSets {

	public static Set<String> getSubSets(String str) {
		Set<String> words = new HashSet<>();
		if(str.length() > 1) {
			words.add(str.substring(0,2));
			for(int i=2; i<str.length();i++) {
				for(String word : words) {
					String aux = word + str.charAt(i);
					words.add(aux);
				}
				for (int j = 0; j < i; j++) {
					String aux = "" + str.charAt(j) + str.charAt(i);
					words.add(aux);
				}
			}
		}
		return words;
	}

}
