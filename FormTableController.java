import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Collection;
import java.util.stream.Collectors;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Callback;

public class FormTableController {

    @FXML
    private AnchorPane TableDynamic;

    @FXML
    private Button Back;

    @FXML
    private TableColumn<InputData,String> Contact;

    @FXML
    private TableColumn<InputData,String> Email;

    @FXML
    private TableColumn<InputData,String> Fname;

    @FXML
    private TableColumn<?, ?> Gender;

    @FXML
    private TableColumn<InputData,String> Lname;

    @FXML
    private TableView<InputData> TableView;

    @FXML
    void Back(ActionEvent event) throws IOException{
        setDynamicPane(FXMLLoader.load(getClass().getResource("FormTable.fxml")));
    }

    private void setDynamicPane(AnchorPane TableDynamic){
        this.TableDynamic.getChildren().clear();
        this.TableDynamic.getChildren().add(TableDynamic);
    }

    public void initialize() throws IOException{
        Collection<InputData> list = Files.readAllLines(new File("details.txt").toPath())
                .stream()
                .map(line -> {
                    String[] details = line.split(",");
                    InputData cd = new InputData();
                    cd.setDataFname(details[0]);
                    cd.setDataLname(details[1]);
                    cd.setDataEmail(details[2]);
                    cd.setDataContact(details[3]);
                    return cd;
                })
                .collect(Collectors.toList());

        ObservableList<InputData> details = FXCollections.observableArrayList(list);

        Fname.setCellValueFactory(data -> data.getValue().DataFnameProperty());
        Lname.setCellValueFactory(data -> data.getValue().DataLnameProperty());
        Email.setCellValueFactory(data -> data.getValue().DataEmailProperty());
        Contact.setCellValueFactory(data -> data.getValue().DataContactProperty());
        TableView.setItems(details);
        addButtonToTable();
        }

        public void deletedata(String Value) throws Exception{
            File inputFile = new File("Details.txt");
                                File tempFile = new File("myTempFile.txt");

                                BufferedReader reader = new BufferedReader(new FileReader(inputFile));
                                BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

                                String lineToRemove = Value;
                                String currentLine;

                                while((currentLine = reader.readLine()) != null) {
                                // trim newline when comparing with lineToRemove
                                String trimmedLine = currentLine.trim();
                                if(trimmedLine.equals(lineToRemove)) continue;
                                writer.write(currentLine + System.getProperty("line.separator"));
                            }
                            writer.close(); 
                            reader.close(); 
                            inputFile.delete();
                            tempFile.renameTo(inputFile);
        }

        private void addButtonToTable(){
            TableColumn<InputData, Void> ColHandler = new TableColumn<InputData, Void>("Handler");
            Callback<TableColumn<InputData, Void>, TableCell<InputData, Void>> cellFactory = new Callback<TableColumn<InputData, Void>, TableCell<InputData, Void>>() {
                @Override
                public TableCell<InputData, Void> call(final TableColumn<InputData, Void> param) {
                    final TableCell<InputData, Void> cell = new TableCell<InputData, Void>() {
    
                        private final Button btn = new Button("Delete");
    
                        {
                            btn.setOnAction((ActionEvent event) -> {
                                InputData index = TableView.getItems().get(getIndex());
                                String DelFname = index.getDataFname();
                                String DelLname = index.getDataLname();
                                String DelEmail = index.getDataEmail();
                                String DelContact = index.getDataContact();
                                TableView.getItems().remove(getIndex());
                                String Value = (DelFname + "," + DelLname + "," + DelEmail + "," + DelContact);
                                try {
                                    deletedata(Value);
                                } catch (Exception e) {
                                    System.out.println("error");
                                }
                                                });
                        }
    
                        @Override
                        public void updateItem(Void item, boolean empty) {
                            super.updateItem(item, empty);
                            if (empty) {
                                setGraphic(null);
                            } else {
                                setGraphic(btn);
                            }
                        }
                    };
                    return cell;
                }
            };
    
            ColHandler.setCellFactory(cellFactory);
    
            TableView.getColumns().add(ColHandler);
    
        }

}


