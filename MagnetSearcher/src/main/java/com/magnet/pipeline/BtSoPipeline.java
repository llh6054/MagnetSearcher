package com.magnet.pipeline;

import java.io.FileWriter;

import com.magnet.website.siteconst.SiteConst;
import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

public class BtSoPipeline implements Pipeline {


    @Override
    public void process(ResultItems resultItems, Task task) {
        try {
            FileWriter fw = new FileWriter(SiteConst.MAGNET_PATH, true);
            String magnet = resultItems.get(SiteConst.TARGET_LINK_KEY);
            fw.write(magnet + "\r\n");
            fw.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

}
