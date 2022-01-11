import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.rule.FuzzyRuleSet;

public class Main {
    public static void main(String[] args) throws Exception {
        /*try {
            String fileName = args[0];
            double frontSensor = Double.parseDouble(args[1]);
            double rightSensor = Double.parseDouble(args[2]);
            double leftSensor = Double.parseDouble(args[3]);
            double backSensor = Double.parseDouble(args[4]);
            FIS fis = FIS.load(fileName,false);

//wyswietl wykresy funkcji fuzyfikacji i defuzyfikacji
            FuzzyRuleSet fuzzyRuleSet = fis.getFuzzyRuleSet();
            fuzzyRuleSet.chart();

//zadaj wartosci wejsciowe
            fuzzyRuleSet.setVariable("front_distance", frontSensor);
            fuzzyRuleSet.setVariable("right_distance", rightSensor);
            fuzzyRuleSet.setVariable("left_distance", leftSensor);
            fuzzyRuleSet.setVariable("back_distance", backSensor);
//logika sterownika
            fuzzyRuleSet.evaluate();

//graficzna prezentacja wyjscia
            fuzzyRuleSet.getVariable("angle").chartDefuzzifier(true);
            System.out.println(fuzzyRuleSet.getVariable("angle").getLatestDefuzzifiedValue());

//System.out.println(fuzzyRuleSet);

        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Niepoprawna liczba parametrow. Przyklad: java FuzzyExample string<plik_fcl> int<poziom natezenia> int<pora dnia>");
        } catch (NumberFormatException ex) {
            System.out.println("Niepoprawny parametr. Przyklad: java FuzzyExample string<plik_fcl> int<poziom natezenia> int<pora dnia>");
        } catch (Exception ex) {
            System.out.println(ex.toString());
        }*/

        Simulation simulation = new Simulation(args[0]);

        try {
            simulation.start();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }

}
