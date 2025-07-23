public class TextProcessor {

    //count words in a sentence
    public static int countWords(String sentence){
        if(sentence==null){
            System.out.println("invalid. empty string");
            return 0;}
        String[] words=sentence.split("\\s+");
        return words.length;
    }//end method

    public static String replaceWord(String text, String oldWord, String newWord){
        if(text==null|| oldWord==null || newWord==null)
            return text;
        String newText=text.replaceAll(oldWord, newWord); //replace old words with new words
        return newText;
    } //end method

    public static void main(String[] args) {
      String sentence= "Java is fun and Java is powerful";
      int count=countWords(sentence);
      String newSentence=replaceWord(sentence, "Java", "Programming");
        System.out.println("Number of words in sentence: " + count);
        System.out.println("New sentence: "+ newSentence);

    } //end main
    }


