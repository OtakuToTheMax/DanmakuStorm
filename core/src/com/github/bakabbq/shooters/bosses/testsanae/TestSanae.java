package com.github.bakabbq.shooters.bosses.testsanae;

import com.github.bakabbq.IDanmakuWorld;
import com.github.bakabbq.datas.StateHelper;
import com.github.bakabbq.shooters.bosses.ThBoss;

/**
 * Created by LBQ on 6/27/14.
 */
public class TestSanae extends ThBoss{
    public TestSanae(IDanmakuWorld ground) {
        super(ground);
        stateId = StateHelper.IDLE;
    }


    @Override
    public int updateFrame(){
        return 4;
    }

    @Override
    public void initSpellCards() {
        spellCards.add(new TestSpellCard(this));
    }
}
