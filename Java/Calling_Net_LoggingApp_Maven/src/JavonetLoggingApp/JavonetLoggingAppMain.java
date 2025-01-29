package JavonetLoggingApp;

import com.javonet.sdk.InvocationContext;
import com.javonet.sdk.Javonet;
import com.javonet.sdk.RuntimeContext;

public class JavonetLoggingAppMain {
	
	private static final String resourcesDirectory = "D:\\Proksy\\java\\eclipse-ws\\JavonetLoggingApp";
	
	public static void main(String []args) {
		try {
			Javonet.activate("your-license-key");
		        
	        RuntimeContext calledRuntime = Javonet.inMemory().clr();
	        
	        String libraryPath = resourcesDirectory + "/log4net.dll";
	        
	        calledRuntime.loadLibrary(libraryPath);
	        
	        InvocationContext basicConfigurator = calledRuntime.getType("log4net.Config.BasicConfigurator").execute();
	        
	        basicConfigurator.invokeStaticMethod("Configure").execute();
	        
	        InvocationContext logManager = calledRuntime.getType("log4net.LogManager").execute();
	        
	        InvocationContext log = logManager.invokeStaticMethod("GetLogger", "Program").execute();
	        
	        log.invokeInstanceMethod("Info","Testing Javonet!").execute();
		} catch (Exception e) {
			e.printStackTrace();
		}       
     }
}
