package com.example.helloworld;

import com.example.helloworld.slice.SecondAbilitySlice;
import com.example.helloworld.slice.SleepPageSlice;
import ohos.aafwk.ability.Ability;
import ohos.aafwk.content.Intent;

public class SecondAbility extends Ability {
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setMainRoute(SleepPageSlice.class.getName());
        setSwipeToDismiss(true);
    }
}
