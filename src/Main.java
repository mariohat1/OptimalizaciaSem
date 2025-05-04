import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        Heuristika heuristika = new Heuristika();
        heuristika.algoritmus();
        heuristika.printToFile("primarnaVsuvaciaHeurisitka");
        heuristika.printResults();
        heuristika.betterSolution();
        heuristika.printToFile("vylepsenieHeuristiky");
        heuristika.printResults();

    }
}