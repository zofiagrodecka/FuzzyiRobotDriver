import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.rule.FuzzyRuleSet;

public class FuzzyDriver {
    private final FuzzyRuleSet fuzzyRuleSet;

    public FuzzyDriver(String fileName){
        FIS fis = FIS.load(fileName,false);
        this.fuzzyRuleSet = fis.getFuzzyRuleSet();
        fuzzyRuleSet.chart();
    }

    public void setVariables(double frontSensor, double rightSensor, double leftSensor, double backSensor){
        fuzzyRuleSet.setVariable("front_distance", frontSensor/10.0);  // dm to m
        fuzzyRuleSet.setVariable("right_distance", rightSensor/10.0);
        fuzzyRuleSet.setVariable("left_distance", leftSensor/10.0);
        fuzzyRuleSet.setVariable("back_distance", backSensor/10.0);
    }

    public double getResult(){
        fuzzyRuleSet.evaluate();
        return fuzzyRuleSet.getVariable("angle").getLatestDefuzzifiedValue();
    }

}
