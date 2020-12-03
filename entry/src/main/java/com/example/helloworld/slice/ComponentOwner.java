package com.example.helloworld.slice;

import ohos.agp.components.Component;

public interface ComponentOwner {
    // 获取存放的Component
    Component getComponent();
    // 当包含的Component被添加到容器时回调
    void instantiateComponent();
}
