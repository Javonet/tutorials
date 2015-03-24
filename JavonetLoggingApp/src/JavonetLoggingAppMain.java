import com.javonet.Javonet;
import com.javonet.JavonetException;
import com.javonet.JavonetFramework;
import com.javonet.api.NObject;


public class JavonetLoggingAppMain {

	public static void main(String[] args) throws JavonetException {
		
		// *************** JAVONET SAMPLE **************************
		// *************** IMPORTANT ******************************* 
		// Before running this sample please make sure
		// that:
		//
		// 1) You have downloaded and added to references 
		// the latest version of Javonet JAR
		//
		// Latest Javonet release can be obtained from: 
		// https://www.javonet.com/download/
		//
		// 2) You have updated Javonet.activate method arguments
		// by replacing default email address and license key with 
		// your activation details.
		//
		// To obtain FREE trial license key please visit:
		// http://www.javonet.com/signup-for-trial/
		// *********************************************************
				
		
		//Modify JavonetFramework version to the one installed on your computer: v35, v40 or v45
		Javonet.activate("sdncenter@gmail.com", "Tj4n-n5Y8-Zi3g-g8NL-p9C2",JavonetFramework.v40);
		Javonet.addReference("log4net.dll");

		Javonet.getType("BasicConfigurator").invoke("Configure");
		
		NObject log = Javonet.getType("LogManager").invoke("GetLogger","main");
		log.invoke("Debug","Test Javonet!");
	}

}
