package seedu.duke;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

/**
 * Controller for MainWindow. Provides the layout for the other controls.
 */
public class MainWindow extends AnchorPane {
    @FXML
    private ScrollPane scrollPane;
    @FXML
    private VBox dialogContainer;
    @FXML
    private TextField userInput;
    @FXML
    private Button sendButton;

    private Duke duke;
    private Image userImage = new Image(this.getClass().getResourceAsStream("/images/DaUser.png"));
    private Image dukeImage = new Image(this.getClass().getResourceAsStream("/images/DaDuke.png"));

    /**
     * Class constructor.
     */
    public MainWindow() {}

    /**
     * Initialises the layout for the main window.
     */
    @FXML
    public void initialize() {
        Ui ui = new Ui();
        dialogContainer.getChildren().add(DialogBox.getDukeDialog(ui.showIntro(), dukeImage));
        scrollPane.vvalueProperty().bind(dialogContainer.heightProperty());
    }

    /**
     * Sets the duke attribute of Main Window.
     */
    public void setDuke(Duke d) {
        duke = d;
        duke.load();
    }

    /**
     * Creates two dialog boxes, one echoing user input and the other containing Duke's reply and then appends them to
     * the dialog container. Clears the user input after processing.
     */
    @FXML
    private void handleUserInput() {
        String input = userInput.getText();
        String response = duke.getResponse(input);

        var db = DialogBox.getDukeDialog(response, dukeImage);
        dialogContainer.getChildren().addAll(
                DialogBox.getUserDialog(input, userImage), db);
        userInput.clear();
    }
}
