public class TextProcessor {

    //count words in a sentence
    public static int countWords(String sentence){
        if(sentence==null)
            return 0;
        String[] words=sentence.split("\\s+");
        return words.length;
    }//end method
}
