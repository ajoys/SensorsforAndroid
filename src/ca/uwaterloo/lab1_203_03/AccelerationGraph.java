package ca.uwaterloo.lab1_203_03;

import java.util.Arrays;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.widget.LinearLayout;

public class AccelerationGraph implements SensorEventListener{
	static LineGraphView graph;
	
	public AccelerationGraph(Context context, LinearLayout layout){
		graph = new LineGraphView(context,
				100,
				Arrays.asList("x", "y", "z"));
				layout.addView(graph);
	}
	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onSensorChanged(SensorEvent se) {
		// TODO Auto-generated method stub
		if(se.sensor.getType() == Sensor.TYPE_ACCELEROMETER){
			graph.addPoint(se.values);
		}
	}

}
