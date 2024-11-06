package com.vikingz.unitycoon.render;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Align;
import com.vikingz.unitycoon.global.GameGlobals;
import com.vikingz.unitycoon.global.GameSkins;
import com.vikingz.unitycoon.util.TimeUtil;

public class StatsRenderer {

    private SpriteBatch batch;
    private BitmapFont font;
    private Skin skin;


    private Stage stage;

    float width;
    float height;

    // Background

    // Labels
    String balStr;
    Label balance;

    String studentsStr;
    Label students;

    String satisStr;
    Label satisfaction;

    String accomBuildingsStr;
    Label accomBuildings;

    String academBuildingsStr;
    Label academBuildings;


    String recBuildingsStr;
    Label recBuildings;

    String foodBuildingsStr;
    Label foodBuildings;

    String timerStr;
    Label timer;


    List<Label> lables;

    public StatsRenderer(Skin skin) {

        batch = new SpriteBatch();
        stage = new Stage();
        
        this.skin = new GameSkins().getDefaultSkin(); 


        font = new BitmapFont(); // Create a new BitmapFont (consider loading a specific font if needed)
        font.getData().setScale(1.5f);

        lables = new ArrayList<>();

        
        balStr = "Balance";
        studentsStr = "Students";
        satisStr = "satisfaction";
        accomBuildingsStr = "Accodomation";
        academBuildingsStr = "Academic";
        recBuildingsStr = "Recreational";
        foodBuildingsStr = "Food";
        timerStr = "Timer: ";
        
        balance = new Label(balStr, this.skin);
        students = new Label(studentsStr, this.skin);
        satisfaction = new Label(satisStr, this.skin);
        accomBuildings = new Label(accomBuildingsStr, this.skin);
        academBuildings = new Label(academBuildingsStr, this.skin);
        recBuildings = new Label(recBuildingsStr, this.skin);
        foodBuildings = new Label(foodBuildingsStr, this.skin);
        timer = new Label(timerStr, this.skin);

        lables.add(balance);
        lables.add(students);
        lables.add(satisfaction);
        lables.add(accomBuildings);
        lables.add(academBuildings);
        lables.add(recBuildings);
        lables.add(foodBuildings);
        lables.add(timer);

        for(Label lbl: lables){
            lbl.setColor(Color.BLACK);
            lbl.setFontScale(1.5f);
        }


        // Create layout table
        Table table = new Table();
        table.setFillParent(true);
        table.top();
        table.left();

        int padding = 3;

        table.add(balance).pad(padding).align(Align.left);

        table.row();
        table.add(students).pad(padding).align(Align.left);

        table.row();
        table.add(satisfaction).pad(padding).align(Align.left);

        table.row();
        table.add(accomBuildings).pad(padding).align(Align.left);

        table.row();
        table.add(academBuildings).pad(padding).align(Align.left);

        table.row();
        table.add(recBuildings).pad(padding).align(Align.left);

        table.row();
        table.add(foodBuildings).pad(padding).align(Align.left);

        table.row();
        table.add(timer).pad(padding).align(Align.left);

        // Add table to stage
        stage.addActor(table);

    }

    public void show() {
        // Initialize game objects here
    }

    public void render(float delta) {

        float width = 1920;
        float height = 1080;

        batch.begin();
 
        balStr = "Balance: " + GameGlobals.BALANCE;
        studentsStr = "Students: " + GameGlobals.STUDENTS;
        satisStr = "Satisfaction: " + GameGlobals.SATISFACTION;
        accomBuildingsStr = "Accomodation: " + GameGlobals.ACCOMODATION_BUILDINGS_COUNT;
        academBuildingsStr = "Academic: " + GameGlobals.ACADEMIC_BUILDINGS_COUNT;
        recBuildingsStr = "Recreational: " + GameGlobals.RECREATIONAL_BUILDINGS_COUNT;
        foodBuildingsStr = "Food: " + GameGlobals.FOOD_BUILDINGS_COUNT;
        
        TimeUtil.Time timerAmount = TimeUtil.secondsToMinSecs(GameGlobals.ELAPSED_TIME);
        timerStr = "Timer: " + timerAmount;
        
        balance.setText(balStr);
        students.setText(studentsStr);
        satisfaction.setText(satisStr);
        accomBuildings.setText(accomBuildingsStr);
        academBuildings.setText(academBuildingsStr);
        recBuildings.setText(recBuildingsStr);
        foodBuildings.setText(foodBuildingsStr);
        timer.setText(timerStr);


        stage.act(delta);
        stage.draw();
        batch.end();
    }

    public void resize(float width, float height){
        this.width = width;
        this.height = height;
    }


}
