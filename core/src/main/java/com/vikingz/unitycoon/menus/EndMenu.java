package com.vikingz.unitycoon.menus;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.vikingz.unitycoon.global.GameConfig;
import com.vikingz.unitycoon.global.GameGlobals;

public class EndMenu extends Window {

    private final Label topSatisfaction;
    private String Message = "";

    private Skin skin;

    private Runnable leftRun;
    private Runnable rightRun;
    private Label congrats;



    public EndMenu(Skin skin, String Message) {

        super("Popup", skin);

        this.setSize(600, 400);
        this.setModal(true);
        this.setMovable(false);
        this.setResizable(false);

        this.skin = skin;
        this.setBackground(GameGlobals.backGroundDrawable);


        Label message = new Label(Message, skin);
        this.add(message).padLeft(-35).row();


        topSatisfaction = new Label("Top Satisfaction: " + GameConfig.getInstance().getTopSatisfaction(),skin);
        this.add(topSatisfaction).padBottom(20).row();


    }


    public void setupButtons(Runnable leftRun, String leftText, Runnable rightRun, String rightText){

        // Idk change this later
        TextButton leftBtn = new TextButton(leftText, skin);
        TextButton rightBtn = new TextButton(rightText, skin);
        this.add(leftBtn).pad(10);
        this.add(rightBtn).pad(10);




        // Created for yes - no game events
        // The Popup needs to call back to parent object in someway

        leftBtn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                leftRun.run();
                //PopupMenu.this.remove();
            }
        });

        rightBtn.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                rightRun.run();
                //PopupMenu.this.remove();
            }
        });
    }



    //Getters and Setters
    public String getMessage() {
        return Message;
    }
    public void setMessage(String message) {
        Message = message;
    }


    public void addNewHighScore() {
        congrats = new Label("You have reached a new high score of satisfaction", skin);
        this.row();
        this.add(congrats);

    }
}