package JavonetTomcatWebApp;



import com.javonet.Javonet;
import com.javonet.JavonetException;
import com.javonet.JavonetFramework;
import com.javonet.api.NObject;


public class TestJavonet {
	public static final String TMP_DIR = System.getProperty("java.io.tmpdir");
	public String CallDotNetRandom()
	{
		try {
			if (!Javonet.isActivated()) {
				System.out.println("Setting temporary directory for Javonet lic file to: "+TMP_DIR);
				Javonet.setLicenseDirectory(TMP_DIR);
				//Put your Javonet trial, academic or commercial key here
				//To apply for your Javonet license go to: https://www.javonet.com/pricing/
				Javonet.activate("******", "******",JavonetFramework.v45);
			}
			NObject objRandom = com.javonet.Javonet.New("System.Random");
			Integer value = objRandom.invoke("Next",10,20);
			return value.toString();
			
		} catch (JavonetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return e.getMessage();
		}
	}
}
