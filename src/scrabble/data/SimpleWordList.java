package lab06.src.scrabble.data;

import lab06.src.scrabble.util.Permutation;
import lab06.src.scrabble.util.SubSets;
import org.junit.jupiter.api.DisplayNameGenerator;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class SimpleWordList implements WordList {

	public Collection<String> words = new HashSet<>();

	@Override
	public Set<String> validWordsUsingAllTiles(String tileRackPart) {
		Set<String> result = new HashSet<>();
		Permutation permuTileRack = new Permutation(tileRackPart);
		for(String word: words) {
			Permutation permuWord = new Permutation(word);
			if(permuWord.equals(permuTileRack)) result.add(word);
		}
		return result;
	}

	@Override
	public Set<String> allValidWords(String tileRack) {
		Set<String> result = new HashSet<>();
		SubSets aux = new SubSets();
		Set<String> allPossiblePermutations = aux.getSubSets(tileRack);
		for(String word : allPossiblePermutations) {
			result.addAll(validWordsUsingAllTiles(word));
		}
		return result;
	}

	@Override
	public boolean add(String word) {
		words.add(word);
		return true;
	}

	@Override
	public boolean addAll(Collection<String> words) {
		this.words.addAll(words);
		return true;
	}

	@Override
	public int size() {
		return words.size();
	}

	@Override
	public WordList initFromFile(String fileName) throws FileNotFoundException {
		SimpleWordList wl = new SimpleWordList();
		File file = new File(fileName);
		Scanner myReader = new Scanner(file);
		while (myReader.hasNextLine()) {
			wl.words.add(myReader.nextLine());
		}
		return wl;
	}

	public static void main (String [] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please insert here the letters you have in your tile rack: ");
		String str = "hell";
		WordList game = new SimpleWordList();
		game = game.initFromFile("/Users/martin/IdeaProjects/Info2/src/lab06/wordlists/sowpods.txt");
		Set<String> allValidWords = game.allValidWords(str);
		System.out.print("The words you can form with those letters are: \n");
		for(String word : allValidWords) {
			System.out.print(word + "\n");
		}
	}

	/*public static void main (String [] args) throws FileNotFoundException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Please insert here the letters you have in your tile rack: ");
		String str = sc.nextLine();
		while(str.length() > 7) {
			System.out.println("You can't have more than 7 letters! You're doing something wrong. Try again: ");
			str = sc.nextLine();
		}
		WordList game = new SimpleWordList();
		game = game.initFromFile("/Users/martin/IdeaProjects/Info2/src/lab06/wordlists/sowpods.txt");
		Set<String> allValidWords = game.allValidWords(str);
		System.out.print("The words you can form with those letters are: \n");
		for(String word : allValidWords) {
			System.out.print(word + "\n");
		}
	}*/

}
