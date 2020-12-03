package com.example.helloworld.slice;

import com.example.helloworld.ResourceTable;
import ohos.agp.components.*;
import ohos.app.AbilityContext;
import ohos.hiviewdfx.HiLog;
import ohos.hiviewdfx.HiLogLabel;

import java.util.Calendar;

public class DetailComponentOwner implements ComponentOwner {
    private static final String TAG = "DetailComponentOwner";

    private static final HiLogLabel LABEL = new HiLogLabel(HiLog.LOG_APP, 0, TAG);

    private AbilityContext myContext;

    private Component root;

    private Text detail_date;

    public DetailComponentOwner(AbilityContext context) {
        init(context);
    }

    private void init(AbilityContext context) {
        myContext = context;
        root = LayoutScatter.getInstance(context).parse(ResourceTable.Layout_layout_detail, null, false);

        detail_date = (Text) root.findComponentById(ResourceTable.Id_detail_date);
        Calendar calendar = Calendar.getInstance();
        String str = (calendar.get(Calendar.MONTH) + 1) + "月" + calendar.get(Calendar.DAY_OF_MONTH) + "日";
        detail_date.setText(str);
    }

    @Override
    public Component getComponent() {
        return root;
    }

    @Override
    public void instantiateComponent() {
        return;
    }
}
