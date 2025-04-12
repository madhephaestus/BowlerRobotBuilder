// code here

import com.neuronrobotics.sdk.addons.kinematics.MobileBase
import com.neuronrobotics.sdk.common.DeviceManager
String name = "ExampleRobot"
MobileBase result = DeviceManager.getSpecificDevice(name, {
	MobileBase base = new MobileBase();
	
	base.connect();
	return base;
})



return null;