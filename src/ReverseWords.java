public class ReverseWords {

    public String execute(String words) {
        words = words.trim();
        String[] splitWords = words.split("\\s+");
        StringBuilder result = new StringBuilder();
        for(String word : splitWords) {
            for(int i = word.length()-1; i >= 0; i--) {
                result.append(word.charAt(i));
            }
            result.append( " ");
        }

        return result.toString().trim();
    }
    public static void main (String[] args) {


        ReverseWords rw = new ReverseWords();
        String words = "This is the test for reverse the string";
        System.out.println(rw.execute(words));
    }
}
