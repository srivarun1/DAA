package DataStructures;

public class TrieOperations {

    TrieNode head = new TrieNode();

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode trav = head;

        for(Character c : word.toCharArray())
        {
            trav.nextChar.put(c,new TrieNode());
            trav = trav.nextChar.get(c);
        }
        trav.isEndOfWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode trav = head;
        for(Character c: word.toCharArray())
        {
            if(trav.nextChar.containsKey(c))
            {
                trav = trav.nextChar.get(c);
            }
            else
            {
                return false;
            }
        }
        return trav.isEndOfWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode trav = head;
        for(Character c : prefix.toCharArray())
        {
            if(trav.nextChar.containsKey(c))
            {
                trav = trav.nextChar.get(c);
            }
            else
            {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args)
    {
        TrieOperations to = new TrieOperations();
        to.insert("watermelon");
        to.insert("water");
        System.out.println(to.startsWith("wat"));
        System.out.println(to.search("water"));
        System.out.println(to.search("wat"));
        System.out.println(to.startsWith("king"));
    }
}
