package com.vikingz.unitycoon.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class MenuScreen extends SuperScreen implements Screen {


    public MenuScreen() {
        Gdx.input.setInputProcessor(stage);

        // Load a default skin

        // Create buttons
        TextButton playButton = new TextButton("Play", skin);
        TextButton settingsButton = new TextButton("Settings", skin);
        TextButton quitButton = new TextButton("Quit", skin);

        // Add listeners to buttons
        playButton.addListener(e -> {
            if (!playButton.isPressed()) return false;
            ScreenMultiplexer.switchScreens(ScreenMultiplexer.Screens.MAPSELECTION);
            return true;
        });

        settingsButton.addListener(e -> {
            if (!settingsButton.isPressed()) return false;
            ScreenMultiplexer.switchScreens(ScreenMultiplexer.Screens.SETTINGS);
            return true;
        });

        quitButton.addListener(e -> {
            if (!quitButton.isPressed()) return false;
            Gdx.app.exit(); // Quit the application
            return true;
        });

        // Create a table for layout
        Table table = new Table();
        table.setFillParent(true);  // Center table on stage
        table.center();

        Image texture = new Image(new Texture(Gdx.files.internal("gameLogo.png"))); 
        table.add(texture).pad(50);
        table.row();

        // Add buttons to table
        table.add(playButton).pad(10);
        table.row();
        table.add(settingsButton).pad(10);
        table.row();
        table.add(quitButton).pad(10);

        // Add the table to the stage
        stage.addActor(table);
    }

    @Override
    public void show() {
        // Called when this screen becomes the current screen for the game.
    }

    @Override
    public void render(float delta) {
        // Clear the screen
        Gdx.gl.glClearColor(25/255f, 25/255f, 25/255f, 1);
        Gdx.gl.glClear(Gdx.gl.GL_COLOR_BUFFER_BIT);

        // Draw the stage
        stage.act(delta);
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        // Update the stage's viewport when the screen size changes
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void pause() { }

    @Override
    public void resume() { }

    @Override
    public void hide() {
        // This removes the bug where the user can still click the buttons from the game screen.
    }

    @Override
    public void dispose() {
        // Dispose of assets when this screen is no longer used
        stage.dispose();
        skin.dispose();
    }
}
