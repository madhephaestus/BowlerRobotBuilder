// code here

import com.neuronrobotics.sdk.addons.kinematics.DHLink
import com.neuronrobotics.sdk.addons.kinematics.DHParameterKinematics
import com.neuronrobotics.sdk.addons.kinematics.IVitaminHolder
import com.neuronrobotics.sdk.addons.kinematics.LinkConfiguration
import com.neuronrobotics.sdk.addons.kinematics.MobileBase
import com.neuronrobotics.sdk.addons.kinematics.VitaminLocation
import com.neuronrobotics.sdk.addons.kinematics.math.RotationNR
import com.neuronrobotics.sdk.addons.kinematics.math.TransformNR
import com.neuronrobotics.sdk.common.DeviceManager

import javafx.scene.transform.Affine
String name = "ExampleRobot"
// Call the Link provider setup script 
MobileBase result = DeviceManager.getSpecificDevice(name, {
	MobileBase base = new MobileBase();
	base.setScriptingName(name)
	base.setGitCadEngine(["https://github.com/CommonWealthRobotics/BowlerStudioExampleRobots.git",
		"exampleCad.groovy"] as String[])
	boolean isScript=true;
	String n="BaseCadModel";
	String type = "https://github.com/KacperLa/Ron.git"; 
	String size="Ron.groovy";
	TransformNR location = new TransformNR();
	IVitaminHolder h = base;
	VitaminLocation baseVitamin = new VitaminLocation( isScript,n,  type,  size,  location, h)
	base.addVitamin(baseVitamin)
	DHParameterKinematics arm = new DHParameterKinematics();
	arm.setGitCadEngine(["https://github.com/CommonWealthRobotics/BowlerStudioExampleRobots.git",
		"exampleCad.groovy"] as String[])
	// Add Link one
	LinkConfiguration link1 = new LinkConfiguration(0, -100, 100, 1.0)
	link1.setHardwareIndex(0)
	link1.setDeviceScriptingName("cdataProvider")
	String nL1="L1Model";
	String typeL1 = "https://github.com/KacperLa/Ron.git";
	String sizeL1="Ron.groovy";
	TransformNR locationL1 = new TransformNR();
	IVitaminHolder hL1 = link1;
	VitaminLocation baseVitaminL1= new VitaminLocation( isScript,nL1,  typeL1,  sizeL1,  locationL1, hL1)
	link1.addVitamin(baseVitaminL1)
	link1.getShaftVitamin(true)
	link1.getElectroMechanicalVitamin(true)
	DHLink dh1 = new DHLink(0, 0, 100, 0)
	dh1.setListener(new Affine());
	arm.addNewLink(link1, dh1)
	
	// Add Link 2
	LinkConfiguration linkL2 = new LinkConfiguration(0, -100, 100, 1.0)
	linkL2.setHardwareIndex(1)
	linkL2.setDeviceScriptingName("cdataProvider")
	String nL2="L2Model";
	String typeL2 = "https://github.com/KacperLa/Ron.git";
	String sizeL2="Ron.groovy";
	TransformNR locationL2 = new TransformNR();
	IVitaminHolder hL2 = linkL2;
	VitaminLocation baseVitaminL2= new VitaminLocation( isScript,nL2,  typeL2,  sizeL2,  locationL2, hL2)
	linkL2.addVitamin(baseVitaminL2)
	linkL2.getShaftVitamin(true)
	linkL2.getElectroMechanicalVitamin(true)
	DHLink dhL2 = new DHLink(0, 0, 100, 0)
	dhL2.setListener(new Affine());
	arm.addNewLink(linkL2, dhL2)
	
	//add the arm to the base
	base.getAppendages().add(arm);
	base.connect();
	return base;
})

// do something with result

return null;