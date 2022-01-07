package main;

import actions.Round0;
import checker.Checker;
import com.fasterxml.jackson.databind.ObjectMapper;
import enums.Category;
import input.Child;
import input.Gift;
import input.Input;
import output.Output;

import java.io.File;
import java.io.IOException;

/**
 * Class used to run the code
 */
public final class Main {

    private Main() {
        ///constructor for checkstyle
    }
    /**
     * This method is used to call the checker which calculates the score
     * @param args
     *          the arguments used to call the main method
     */
    public static void main(final String[] args) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Input input = objectMapper.readValue(new File("tests/test1.json"), Input.class);
        Output output = new Output();
        Round0.execute(input, output);
        //System.out.println(input.getInitialData().getSantaGiftsList().get(0).getCategory());

        objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File("output/test4.json"), output);
        Checker.calculateScore();
    }
}
