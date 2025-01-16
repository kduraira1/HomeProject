package home;

class Trie {
    String endOfWord;
    Trie[] children = new Trie[26];

}

public class TrieGenerator {
    public Trie dictionary;

    public Trie getDictionary() {
        return this.dictionary;
    }
    TrieGenerator() {
        this.dictionary = new Trie();
    }
    public void addWord(String word) {
        Trie addToTrie = this.dictionary;

        for(char c : word.toCharArray()) {
            int index = c - 'a';
            if(addToTrie.children[c - 'a'] == null ) {
                addToTrie.children[ c - 'a'] = new Trie();
            }
            addToTrie = addToTrie.children[c - 'a'];

        }
        addToTrie.endOfWord = word;
    }

    public void addWordR(String word, int index, Trie addToTrie) {
        //home.Trie addToTrie = this.dictionary;
        if (word == null || index < 0 )return;
        if(index > word.length() ) return;
        if(index == (word.length())) {
            addToTrie.endOfWord = word;
            return;
        }
        if(addToTrie.children[word.charAt(index) - 'a'] == null ) {
            addToTrie.children[ word.charAt(index) - 'a'] = new Trie();
        }


        addWordR(word, index+1, addToTrie.children[word.charAt(index) - 'a']);
    }

    public boolean startsWith(String word) {
        Trie searchTrie = this.dictionary;
        for(char c : word.toCharArray()) {
            if(searchTrie.children[c - 'a'] == null ) {
                return false;
            }
            searchTrie = searchTrie.children[c - 'a'];
        }
        return true;

    }

    public boolean  startWithR(String word, int index, Trie addToTrie) {
        if (word == null || index < 0 )return false;
        if(index > word.length() ) return false;
        if(index == (word.length())) {
            return true;
        }
        if(addToTrie.children[word.charAt(index) - 'a'] == null ) {
            return false;
        }

        return startWithR(word, index+1, addToTrie.children[word.charAt(index) - 'a']);
    }
    public boolean  isWordExist(String word) {
        Trie searchTrie = this.dictionary;
        for(char c : word.toCharArray()) {
            if(searchTrie.children[c - 'a'] == null ) {
                return false;
            }
            searchTrie = searchTrie.children[c - 'a'];
        }
        return searchTrie.endOfWord == null ? false : searchTrie.endOfWord.equals(word);
    }

    public boolean  isWordExistR(String word, int index, Trie addToTrie) {
        if (word == null || index < 0 )return false;
        if(index > word.length() ) return false;
        if(index == (word.length())) {
            return addToTrie.endOfWord == null ? false : addToTrie.endOfWord.equals(word);
        }
        if(addToTrie.children[word.charAt(index) - 'a'] == null ) {
           return false;
        }

        return isWordExistR(word, index+1, addToTrie.children[word.charAt(index) - 'a']);
    }

    public static void main(String[] args) {
        TrieGenerator tg = new TrieGenerator();
        tg.addWord("tesasafasdfadfst");
        System.out.println( tg.isWordExist("tesasafasdfadfst"));
        System.out.println( tg.startsWith("tesasa"));
        tg.addWordR("abcd",0, tg.getDictionary());
        //tg.addWord("tesasafasdfadfstt");
        System.out.println( tg.isWordExistR("ab",0,tg.getDictionary()));
        System.out.println( tg.startWithR("ab", 0, tg.getDictionary()));
    }
}
