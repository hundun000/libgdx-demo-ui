package com.mygdx.game.core.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.mygdx.game.core.MyHundunGame;
import com.mygdx.game.core.data.MyRootSaveData;

import hundun.gdxgame.corelib.base.BaseHundunScreen;

/**
 * @author hundun
 * Created on 2023/01/11
 */
public class MyGameplayScreen extends BaseHundunScreen<MyHundunGame, MyRootSaveData> {

    Actor buttonBack;
    
    public MyGameplayScreen(MyHundunGame game) {
        super(game);
        
        buttonBack = new TextButton("Save and Back", game.getMainSkin());
        buttonBack.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                super.clicked(event, x, y);
                game.gameSaveCurrent();
                game.getScreenManager().pushScreen(MyMenuScreen.class.getSimpleName(), "blending_transition");
            }
        });
    }

    @Override
    protected void create() {
        backUiStage.clear();
        uiRootTable.clear();

        uiRootTable.add(buttonBack)
                .height(50)
                .fillY()
                .padTop(10)
                .row();
    }

    @Override
    public void dispose() {

    }

    @Override
    public void show() {
        super.show();
        
        Gdx.input.setInputProcessor(uiStage);
        game.getBatch().setProjectionMatrix(uiStage.getViewport().getCamera().combined);
        
        
    }
}
