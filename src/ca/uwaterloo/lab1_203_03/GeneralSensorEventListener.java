package ca.uwaterloo.lab1_203_03;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.widget.LinearLayout;
import android.widget.TextView;

public class GeneralSensorEventListener implements SensorEventListener{
	private TextView mTvGen;
	private String sensorType;
	private float xMaxValueRotation = 0;
	private float yMaxValueRotation = 0;
	private float zMaxValueRotation =0;
	private float xMaxValueMagnetic = 0;
	private float yMaxValueMagnetic = 0;
	private float zMaxValueMagnetic =0;
	private float xMaxValueAccel = 0;
	private float yMaxValueAccel = 0;
	private float zMaxValueAccel =0;
	private float lightMaxValue = 0;
	
	public GeneralSensorEventListener(Context context, String sensorType, LinearLayout layout){
		this.sensorType = sensorType;
		addTextView(context, null, layout);
		
	}
	
	public void addTextView(Context context, String value, LinearLayout layout){
		mTvGen = new TextView(context);
		mTvGen.setText(sensorType + value);
		layout.addView(mTvGen);
	}
	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onSensorChanged(SensorEvent se) {
		// TODO Auto-generated method stub
		if (se.sensor.getType() == Sensor.TYPE_LIGHT)
		{
			float light = se.values[0];
			
			if (lightMaxValue < Math.abs(light)){
				lightMaxValue = Math.abs(light);
			}
			
			String value = String.format("%.4f\n"
					+ "Max Light: %.4f\n", light, lightMaxValue);
			mTvGen.setText(sensorType + ": " + value);
		}
		else if (se.sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD){
			
			float x = se.values[0];
			float y = se.values[1];
			float z = se.values[2];
			
			if (xMaxValueMagnetic < Math.abs(x)){
				xMaxValueMagnetic = Math.abs(x);
			}
			if (yMaxValueMagnetic < Math.abs(y)){
				yMaxValueMagnetic = Math.abs(y);
			}
			if (zMaxValueMagnetic < Math.abs(z)){
				zMaxValueMagnetic = Math.abs(z);
			}
			
			String value = String.format("\nX:%.4f "
										+ "\nY:%.4f"
										+ "\nZ:%.4f \n", x, y, z);
			
			String maxValues = String.format("\nX-Max:%.4f "
					+ "\nY-Max:%.4f"
					+ "\nZ-Max:%.4f \n", xMaxValueMagnetic, yMaxValueMagnetic, zMaxValueMagnetic);
			
			mTvGen.setText("----" + sensorType + "----" + value + "\n----Max " + sensorType + "----" + maxValues);
		}
		else if (se.sensor.getType() == Sensor.TYPE_ROTATION_VECTOR){
			
			float x = se.values[0];
			float y = se.values[1];
			float z = se.values[2];
			
			if (xMaxValueRotation < Math.abs(x)){
				xMaxValueRotation = Math.abs(x);
			}
			if (yMaxValueRotation < Math.abs(y)){
				yMaxValueRotation = Math.abs(y);
			}
			if (zMaxValueRotation < Math.abs(z)){
				zMaxValueRotation = Math.abs(z);
			}
			
			String value = String.format("\nX:%.4f "
										+ "\nY:%.4f"
										+ "\nZ:%.4f \n", x, y, z);
			
			String maxValues = String.format("\nX-Max:%.4f "
					+ "\nY-Max:%.4f"
					+ "\nZ-Max:%.4f \n", xMaxValueRotation, yMaxValueRotation, zMaxValueRotation);
			
			mTvGen.setText("----" + sensorType + "----" + value + "\n----Max " + sensorType + "----" + maxValues);
		}
		else if (se.sensor.getType() == Sensor.TYPE_ACCELEROMETER){
			
			float x = se.values[0];
			float y = se.values[1];
			float z = se.values[2];
			
			if (xMaxValueAccel < Math.abs(x)){
				xMaxValueAccel = Math.abs(x);
			}
			if (yMaxValueAccel < Math.abs(y)){
				yMaxValueAccel = Math.abs(y);
			}
			if (zMaxValueAccel < Math.abs(z)){
				zMaxValueAccel = Math.abs(z);
			}
			
			String maxValues = String.format("\nX-Max:%.4f "
					+ "\nY-Max:%.4f"
					+ "\nZ-Max:%.4f \n", xMaxValueAccel, yMaxValueAccel, zMaxValueAccel);
			
			mTvGen.setText("----Max " + sensorType + "----" + maxValues);
		}
	}

}

