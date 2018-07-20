package tijos.framework.sensor.bh1750;

import java.io.IOException;

import tijos.framework.devicecenter.TiI2CMaster;
import tijos.framework.util.Delay;

/**
 * Hello world!
 *
 */
public class TiBH1750Sample {
	public static void main(String[] args) {
		try {
			/*
			 * 定义使用的TiI2CMaster port
			 */
			int i2cPort0 = 0;

			/*
			 * 资源分配， 将i2cPort0分配给TiI2CMaster对象i2c0
			 */
			TiI2CMaster i2c0 = TiI2CMaster.open(i2cPort0);
			
			TiBH1750 bh1750 = new TiBH1750(i2c0);
			
			while (true) {
				int lux = bh1750.readLightLevel();

				System.out.println("Light : " + lux + " lux");
				
				Delay.msDelay(1000);

			}

		} catch (IOException ex) {
		
			ex.printStackTrace();
		}
	}
}
