package mechanics;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class EnglishWords {

    public static Predicate<String> getFilteredLetterPredicate(Set<Character> letters) {
        return s -> {
            for (char p : s.toCharArray())
                if (!letters.contains(p))
                    return false;
            return true;
        };
    }

    public static final List<String> getFilteredWords(Predicate<String> t) {
        try {
            return Files.lines(Paths.get(new File("enable1.txt").toURI())).filter(t).collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
