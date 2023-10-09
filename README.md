`Add MainActivity to implement SensorEventListener which to listen any change
coming from sensors`  
![image](https://github.com/April-nnma/SensorDataApp/assets/106756843/bd766f98-cc43-493a-aa3b-98e068ea89ea)  
`Depending on the types of sensors, these sensor value array means differently.
You can take a further look on Android Development resource as below to see
more about which values mean on each type of sensor.`  
![image](https://github.com/April-nnma/SensorDataApp/assets/106756843/5ce66083-e8c9-484a-9599-6eab4ff10e70)  
`Now let’s see the data we have from 2 sensors: light and proximity
First, when the main activity is loading and unloading (onStart() and onStop()
events), we register the sensors with the system so that the events
onSensorChanged() and onAccuracyChanged() can be triggered.`  
![image](https://github.com/April-nnma/SensorDataApp/assets/106756843/850bab6f-af44-40ea-9686-1780d038e302)  
`Then override onSensorChanged() with custom code.`  
![image](https://github.com/April-nnma/SensorDataApp/assets/106756843/e1262c3d-1e85-451c-a3b9-7c04671b15f6)


