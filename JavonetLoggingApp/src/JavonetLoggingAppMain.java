import com.javonet.Javonet;
import com.javonet.JavonetException;
import com.javonet.JavonetFramework;
import com.javonet.api.NObject;


public class JavonetLoggingAppMain {

	public static void main(String[] args) throws JavonetException, InterruptedException {
		
		//**************** JAVONET SAMPLE **************************
		// IMPORTANT: Before running this sample please make sure
		// that:
		// 1) Downloaded and added to references latest version of Javonet JAR
		//
		// Latest Javonet release available at: 
		// https://www.javonet.com/download/
		//
		// 2) You have updated Javonet.activate method arguments
		// by replacing default email address and license key with 
		// your activation details.
		//
		// To obtain FREE trial license key please visit:
		// http://www.javonet.com/signup-for-trial/
		//**********************************************************
				
		
		//Modify JavonetFramework version to the one installed on your computer: v35, v40 or v45
		Javonet.activate("sdncenter@gmail.com", "Tj4n-n5Y8-Zi3g-g8NL-p9C2",JavonetFramework.v40);
		Javonet.addReference("log4net.dll");
		Thread.sleep(5000);
		Javonet.getType("BasicConfigurator").invoke("Configure");
		
		NObject log = Javonet.getType("LogManager").invoke("GetLogger","main");
		log.invoke("Debug","Test Javonet!");
	}

}
