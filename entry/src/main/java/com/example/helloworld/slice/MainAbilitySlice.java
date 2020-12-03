package com.example.helloworld.slice;

import com.example.helloworld.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.aafwk.content.Operation;
import ohos.agp.components.Button;
import ohos.agp.components.Component;

public class MainAbilitySlice extends AbilitySlice {
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_main);
        Button nextButton = (Button) findComponentById(ResourceTable.Id_button);

        if (nextButton != null) {
            nextButton.setClickedListener(new Component.ClickedListener() {
                @Override
                public void onClick(Component component) {
                    Intent nextIntent = new Intent();
                    // 指定待启动FA的bundleName和abilityName
                    Operation operation = new Intent.OperationBuilder()
                            .withDeviceId("")
                            .withBundleName("com.example.helloworld")
                            .withAbilityName("com.example.helloworld.SecondAbility")
                            .build();
                    nextIntent.setOperation(operation);
                    startAbility(nextIntent);
                }
            });
        }

    }

    @Override
    public void onActive() {
        super.onActive();
    }

    @Override
    public void onForeground(Intent intent) {
        super.onForeground(intent);
    }
}
