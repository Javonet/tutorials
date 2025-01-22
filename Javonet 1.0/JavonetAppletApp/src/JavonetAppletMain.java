 //Reference the required Java libraries
import java.applet.Applet; 
import java.awt.*; 
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BoxLayout;

import com.javonet.Javonet;
import com.javonet.JavonetException;
import com.javonet.JavonetFramework;
import com.javonet.api.NObject;
 
 //The applet code
 public class JavonetAppletMain extends Applet {

	private static final long serialVersionUID = 1L;
	
	public JavonetAppletMain()
	{
    	try {
    		System.out.println("Javonet: Creating temp directory for .NET DLLs");
			//We are creating temporary directory were Javonet license file will be stored
			//This directory can be used to extract and store our .NET dlls which should
			//be loaded by applet
			Path p = Files.createTempDirectory("Javonet");
			System.out.println("Temp Directory: " + p.toAbsolutePath());
			
			System.out.println(String.format("Javonet: Setting temp %s directory as current dir", p.toAbsolutePath().toString()));
			//We overwrite default current directory so .NET side will use our temp directory
			//instead of default for applets path which is set to users desktop
			setCurrentDirectory(p.toAbsolutePath().toString());		    	        
			
			System.out.println("Javonet: Activating Javonet...");
			//Activate Javonet
			Javonet.activate("your@mail.com", "your-javonet-license-key",JavonetFramework.v40);
			
			System.out.println("Javonet: Extracting .NET DLLs to local temp directory...");
			//Extract Custom .NET DLLs from your JAR file
			String myLibPath = extractDotNetLib("Javonet.ValueTypesSample.dll",p.toAbsolutePath().toString());
			
			System.out.println("Javonet: Loading .NET DLLs references...");
			//Add Reference to extracted Custom .NET DLL
			Javonet.addReference(myLibPath);
			
			System.out.println("Javonet: Loaded and initialized.");
			
		} catch (JavonetException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void init() {
		setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
		
		final Label label = new Label("Look at me, I'm a Java Applet using .NET!");
        add(label);
        
		final Label label2 = new Label("Hello world!");
        add(label2);
        
		final Label label3 = new Label("Hello world!");
        add(label3);
        
		Timer timer = new Timer();
		
		timer.scheduleAtFixedRate(new TimerTask() {
			  @Override
			  public void run() {
				  try 
			    	{				
						//Sample code using .NET Framework Random Class
						NObject objRandom = Javonet.New("System.Random");
						int value = objRandom.invoke("Next",10,20);

						//Display result on JAVA Applet labels
						label2.setText(".NET generated random number: "+value+"!");
						
						//Sample code using custom class "Sample" from extracted DLL file
						NObject sampleObj = Javonet.New("Sample");
						Integer result = sampleObj.invoke("AddInt",value,5);
						
						//Display result calculated using custom .NET DLL
						label3.setText("Random number + 5 calculated using custom .NET dll: "+result+"!");
					} 
			    	catch (JavonetException e) 
			    	{
						// TODO Auto-generated catch block
						e.printStackTrace();
						label3.setText(e.toString()); 
					}
			  }
			}, 500, 500);
	}
	
    /**
	 * This Hepler method has been added to allow you quickly extract custom .NET DLLs
	 * included in your JAVA Applet JAR file
     * @param dotNetFile Name of .NET file with extension which should be extracted from JAR
     * @param path String absolute path to created temporary directory
     * @return Returns Path to extracted .NET file in temporary dir. Because we use createTempFile method
     * the file "Sample.dll" will be named "Sample{SOME_RANDOM_DIGITS}.dll"
     */
	public static String extractDotNetLib(String dotNetFile, String path) throws IOException{
        InputStream inClr = JavonetAppletMain.class.getResourceAsStream("/"+dotNetFile);
        
        File fClr = File.createTempFile(dotNetFile.replace(".dll", ""), ".dll",new File(path));
        FileOutputStream outClr = new FileOutputStream(fClr);
        
        byte[] bufClr = new byte[1024];
        int lenClr;
        while ((lenClr = inClr.read(bufClr)) > 0)
            outClr.write(bufClr, 0, lenClr);
        inClr.close();
        outClr.close();
        return fClr.getAbsolutePath();
	}
	
    /**
     * This method replaces default currentdirectory set for java applets to users Desktop path
     * with our custom path which points in this example to temporary directory
     * @param directory_name Absolute path to created temporary directory
     * @return
     */
    public static boolean setCurrentDirectory(String directory_name)
     {
         boolean result = false;  // Boolean indicating whether directory was set
         File    directory;       // Desired current working directory

         directory = new File(directory_name).getAbsoluteFile();
         if (directory.exists() || directory.mkdirs())
         {
             result = (System.setProperty("user.dir", directory.getAbsolutePath()) != null);
         }

         return result;
     }

 } 