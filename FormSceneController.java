import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;

public class FormSceneController {

    String Input = "";

    @FXML
    private AnchorPane Dynamic;

    @FXML
    private ToggleGroup Gender;

    @FXML
    private Button btnSubmit;

    @FXML
    private Button btnView;

    @FXML
    private RadioButton rbutton1;

    @FXML
    private RadioButton rbutton2;

    @FXML
    private TextField tfContact;

    @FXML
    private TextField tfFname;

    @FXML
    private TextField tfEmail;

    @FXML
    private TextField tfLname;

    @FXML
    void GetGender(ActionEvent event) {

    }

    @FXML
    void Submit(ActionEvent event) {

        String Fname = tfFname.getText();
        String Lname = tfLname.getText();
        String Email = tfEmail.getText();
        String Contact  = tfContact.getText();

        tfFname.setText("");
        tfLname.setText("");
        tfEmail.setText("");
        tfContact.setText("");


        Input = (Fname + "," + Lname + "," + Email + "," + Contact  + System.lineSeparator());
        submit();
        
        }
        public void submit(){
            try{
                File file = new File("Details.txt");
                    if(!file.exists()){
                        file.createNewFile();
                    }
                FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
                BufferedWriter bw = new BufferedWriter(fw);
                bw.write(Input);
                bw.close();
                JOptionPane.showMessageDialog(null,"successfully entered");
            }
            catch(IOException el){
                el.printStackTrace();
            }
        }
        

    

   

    @FXML
    void View(ActionEvent event) throws IOException {
        setDynamic(FXMLLoader.load(getClass().getResource("FormTable.fxml")));


    }
        private void setDynamic(AnchorPane Dynamic){
            this.Dynamic.getChildren().clear();
            this.Dynamic.getChildren().add(Dynamic);
        }
    }




