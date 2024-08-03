import javax.swing.*;
import java.awt.*;


public class CalculatorView extends JFrame{

    private JTextField display;
    private JButton[] numberButtons = new JButton[10];
    private JButton[] funcButtons = new JButton[6];
    private JButton addButton, subButton, mulButton, divButton, eqButton, clrButton;

    public CalculatorView(){

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 600);
        this.setLayout(new BorderLayout());

        display = new JTextField();

        addButton = new JButton("+");
        subButton = new JButton("-");
        mulButton = new JButton("*");
        divButton = new JButton("/");
        eqButton = new JButton("=");
        clrButton = new JButton("C");

        funcButtons[0] = addButton;
        funcButtons[1] = subButton;
        funcButtons[2] = mulButton;
        funcButtons[3] = divButton;
        funcButtons[4] = eqButton;
        funcButtons[5] = clrButton;


        for(int i=0; i<10; i++){
            numberButtons[i] = new JButton(String.valueOf(i));
        }

        // Add the display at the top
        display.setEditable(false);
        display.setPreferredSize(new Dimension(100, 60)); // Set preferred size
        this.add(display, BorderLayout.NORTH);

        JPanel myPanel = new JPanel();
        myPanel.setPreferredSize(new Dimension(350, 100));
        myPanel.setBackground(new Color(50, 50, 50));
        myPanel.setLayout(new GridLayout(4, 4, 10, 10));

        myPanel.add(numberButtons[7]);
        myPanel.add(numberButtons[8]);
        myPanel.add(numberButtons[9]);
        myPanel.add(mulButton);
        myPanel.add(numberButtons[4]);
        myPanel.add(numberButtons[5]);
        myPanel.add(numberButtons[6]);
        myPanel.add(subButton);
        myPanel.add(numberButtons[1]);
        myPanel.add(numberButtons[2]);
        myPanel.add(numberButtons[3]);
        myPanel.add(addButton);
        myPanel.add(clrButton);
        myPanel.add(numberButtons[0]);
        myPanel.add(divButton);
        myPanel.add(eqButton);

        this.add(myPanel);
        this.setVisible(true);

    }

    public JButton[] getNumberButtons(){
        return numberButtons;
    }

    public JButton[] getFuncButtons(){
        return funcButtons;
    }

    public String getDisplayValue(){
        return display.getText();
    }

    public void setDisplay(String value){
        display.setText(value);
    }

    public void clearDisplay(){
        display.setText("");
    }

    public void showDivisionErrorWindow(){
        JOptionPane.showMessageDialog(new JFrame(), "No division by 0. Resetting Values", "Division Error", JOptionPane.ERROR_MESSAGE);
    }

}
