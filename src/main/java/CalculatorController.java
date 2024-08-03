import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorController implements ActionListener{
    private double num1, num2;
    String operator;
    double result;
    private JButton[] numButtons;
    private JButton[] funcButtons;
    private CalculatorModel model;
    private CalculatorView view;

    public CalculatorController(CalculatorModel model, CalculatorView view) {
        this.model = model;
        this.view = view;
        this.numButtons = this.view.getNumberButtons();
        this.funcButtons = this.view.getFuncButtons();
        this.addCalculatorListener();

    }

    public void addCalculatorListener(){
        for (JButton numButton : numButtons){
            numButton.addActionListener(this);
        }
        for (JButton funcButton : funcButtons){
            funcButton.addActionListener(this);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for(int i = 0; i < numButtons.length; i++){
            if(e.getSource() == numButtons[i]){
                this.view.setDisplay(this.view.getDisplayValue().concat(String.valueOf(i)));
            }
        }
        for(JButton funcButton : funcButtons){
            if(e.getSource() == funcButton){
                switch (funcButton.getText()){
                    case "C":
                        this.view.clearDisplay();
                        break;
                    case "=":
                        this.num2 = Double.parseDouble(this.view.getDisplayValue());
                        result = performOperation(num1, num2, operator);
                        this.view.setDisplay(Double.toString(result));
                        break;
                    default:
                        this.num1 = Double.parseDouble(this.view.getDisplayValue());
                        this.operator = funcButton.getText();
                        this.view.setDisplay(this.view.getDisplayValue().concat(funcButton.getText()));
                        this.view.clearDisplay();
                }

            }
        }
    }

    public double performOperation(double num1, double num2, String operator){
        switch (operator){
            case "+":
                result = this.model.add(num1, num2);
                break;
            case "-":
                result = this.model.sub(num1, num2);
                break;
            case "*":
                result = this.model.mul(num1, num2);
                break;
            case "/":
                if(num2 == 0){
                    this.view.showDivisionErrorWindow();
                    resetCalculator();
                }
                result = this.model.div(num1, num2);
                break;
        }
        return result;
    }

    public void resetCalculator(){
        num1 = 0;
        num2 = 0;
        operator = "";
        result = 0;
        view.clearDisplay();
    }
}
