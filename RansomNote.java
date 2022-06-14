import java.util.HashMap;
import java.util.Scanner;

public class RansomNote {
    String[] magazine;
    String[] note;
    HashMap<String, Integer> wordsNote = new HashMap<>();
    HashMap<String, Integer> wordsMagazine = new HashMap<>();

    private void input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of words in magazine and note: ");
        int m = Integer.parseInt(sc.next());
        int n = Integer.parseInt(sc.next());
        if(m < 1 || m > 30000 || n < 1 || n > 30000) {
            System.out.println("Invalid size! \nTry again.");
            input();
        }
        if(n>m) {
            System.out.println("Note length cannot be greater than magazine length!\n Try again");
            input();
        }
        magazine = new String[m];
        note = new String[n];
        System.out.println("Enter words in magazine: ");
        for(int i = 0; i<magazine.length; i++) {
            magazine[i] = sc.next();
            if(magazine[i].length() < 1 || magazine[i].length() > 5) {
                System.out.println("Too big words! \nTry again.");
                input();
            }
            if(!magazine[i].matches("[a-zA-Z]+")) {
                System.out.println("Use alphabets only! \nTry again.");
            }
        }
        System.out.println("Enter words in note: ");
        for(int i = 0; i<note.length; i++) {
            note[i] = sc.next();
            if(note[i].length() < 1 || note[i].length() > 5) {
                System.out.println("Too big words! \nTry again.");
                input();
            }
            if(!note[i].matches("[a-zA-Z]+")) {
                System.out.println("Use alphabets only! \nTry again.");
            }
        }
        int i=0;
        for (String word:magazine) {
            wordsMagazine.put(word, i);
            i++;
        }
        i=0;
        for (String word:note) {
            wordsNote.put(word, i);
            i++;
        }
    }

    private boolean checkMagazine() {
        int x=wordsNote.size();
        for(int i=0; i<x; i++) {
            if(wordsMagazine.containsKey(note[i])) {
                wordsNote.remove(note[i]);
                wordsMagazine.remove(note[i]);
            }
            if(wordsNote.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        RansomNote ob = new RansomNote();
        ob.input();
        if(ob.checkMagazine()) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
