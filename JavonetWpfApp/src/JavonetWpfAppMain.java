import com.javonet.Javonet;
import com.javonet.JavonetApartmentState;
import com.javonet.JavonetException;
import com.javonet.api.NEventListener;
import com.javonet.api.NObject;


public class JavonetWpfAppMain {

	/**
	 * @param args
	 * @throws JavonetException 
	 */
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
		// 2) You have updated javonet.xml file by replacing
		// default email address and license key with your activation
		// details.
		//
		// To obtain FREE trial license key please visit:
		// http://www.javonet.com/signup-for-trial/
		// *********************************************************
		
		NObject window = Javonet.New("System.Windows.Window");
		window.set("Title", "JavOnet WPF Window");
		
		NObject stackPanel = Javonet.New("StackPanel");
		
		final NObject label = Javonet.New("System.Windows.Controls.Label");
		label.set("Content", "Press button to show date");
		label.set("Width",300);
		label.set("Height",150);
		
		NObject button = Javonet.New("System.Windows.Controls.Button");
		button.set("Content", "Press to Show Date and Time");
		button.set("Width",300);
		button.set("Height",150);
		
		button.addEventListener("Click",new NEventListener() {
			public void eventOccurred(Object[] arguments) {
				try {
					String currentDate = Javonet.getType("DateTime").getRef("Now").invoke("ToString","yyyy-MM-dd HH:mm:ss.fff");
					label.set("Content", currentDate);
				} catch (JavonetException e) {
					e.printStackTrace();
				}
			}
		});
		
		stackPanel.<NObject>get("Children").invoke("Add",button);
		stackPanel.<NObject>get("Children").invoke("Add",label);
		window.set("Content", stackPanel);
		
		NObject app = Javonet.New("System.Windows.Application");
		app.invoke("Run",window);
	}

}
