package JavonetLoggingApp;

import com.javonet.sdk.InvocationContext;
import com.javonet.sdk.Javonet;
import com.javonet.sdk.RuntimeContext;

public class JavonetLoggingAppMain {
	
	private static final String resourcesDirectory = ".";
	
	public static void main(String []args) {
		try {
			 Javonet.activate("p9E8-t2W7-p9NK-Fn48-q9KJ");
		        
		        RuntimeContext calledRuntime = Javonet.inMemory().clr();
		        
		        String libraryPath = "../../log4net.dll";
		        
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
