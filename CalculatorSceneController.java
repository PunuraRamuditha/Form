import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class CalculatorSceneController {

    @FXML
    private TextField textfeild;

    @FXML

    private Text savedNumbers;

    private String firstNumber ="";

    private String currentNumber="";

    private String calculationType;

    private String outputNumber= "";

    private String symbol= "";

    @FXML
    void btnAdditionClick(ActionEvent event) {
        if (symbol == ""){
            calculationSetup("+");
            symbol = "+";
        }
        else {
            calculate();
            symbol = "";
            calculationSetup("+");
        }
        
    }

    @FXML
    void btnDivideClick(ActionEvent event) {
        calculationSetup("/");
    }

    @FXML
    void btnMultiplyClick(ActionEvent event) {
        calculationSetup("*");
    }

    @FXML
    void btnPercentageClick(ActionEvent event) {
        percentageprep();
    }

    public void backspaceprep() {
        String backspace = null;
        if(textfeild.getText().length()>0) {
            StringBuilder strBuilder = new StringBuilder(textfeild.getText());
            strBuilder.deleteCharAt(textfeild.getText().length()-1);
            backspace = strBuilder.toString();
            textfeild.setText(backspace);
        }
    }

    private void percentageprep() {
        String checktf = textfeild.getText();
        int checktfint = Integer.parseInt(checktf);
        if(textfeild.getText().length()>0 && checktfint != 0){
        double percentageVal1 = Double.parseDouble(currentNumber);
        double percentageD = percentageVal1/100 ;
        currentNumber = Double.toString(percentageD);
        updatetextfeild();
        }
        else{
            textfeild.setText("Error!");
        }
    }

    @FXML
    void btnSubstractClick(ActionEvent event) {
        calculationSetup("-");
    }

    public void calculationSetup(String calculationType){
        this.calculationType = calculationType;
        if(outputNumber == ""){
            

        firstNumber = currentNumber;
        currentNumber = "";
        savedNumbers.setText(firstNumber + " " + calculationType);
    }
    else{
     firstNumber = outputNumber;
        currentNumber = "";
        savedNumbers.setText(firstNumber + " " + calculationType);
        
    }
        
    
}

    @FXML
    void btnAnswerClick(ActionEvent event) {
        calculate();
    }

    public void calculate(){
        int firstNumberInt = Integer.parseInt(firstNumber);
        int secondNumberInt = Integer.parseInt(currentNumber);
        

        
        
        switch (calculationType) {
            case "+" -> {
                int calculatedNumber = firstNumberInt + secondNumberInt;
                savedNumbers.setText(firstNumber + " + " + currentNumber + " = " + calculatedNumber);
                textfeild.setText(String.valueOf(calculatedNumber));
                outputNumber = Integer.toString(calculatedNumber);
            }
            case "-" -> {
                int calculatedNumber = firstNumberInt - secondNumberInt;
                savedNumbers.setText(firstNumber + " - " + currentNumber + " = " + calculatedNumber);
                textfeild.setText(String.valueOf(calculatedNumber));
                outputNumber = Integer.toString(calculatedNumber);
            }
            case "/" -> {
                double calculatedNumber = firstNumberInt / (double)secondNumberInt;
                savedNumbers.setText(firstNumber + " / " + currentNumber + " = " + calculatedNumber);
                textfeild.setText(String.valueOf(calculatedNumber));
                outputNumber = Double.toString(calculatedNumber);
            }
            case "*" -> {
                int calculatedNumber = firstNumberInt * secondNumberInt;
                savedNumbers.setText(firstNumber + " * " + currentNumber + " = " + calculatedNumber);
                textfeild.setText(String.valueOf(calculatedNumber));
                outputNumber = Integer.toString(calculatedNumber);
            }
        }
    
} 


    @FXML
    void btn(ActionEvent event) {

    }

    @FXML
    void btn0Click(ActionEvent event) {
         if(!currentNumber.equals("")){
            addNumber("0");
        }  
    }

    @FXML
    void btn1Click(ActionEvent event) {
        addNumber("1");
    }

    @FXML
    void btn2Click(ActionEvent event) {
        addNumber("2");
    }

    @FXML
    void btn3Click(ActionEvent event) {
        addNumber("3");
    }

    @FXML
    void btn4Click(ActionEvent event) {
        addNumber("4");
    }

    @FXML
    void btn5Click(ActionEvent event) {
        addNumber("5");
    }

    @FXML
    void btn6Click(ActionEvent event) {
        addNumber("6");
    }

    @FXML
    void btn7Click(ActionEvent event) {
        addNumber("7");
    }

    @FXML
    void btn8Click(ActionEvent event) {
        addNumber("8");
    }

    @FXML
    void btn9Click(ActionEvent event) {
        addNumber("9");
    }

    

   

    

    @FXML
    void btnBackspaceClick(ActionEvent event) {
        backspaceprep();
    }

    
    @FXML
    void btnClearClick(ActionEvent event) {
        currentNumber = "";
        textfeild.setText("");
    }

    @FXML
    void btnClearallClick(ActionEvent event) {
        currentNumber = "";
        textfeild.setText("");
        savedNumbers.setText("");
        outputNumber = "";
        symbol = "";
    }

    

    @FXML
    void btnHistoryClick(ActionEvent event) {

    }

   
    
    @FXML
    void btnPointClick(ActionEvent event) {
        decimalNum(".");   
    }

    
    private void decimalNum(String string) {
    }

    public void updatetextfeild() {
        textfeild.setText(currentNumber);
    }

    public void addNumber(String Number){
        currentNumber += Number;
        updatetextfeild();
    }

    


}
