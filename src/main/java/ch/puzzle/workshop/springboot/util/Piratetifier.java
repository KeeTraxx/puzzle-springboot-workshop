package ch.puzzle.workshop.springboot.util;

import org.springframework.stereotype.Service;

@Service
public class Piratetifier {

    public String piratetify(String input) {
        return input.replaceAll("/ing(\\b)/", "in'$2")
                .replaceAll("(\\b)am|are|is(\\b)", "$1be$2" )
                .replaceAll("your?", "ye")
                .replaceAll("father", "salty sea-dog 'o a jeezer")
                .replaceAll("the", "th'")
                .replaceAll("with", "wit'");
    }
}
