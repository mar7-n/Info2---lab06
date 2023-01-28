package lab06.src.scrabble.data;

import lab06.src.scrabble.util.Permutation;
import lab06.src.scrabble.util.SubSets;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class OwnHashWordList implements WordList{

    Map<String,Set<String>> words = new HashMap<>();
    @Override
    public Set<String> validWordsUsingAllTiles(String tileRackPart) {
        Permutation permutationWord = new Permutation(tileRackPart);
        String wordNormalized = permutationWord.getNormalized();
        return words.getOrDefault(wordNormalized, null);
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
        return false;
    }

    @Override
    public boolean addAll(Collection<String> words) {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public WordList initFromFile(String fileName) throws FileNotFoundException {
        OwnHashWordList wl = new OwnHashWordList();
        File file = new File(fileName);
        Scanner myReader = new Scanner(file);
        while (myReader.hasNextLine()) {
            String word = myReader.nextLine();
            Permutation permutationWord = new Permutation(word);
            String wordNormalized = permutationWord.getNormalized();
            if(wl.words.containsKey(wordNormalized)) {
                wl.words.get(wordNormalized).add(word);
            } else {
                wl.words.put(wordNormalized,new HashSet<>());
                wl.words.get(wordNormalized).add(word);
            }
        }
        return wl;
    }
}
