import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Palindrome {
    // This may look a bit strange, since we're actually returning a Predicate object.  Predicates accept
    // any argument (Predicate<E>) and return a boolean if the argument "E" matches or not.
    // In this case, we're returning Predicate<Character> (taking in the `character` parameter)
    // and checking whether or not the argument is contained within the string "AEIOU".
    public static final Predicate<Character> VOWELS = character -> "AEIOU".contains(Character.toUpperCase(character) + "");

    public static void main(String[] args) {
        String[] tests = {"level", "this is not a palindrome"};

        Stream.of(tests).map(Palindrome::new).forEach(p -> {
            String result = p.isPalindrome() ? "is" : "is not";
            System.out.println("\"" + p.word() + "\" " + result + " a palindrome.");
        });
    }

    protected final String str;
    public Palindrome(String subject) {
        this.str = this.removeJunk(subject);
    }

    public String word() {
        return this.str;
    }

    public boolean isPalindrome() {
        return this.str.equals(this.inReverse());
    }

    private String inReverse() {
        List<Character> chars = chars(str).collect(Collectors.toList());
        Collections.reverse(chars);

        return chars.stream().reduce("", (acc, c) -> acc+c, String::join);
    }

    public int countVowels() {
        return (int) Palindrome.chars(str) // Once again, create a Stream<Character>
                                   .filter(VOWELS) // Filter out only the vowels
                               .count(); // And count (unluckily, this returns a long, hence the cast above)
    }

    private static String reduce(Stream<Character> stream) {
        return stream // Take the stream
                .sequential().reduce("", // In-order, reduce it
                                    // Below, the accumulator represents the current "buildup" of the String
                                    // That we're trying to create
                                    (accumulator, character) -> accumulator + character, // Take a character, add it to the String
                                    String::join); // Finally, join all the parts together using String::Join
    }

    private static String removeJunk(String str) {
        return reduce( // Given the filtered argument, reduce it to a String (see below)
                // Take the CharacterStream, and in no-order, return a Stream containing
                // only the vowels of the original String
                chars(str).sequential().filter(Character::isAlphabetic)
        );
    }

    public static Stream<Character> chars(String str) {
        // Oddly enough, String#chars actually returns an IntStream.  To circumvent this annoyance,
        // I created this convenience method to map the ints to chars.

        // Though in actuality, this is sort of a hack and I should probably subclass
        // IntStream to `CharStream`.  Might be overkill.
        return str.chars().mapToObj(i -> (char) i);
    }
}
