package fpdemo.ri;

import java.util.logging.Logger;

public class SimpleData {
	private static Logger logger = Logger.getGlobal();
	private String data;
	public String getData() {
		logger.info("Get Data called for SimpleData");
		return data;
	}
	public SimpleData setData(String data) {
        logger.info("Set data called for SimpleData");
        this.data = data;
        return this;
    }
	public static void main(String[] aargs) {
		String data = new SimpleData().setData("Jasti").getData();
		logger.info(new SimpleData().setData("Jasti").getData());
		logger.info(data);
		logger.info("Jasti");
	}
}
