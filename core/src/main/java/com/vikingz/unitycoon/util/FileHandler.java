package com.vikingz.unitycoon.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;


/**
 * This class handles loading in files
 * 
 * Main use is to load in the map file
 */
public class FileHandler {


    public static String loadMap(String fileName){
        String mapData = "";
        FileHandle fileHandle = Gdx.files.internal("maps/" + fileName + ".txt");
        //FileHandle fileHandle = Gdx.files.internal("maps/map1.txt");

        // Check if the file exists
        if (fileHandle.exists()) {
            // Read the content as a string
            mapData = fileHandle.readString();

        } else {
            System.out.println("File not found!: " + fileHandle.toString());
        }

        return mapData;
    }


}
