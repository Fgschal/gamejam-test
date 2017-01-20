package com.gamejam.test;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.StretchViewport;

import squidpony.squidgrid.gui.gdx.DefaultResources;
import squidpony.squidgrid.gui.gdx.SquidInput;
import squidpony.squidgrid.gui.gdx.SquidLayers;

public class GameJamReal extends ApplicationAdapter{
	SpriteBatch batch;
	/** In number of cells */
    private int gridWidth;
    /** In number of cells */
    private int gridHeight;
    /** The pixel width of a cell */
    private int cellWidth;
    /** The pixel height of a cell */
    private int cellHeight;
    private Stage stage;
    private SquidLayers display;
    private SquidInput input;
    
	@Override
    public void create () {
		gridWidth = 80;
        gridHeight = 24;
        cellWidth = 11;
        cellHeight = 22;
        batch = new SpriteBatch();
        stage = new Stage(new StretchViewport(gridWidth * cellWidth, (gridHeight + 8) * cellHeight), batch);
        //Try to remove +8
        display = new SquidLayers(gridWidth, gridHeight + 8, cellWidth, cellHeight, DefaultResources.getStretchableFont());
        display.setTextSize(cellWidth, cellHeight + 1);
        display.setAnimationDuration(0.03f);
        display.setPosition(0, 0);
        
	}
	
	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
        //very important to have the mouse behave correctly if the user fullscreens or resizes the game!
        // this gets the mouse's understanding of the screen updated for the newly resized grid.
        // you may need to change this if your game has multiple sections, like a SquidMessageBox or other widget below
        // the main grid of the game. If a game uses VisualInput, then that way of handling input will need to be told
        // about the changes to the screen as well.
		input.getMouse().reinitialize((float) width / this.gridWidth, (float)height / (this.gridHeight + 8), this.gridWidth, this.gridHeight, 0, 0);
	}
}
