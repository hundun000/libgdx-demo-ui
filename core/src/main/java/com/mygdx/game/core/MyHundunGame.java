package com.mygdx.game.core;

import com.badlogic.gdx.Gdx;
import com.mygdx.game.core.data.MyRootSaveData;
import com.mygdx.game.core.data.MyRootSaveData.MyGameplaySaveData;
import com.mygdx.game.core.data.MyRootSaveData.MySystemSettingSaveData;
import com.mygdx.game.core.manager.MyViewModelContext;
import com.mygdx.game.core.screen.MyMenuScreen;

import hundun.gdxgame.corelib.base.BaseHundunGame;
import hundun.gdxgame.corelib.base.util.save.ISaveTool;
import hundun.gdxgame.corelib.starter.StarterMenuScreen;
import hundun.gdxgame.corelib.starter.StarterSaveHandler;

/**
 * @author hundun
 * Created on 2023/01/11
 */
public class MyHundunGame extends BaseHundunGame<MyRootSaveData> {

    public MyHundunGame(int viewportWidth, int viewportHeight, ISaveTool<MyRootSaveData> saveTool) {
        super(viewportWidth, viewportHeight, saveTool);

    }

    @Override
    protected void createStage1() {
        // ------ for super ------
        this.modelContext = new MyViewModelContext(this);
        this.saveHandler = new StarterSaveHandler<MyRootSaveData, MySystemSettingSaveData, MyGameplaySaveData>(MyRootSaveData.Factory.INSTANCE);
        this.mainSkinFilePath = "skins/default/uiskin.json";
    }

    @Override
    protected void createStage3() {
        systemSettingLoadOrNew();
        
        this.screenManager.pushScreen(MyMenuScreen.class.getSimpleName(), "blending_transition");
        Gdx.app.log(this.getClass().getSimpleName(), "Initialization finished.");
    }

}
