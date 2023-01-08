package com.mygdx.game.core.screen;

import java.util.Arrays;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.core.MyHundunGame;
import com.mygdx.game.core.data.MyRootSaveData;

import hundun.gdxgame.corelib.base.BaseHundunScreen;
import hundun.gdxgame.corelib.base.util.DrawableFactory;

/**
 * @author hundun
 * Created on 2023/01/11
 */
public class MyMenuScreen extends BaseHundunScreen<MyHundunGame, MyRootSaveData> {

    int BUTTON_WIDTH = 100;
    int BUTTON_BIG_HEIGHT = 100;
    int BUTTON_SMALL_HEIGHT = 75;
    
    Actor title;
    Actor buttonContinueGame;
    Actor buttonNewGame;
    Image backImage;
    
    public MyMenuScreen(MyHundunGame game) {
        super(game);
        
        this.title = new Image(new Texture("badlogic.jpg"));
        
        this.backImage = new Image(DrawableFactory.getViewportBasedAlphaBoard(game.getWidth(), game.getHeight()));
        
        this.buttonNewGame = new TextButton("New", game.getMainSkin());
        buttonNewGame.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.gameLoadOrNew(false);
                game.getScreenManager().pushScreen(MyGameplayScreen.class.getSimpleName(), "blending_transition");
            }
        });
        
        this.buttonContinueGame = new TextButton("Continue", game.getMainSkin());
        buttonContinueGame.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.gameLoadOrNew(true);
                game.getScreenManager().pushScreen(MyGameplayScreen.class.getSimpleName(), "blending_transition");
            }
        });

    }

    @Override
    public void show() {
        super.show();
        
        Gdx.input.setInputProcessor(uiStage);
        game.getBatch().setProjectionMatrix(uiStage.getViewport().getCamera().combined);
        
        
    }
    
    private void initScene2d() {
        backUiStage.clear();
        uiRootTable.clear();
        
        backUiStage.addActor(backImage);

        uiRootTable.add(title)
                .row();
        if (game.gameHasSave()) {
            uiRootTable.add(buttonContinueGame)
                    .height(BUTTON_BIG_HEIGHT)
                    .fillY()
                    .padTop(10)
                    .row();
        }
        uiRootTable.add(buttonNewGame)
                .height(game.gameHasSave() ? BUTTON_SMALL_HEIGHT : BUTTON_BIG_HEIGHT)
                .fillY()
                .padTop(10)
                .row();
    }

    @Override
    protected void create() {
        initScene2d();
    }

    @Override
    public void dispose() {
        // TODO Auto-generated method stub
        
    }

}
