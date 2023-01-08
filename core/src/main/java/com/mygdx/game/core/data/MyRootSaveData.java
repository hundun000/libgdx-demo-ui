package com.mygdx.game.core.data;

import hundun.gdxgame.corelib.starter.StarterSaveHandler.IFactory;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author hundun
 * Created on 2022/08/17
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MyRootSaveData {
    
    MyGameplaySaveData gameplaySaveData;
    MySystemSettingSaveData systemSettingSaveData;
    
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class MyGameplaySaveData {
        String value;
    }
    
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class MySystemSettingSaveData {
        String value;
    }
    
    public static class Factory implements IFactory<MyRootSaveData, MySystemSettingSaveData, MyGameplaySaveData>{

        public static Factory INSTANCE = new Factory(); 
        
        @Override
        public MySystemSettingSaveData getSystemSave(MyRootSaveData rootSaveData) {
            return rootSaveData.getSystemSettingSaveData();
        }

        @Override
        public MyGameplaySaveData getGameplaySave(MyRootSaveData rootSaveData) {
            return rootSaveData.getGameplaySaveData();
        }

        @Override
        public MyRootSaveData newRootSave(MyGameplaySaveData gameplaySave, MySystemSettingSaveData systemSettingSave) {
            return new MyRootSaveData(gameplaySave, systemSettingSave);
        }

        @Override
        public MyGameplaySaveData newGameplaySave() {
            return new MyGameplaySaveData();
        }

        @Override
        public MySystemSettingSaveData newSystemSave() {
            return new MySystemSettingSaveData();
        }

    }

}
