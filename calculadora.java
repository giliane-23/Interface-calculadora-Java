import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Arrays;
import javax.swing.border.LineBorder;

// Classe principal da calculadora
public class calculadora implements ActionListener {

// Configurações da calculadora
    int boardWidth = 360;
    int boardHeight = 540;
// Cores personalizadas
    Color customLightGrayColor = new Color(212, 212, 212);
    Color customDarkGrayColor = new Color(35, 35, 35);
    Color customBlackColor = new Color(50, 50, 50);
    Color customOrangeColor = new Color(50, 50, 50);

// Variaveis de controle
    double primeironumero=0;
    double segundonumero=0;
    double resultado=0;
    String operacao="";
    boolean novoNumero=true;

// Valores dos botões
    String[] buttonValues = {
        "AC", "+/-", "%", "÷",
        "7", "8", "9", "x",
        "4", "5", "6", "-",
        "1", "2", "3", "+",
        "0", ".", "√", "="
    };

 // Símbolos especiais
    String[] topSymbols = {"AC", "+/-", "%", "÷"};
    String[] rightSymbols = {"x", "-", "+", "√", "="};

// Componentes da interface
    JFrame frame = new JFrame("CALCULADORA");
    JPanel displayPanel = new JPanel();
    JLabel displayLabel = new JLabel();
    JPanel buttoJPanel= new JPanel();

// Construtor da calculadora
    public calculadora() {
        frame.setVisible(true);
        frame.setSize(boardWidth, boardHeight);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());
    //Quadro de display
        displayLabel.setBackground(customBlackColor);
        displayLabel.setForeground(Color.WHITE);
        displayLabel.setFont(new Font("Arial", Font.PLAIN, 80));
        displayLabel.setHorizontalAlignment(JLabel.RIGHT);
        displayLabel.setOpaque(true);  
        displayLabel.setText("0"); 

//Painel de display
        displayPanel.setLayout(new BorderLayout());
        displayPanel.add(displayLabel);
        frame.add(displayPanel, BorderLayout.NORTH);
//Painel de botões
        buttoJPanel.setLayout(new GridLayout(5, 4));
        buttoJPanel.setBackground(customBlackColor);
        frame.add(buttoJPanel);
// Adiciona os botões ao painel
        for(int i=0; i< buttonValues.length; i++){
             JButton button = new JButton();
             String buttonValue = buttonValues[i];
             button.setFont(new Font("Arial", Font.PLAIN, 30));
             button.setText(buttonValue);
             button.setFocusable(false);
            button.addActionListener(this);
        buttoJPanel.add(button);

     }
    
    }
// Ação dos botões
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        String buttonText = button.getText();
        
        if (buttonText.equals("AC")) {
            primeironumero = 0;
            segundonumero = 0;
            resultado = 0;
            operacao = "";
            novoNumero = true;
            displayLabel.setText("0");
        } else if (buttonText.equals("=")) {
            segundonumero = Double.parseDouble(displayLabel.getText());
            resultado = calcular(primeironumero, segundonumero, operacao);
            displayLabel.setText(String.valueOf(resultado));
            primeironumero = resultado;
            novoNumero = true;
        } else if (buttonText.equals("+") || buttonText.equals("-") || buttonText.equals("x") || buttonText.equals("÷")) {
            primeironumero = Double.parseDouble(displayLabel.getText());
            operacao = buttonText;
            novoNumero = true;
        } else {
            if (novoNumero) {
                displayLabel.setText(buttonText);
                novoNumero = false;
            } else {
                displayLabel.setText(displayLabel.getText() + buttonText);
            }
        }
    }
// Método de cálculo
    private double calcular(double num1, double num2, String operador) {
        switch (operador) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "x":
                return num1 * num2;
            case "÷":
                return num1 / num2;
                case "√":
                return Math.sqrt(num1);
                case "%":
                return num1 % num2;
                case "+/-":
                return -num1;   
                case "":
                return num2;
                case "AC":
                return 0;   
                case ".":
                return num1;    
                case "0":
                return 0;
            default:
                return 0;
        }
    }
}

 

