package com.example.helloworld.slice;

import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.components.*;
import ohos.hiviewdfx.HiLog;
import ohos.hiviewdfx.HiLogLabel;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class SleepPageSlice extends AbilitySlice {
    private static final String TAG = "SleepPageSlice";

    private static final HiLogLabel LABEL = new HiLogLabel(HiLog.LOG_APP, 0, TAG);

    private List<ComponentOwner> list = new ArrayList<>();

    private PageSliderProvider provider = new PageSliderProvider() {
        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object createPageInContainer(ComponentContainer componentContainer, int i) {
            if (i >= list.size() || componentContainer == null) {
                HiLog.error(LABEL, "instantiateItem index error");
                return Optional.empty();
            }
            ComponentOwner container = list.get(i);
            componentContainer.addComponent(container.getComponent());
            container.instantiateComponent();
            return container.getComponent();
        }

        @Override
        public void destroyPageFromContainer(ComponentContainer componentContainer, int i, Object o) {
            HiLog.info(LABEL, "destroyItem index:" + i);
            if (i >= list.size() || componentContainer == null) {
                return;
            }
            Component component = list.get(i).getComponent();
            componentContainer.removeComponent(component);
            return;
        }

        @Override
        public boolean isPageMatchToObject(Component component, Object o) {
            return component == o;
        }

        @Override
        public void startUpdate(ComponentContainer container) {
            super.startUpdate(container);
            HiLog.info(LABEL, "startUpdate");
        }
    };

    @Override
    protected void onStart(Intent intent) {
        super.onStart(intent);
        HiLog.info(LABEL, "onStart");

        // 添加子页面
        list.add(new SleepComponentOwner(this));
        list.add(new DetailComponentOwner(this));

        // 设置主界面
        DirectionalLayout directionalLayout = new DirectionalLayout(this);
        ComponentContainer.LayoutConfig layoutConfig = new ComponentContainer.LayoutConfig(
                ComponentContainer.LayoutConfig.MATCH_PARENT,
                ComponentContainer.LayoutConfig.MATCH_PARENT);
        directionalLayout.setLayoutConfig(layoutConfig);

        PageSlider slider = new PageSlider(this);
        ComponentContainer.LayoutConfig sliderConfig = new ComponentContainer.LayoutConfig(
                ComponentContainer.LayoutConfig.MATCH_PARENT,
                ComponentContainer.LayoutConfig.MATCH_PARENT);
        slider.setLayoutConfig(sliderConfig);
        slider.setOrientation(Component.VERTICAL);

        slider.setProvider(provider);

        directionalLayout.addComponent(slider);

        setUIContent(directionalLayout);
    }
}
