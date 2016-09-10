package ch.puzzle.workshop.springboot.util;

import org.springframework.stereotype.Service;

@Service
public class Piratetifier {

    public String piratetify(String input) {
        String output = input.replaceAll("ing(\\b)", "in'$1")
                .replaceAll("(\\b)am|are|is(\\b)", "$1be$2" )
                .replaceAll("(?i)your?", "ye")
                .replaceAll("(?i)father", "salty sea-dog 'o a jeezer")
                .replaceAll("(?i)the", "th'")
                .replaceAll("(?i)with", "wit'");

        if (output.equals(input)) {
            output += " Ye scurvy dog!";
        }
        return output;
    }
}
