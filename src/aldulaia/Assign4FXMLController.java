package aldulaia;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class Assign4FXMLController implements Initializable {

    @FXML
    private TextField txtItemId, txtItemName, txtQtyOnHand, txtReOrderPoint, txtSellPrice;
    @FXML
    private ListView<Inventory> listViewSummary;
    @FXML
    private Label lblSummary,lbl1,lbl2,lbl3,lbl4,lbl5 ;
    @FXML
    private Button btnAdd, btnSave, btnOrders, btnExit;
    @FXML
    private TextField[] txtFields;

    InventoryList list1 = new InventoryList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //set Text's to labels through ENUMS
        lbl1.setText(Fields.ITEM_ID.getCaption() + " :");
        lbl2.setText(Fields.ITEM_NAME.getCaption() + " :");
        lbl3.setText(Fields.QOH.getCaption() + ":");
        lbl4.setText(Fields.ROH.getCaption() + " :");
        lbl5.setText(Fields.PRICE.getCaption() + " :");
        

        //An array of TextFields
        txtFields = new TextField[]{txtItemId, txtItemName, txtQtyOnHand, txtReOrderPoint, txtSellPrice};
        
        //Add Button
        btnAdd.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {

                btnAdd.setDisable(true);
                btnSave.setDisable(false);

                for (TextField e : txtFields) {
                    e.setEditable(true);
                    e.setText("");
                }

            }
        });

        //Save Button
        btnSave.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                btnAdd.setDisable(false);
                btnOrders.setDisable(false);
                btnOrders.setDisable(false);

                Inventory n1 = new Inventory();
                try {
                    n1.setId(txtItemId.getText());
                    n1.setName(txtItemName.getText());
                    n1.setQoh(Integer.parseInt(txtQtyOnHand.getText()));
                    n1.setRop(Integer.parseInt(txtReOrderPoint.getText()));
                    n1.setSellPrice(Double.parseDouble(txtSellPrice.getText()));
                    list1.add(n1);
                } catch (Exception f) {
                    String err = f.getMessage();
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Invalid input Error");
                    alert.setHeaderText(null);
                    alert.setContentText(err);
                    alert.showAndWait();
                }

            }
        });

        //Order Button
        btnOrders.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {

                for (int i = 0; i < list1.length(); i++) {
                    if (list1.get(i).getQoh() < list1.get(i).getRop()) {
                        listViewSummary.getItems().add(list1.get(i));
                    }

                }

                if (list1.length() == 0) {
                    lblSummary.setText("No items to list. Add Some!");
                }
                for (int i = 0; i < list1.length(); i++) {
                    if (list1.get(i).getRop() < list1.get(i).getQoh()) {
                        lblSummary.setText("No items to Re-order.");
                    } else {
                        lblSummary.setText("");

                    }

                }
                btnSave.setDisable(false);
                btnOrders.setDisable(true);
            }

        });

        //Exit Button
        btnExit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent t) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Exit");
                alert.setContentText("Exit Program ?");
                ButtonType okButton = new ButtonType("Yes", ButtonBar.ButtonData.YES);
                ButtonType noButton = new ButtonType("No", ButtonBar.ButtonData.NO);
                alert.getButtonTypes().setAll(okButton, noButton);
                alert.showAndWait().ifPresent(type -> {
                    if (type == okButton) {
                        System.exit(0);
                    }

                });
            }

        });

        //ListView Trigger
        listViewSummary.getSelectionModel().selectedItemProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable o) {
                int i = listViewSummary.getSelectionModel().getSelectedIndex();
                Inventory p = listViewSummary.getSelectionModel().getSelectedItem();
                lblSummary.setText("Re-Order Point: " + list1.get(i).getRop());
            }
        });

    }
}
