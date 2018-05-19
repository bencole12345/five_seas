package uk.ac.cam.cl.gui;

import javafx.geometry.HPos;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;

import uk.ac.cam.cl.Main;

public class MenuBar extends GridPane {
  private Main parent;

  public MenuBar(Main parent) {
    super();

    this.parent = parent;

    this.setId("menu-bar");

    ColumnConstraints col0cons = new ColumnConstraints();
    col0cons.setPercentWidth(10);
    ColumnConstraints col1cons = new ColumnConstraints();
    col1cons.setPercentWidth(90);

    this.getColumnConstraints().addAll(col0cons, col1cons, col0cons);

    this.add(initBackButton(), 0, 0);
  }

  private Button initBackButton() {
    Button menuBtn = new Button();
    menuBtn.setGraphic(new ImageView(Main.BACK_ICON));
    menuBtn.setId("menu-back-btn");
    GridPane.setHalignment(menuBtn, HPos.CENTER);
    menuBtn.setOnAction(
        (x) -> {
          System.out.println("< menu button pressed");
          parent.showMain();
        });

    return menuBtn;
  }
}
