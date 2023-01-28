package lab06.src.scrabble.util;


public class Permutation {
	String original;

	public Permutation(String word) {
		original = word;
	}

	@Override
	public int hashCode() {
		// TBD: implement this method
		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		boolean result = false;
		if(obj instanceof Permutation) {
			if(((Permutation) obj).getNormalized().equals(this.getNormalized())) result=true;
		}
		return result;
	}

	@Override
	public String toString() {
		return getWord() + " / " + getNormalized();
	}

	public String getNormalized() {
		String aux = original;
		String result = "";
		while (!aux.equals("")) {
			char min = aux.charAt(0);
			for(int i=1;i<aux.length();i++) {
				if(aux.charAt(i) < min) min = aux.charAt(i);
			}
			aux = aux.substring(0,aux.indexOf(min)) + aux.substring(aux.indexOf(min)+1);
			result += min;
		}
		return result;
	}

	public String getWord() {
		return original;
	}

	public int length() {
		// TBD: implement this method
		return 0;
	}

}
