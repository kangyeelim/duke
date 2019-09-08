package seedu.duke;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

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
    private Stage stage;
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

    public void setStage(Stage stage) {
        this.stage = stage;
    }
    /**
     * Creates two dialog boxes, one echoing user input and the other containing Duke's reply and then appends them to
     * the dialog container. Clears the user input after processing.
     */
    @FXML
    private void handleUserInput() {
        String input = userInput.getText();
        String response = duke.getResponse(input);
        if (response.equals("help")) {
           showHelpScene();
        } else {
            var db = DialogBox.getDukeDialog(response, dukeImage);
            dialogContainer.getChildren().addAll(
                    DialogBox.getUserDialog(input, userImage), db);
            userInput.clear();
        }
    }

    private void showHelpScene() {
        //todo help scene
        VBox layout = new VBox(20);
        AnchorPane anchor = new AnchorPane();
        TextField input = new TextField();
        input.setPrefHeight(41.0);
        input.setPrefWidth(324.0);
        Button enterBtn = new Button("Send");
        anchor.setBottomAnchor(input, 1.0);
        anchor.setBottomAnchor(enterBtn, 1.0);
        enterBtn.layoutXProperty().setValue(324.0);
        enterBtn.layoutYProperty().setValue(558.0);
        enterBtn.setPrefHeight(41.0);
        enterBtn.setPrefWidth(76.0);
        ScrollPane helpContainer = new ScrollPane();
        helpContainer.setContent(layout);
        helpContainer.vvalueProperty().bind(layout.heightProperty());
        helpContainer.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        helpContainer.setHvalue(1.0);
        helpContainer.setPrefHeight(557.0);
        helpContainer.setPrefWidth(400.0);
        layout.getChildren().add(DialogBox.getDukeDialog("Let's start the tutorial!\n" +
                "To learn more about the task managing commands, enter 'task'\n" +
                "To learn more about the expense tracking commands, enter 'expenses'\n", dukeImage));
        //to do more stuff
        anchor.getChildren().addAll(input, enterBtn, helpContainer);
        Scene helpScene = new Scene(anchor, 400, 600);
        stage.setScene(helpScene);
        stage.show();
    }
}
