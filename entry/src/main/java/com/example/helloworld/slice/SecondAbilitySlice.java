package com.example.helloworld.slice;

import com.example.helloworld.ResourceTable;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.colors.RgbColor;
import ohos.agp.components.DependentLayout;
import ohos.agp.components.Text;
import ohos.agp.components.element.ShapeElement;
import ohos.agp.utils.Color;

import static ohos.agp.components.ComponentContainer.LayoutConfig.MATCH_PARENT;
import static ohos.agp.components.ComponentContainer.LayoutConfig.MATCH_CONTENT;

public class SecondAbilitySlice extends AbilitySlice {
    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
//        super.setUIContent(ResourceTable.Layout_ability_second);

        DependentLayout mLayout = new DependentLayout(this);
        mLayout.setWidth(MATCH_PARENT);
        mLayout.setHeight(MATCH_PARENT);
        ShapeElement element = new ShapeElement();
        element.setRgbColor(new RgbColor(0, 0, 0));
        mLayout.setBackground(element);

        Text text = new Text(this);
        text.setText("Hello World");
        text.setWidth(MATCH_PARENT);
        text.setTextSize(55);
        text.setTextColor(Color.WHITE);
        DependentLayout.LayoutConfig textConfig = new DependentLayout.LayoutConfig(MATCH_CONTENT, MATCH_CONTENT);
        textConfig.addRule(DependentLayout.LayoutConfig.CENTER_IN_PARENT);
        text.setLayoutConfig(textConfig);
        mLayout.addComponent(text);

        super.setUIContent(mLayout);
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
