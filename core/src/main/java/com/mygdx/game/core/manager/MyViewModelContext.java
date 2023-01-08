package com.mygdx.game.core.manager;

import com.mygdx.game.core.MyHundunGame;
import com.mygdx.game.core.screen.MyGameplayScreen;
import com.mygdx.game.core.screen.MyMenuScreen;

import de.eskalon.commons.screen.transition.impl.BlendingTransition;
import hundun.gdxgame.corelib.base.BaseHundunScreen;
import hundun.gdxgame.corelib.base.BaseViewModelContext;

/**
 */
public class MyViewModelContext extends BaseViewModelContext {

    MyHundunGame game;
    
    public MyViewModelContext(MyHundunGame game) {
        this.game = game;
    }

    @Override
    protected void lazyInitOnGameCreate() {
        BaseHundunScreen<?, ?> screen;
        
        screen = new MyMenuScreen(game);
        game.getScreenManager().addScreen(screen.getClass().getSimpleName(), screen);
        
        screen = new MyGameplayScreen(game);
        game.getScreenManager().addScreen(screen.getClass().getSimpleName(), screen);
        
        BlendingTransition blendingTransition = new BlendingTransition(game.getBatch(), 1F);
        game.getScreenManager().addScreenTransition("blending_transition", blendingTransition);
    }

    @Override
    protected void disposeAll() {
        
    }

}
