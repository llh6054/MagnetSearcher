package com.magnetsearcher.pipeline;

import java.io.FileWriter;

import us.codecraft.webmagic.ResultItems;
import us.codecraft.webmagic.Task;
import us.codecraft.webmagic.pipeline.Pipeline;

public class BtSoPipeline implements Pipeline {
	
	
	@Override
	public void process(ResultItems resultItems, Task task) {
		try {
			FileWriter fw = new FileWriter("D:\\magnet.txt", true);
			String magnet = resultItems.get("magnet");
			fw.write(magnet + "\r\n");
			fw.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

}
