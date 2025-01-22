import com.javonet.Javonet;
import com.javonet.JavonetException;
import com.javonet.api.NEnum;
import com.javonet.api.NEventListener;
import com.javonet.api.NObject;


public class CalculatorForm extends NObject {
	private NObject button1,button2,button3,button4,button5,button6,button7,button8,button9,button0;
	private NObject buttonAdd,buttonSum,buttonC;
	private NObject tbDisplay;
	private Integer result=0;
	private String operation="";
	
	public CalculatorForm() throws JavonetException
	{
		super("System.Windows.Forms.Form");
		InitializeComponents();
	}
	
	public void ShowDialog() throws JavonetException
	{
		this.invoke("ShowDialog");
	}
	
	private void InitializeComponents() throws JavonetException
	{
		this.set("Text", "Javonet Calculator");
		this.set("Width", 266);
		
		tbDisplay=Javonet.New("System.Windows.Forms.TextBox");
		tbDisplay.set("Width", 250);
		tbDisplay.set("Height", 100);
		tbDisplay.set("Text", "0");
		tbDisplay.set("TextAlign", new NEnum("System.Windows.Forms.HorizontalAlignment","Right"));
		NObject font = Javonet.New("System.Drawing.Font","Verdana", 24F);
		tbDisplay.set("Font", font);
		
		button1=Javonet.New("System.Windows.Forms.Button");
		button1.set("Height", 50);
		button1.set("Width", 50);
		button1.set("Top", 50);
		button1.set("Text", "1");
		button1.addEventListener("Click", new NEventListener() {
			public void eventOccurred(Object[] arguments) {
				button1_Click((NObject)arguments[0],(NObject)arguments[1]);
			}
		});
		
		button2=Javonet.New("System.Windows.Forms.Button");
		button2.set("Height", 50);
		button2.set("Width", 50);
		button2.set("Top", 50);
		button2.set("Left", 50);
		button2.set("Text", "2");
		button2.addEventListener("Click", new NEventListener() {
			public void eventOccurred(Object[] arguments) {
				button2_Click((NObject)arguments[0],(NObject)arguments[1]);
			}
		});
		
		button3=Javonet.New("System.Windows.Forms.Button");
		button3.set("Height", 50);
		button3.set("Width", 50);
		button3.set("Top", 50);
		button3.set("Left", 100);
		button3.set("Text", "3");
		button3.addEventListener("Click", new NEventListener() {
			public void eventOccurred(Object[] arguments) {
				button3_Click((NObject)arguments[0],(NObject)arguments[1]);
			}
		});
		
		button4=Javonet.New("System.Windows.Forms.Button");
		button4.set("Height", 50);
		button4.set("Width", 50);
		button4.set("Top", 100);
		button4.set("Text", "4");
		button4.addEventListener("Click", new NEventListener() {
			public void eventOccurred(Object[] arguments) {
				button4_Click((NObject)arguments[0],(NObject)arguments[1]);
			}
		});
		
		button5=Javonet.New("System.Windows.Forms.Button");
		button5.set("Height", 50);
		button5.set("Width", 50);
		button5.set("Top", 100);
		button5.set("Left",50);
		button5.set("Text", "5");
		button5.addEventListener("Click", new NEventListener() {
			public void eventOccurred(Object[] arguments) {
				button5_Click((NObject)arguments[0],(NObject)arguments[1]);
			}
		});
		
		button6=Javonet.New("System.Windows.Forms.Button");
		button6.set("Height", 50);
		button6.set("Width", 50);
		button6.set("Top", 100);
		button6.set("Left",100);
		button6.set("Text", "6");
		button6.addEventListener("Click", new NEventListener() {
			public void eventOccurred(Object[] arguments) {
				button6_Click((NObject)arguments[0],(NObject)arguments[1]);
			}
		});
		
		button7=Javonet.New("System.Windows.Forms.Button");
		button7.set("Height", 50);
		button7.set("Width", 50);
		button7.set("Top", 150);
		button7.set("Text", "7");
		button7.addEventListener("Click", new NEventListener() {
			public void eventOccurred(Object[] arguments) {
				button7_Click((NObject)arguments[0],(NObject)arguments[1]);
			}
		});
		
		button8=Javonet.New("System.Windows.Forms.Button");
		button8.set("Height", 50);
		button8.set("Width", 50);
		button8.set("Top", 150);
		button8.set("Left",50);
		button8.set("Text", "8");
		button8.addEventListener("Click", new NEventListener() {
			public void eventOccurred(Object[] arguments) {
				button8_Click((NObject)arguments[0],(NObject)arguments[1]);
			}
		});
		
		button9=Javonet.New("System.Windows.Forms.Button");
		button9.set("Height", 50);
		button9.set("Width", 50);
		button9.set("Top", 150);
		button9.set("Left",100);
		button9.set("Text", "9");
		button9.addEventListener("Click", new NEventListener() {
			public void eventOccurred(Object[] arguments) {
				button9_Click((NObject)arguments[0],(NObject)arguments[1]);
			}
		});
		
		button0=Javonet.New("System.Windows.Forms.Button");
		button0.set("Height", 50);
		button0.set("Width", 50);
		button0.set("Top", 200);
		button0.set("Text", "0");
		button0.addEventListener("Click", new NEventListener() {
			public void eventOccurred(Object[] arguments) {
				button0_Click((NObject)arguments[0],(NObject)arguments[1]);
			}
		});
		
		buttonAdd=Javonet.New("System.Windows.Forms.Button");
		buttonAdd.set("Height", 50);
		buttonAdd.set("Width", 50);
		buttonAdd.set("Top", 50);
		buttonAdd.set("Left", 150);
		buttonAdd.set("Text", "+");
		buttonAdd.addEventListener("Click", new NEventListener() {
			public void eventOccurred(Object[] arguments) {
				try { buttonAdd_Click((NObject)arguments[0],(NObject)arguments[1]); } catch (Exception ex) {}
			}
		});
		
		buttonC=Javonet.New("System.Windows.Forms.Button");
		buttonC.set("Height", 50);
		buttonC.set("Width", 50);
		buttonC.set("Top", 100);
		buttonC.set("Left", 150);
		buttonC.set("Text", "C");
		buttonC.addEventListener("Click", new NEventListener() {
			public void eventOccurred(Object[] arguments) {
				try { buttonC_Click((NObject)arguments[0],(NObject)arguments[1]); } catch (Exception ex) {}
			}
		});
		
		buttonSum=Javonet.New("System.Windows.Forms.Button");
		buttonSum.set("Height", 50);
		buttonSum.set("Width", 50);
		buttonSum.set("Top", 50);
		buttonSum.set("Left", 200);
		buttonSum.set("Text", "=");
		buttonSum.addEventListener("Click", new NEventListener() {
			public void eventOccurred(Object[] arguments) {
				try { buttonSum_Click((NObject)arguments[0],(NObject)arguments[1]); } catch (Exception ex) {}
			}
		});
		
		this.getRef("Controls").invoke("Add", button1);
		this.getRef("Controls").invoke("Add", button2);
		this.getRef("Controls").invoke("Add", button3);
		this.getRef("Controls").invoke("Add", button4);
		this.getRef("Controls").invoke("Add", button5);
		this.getRef("Controls").invoke("Add", button6);
		this.getRef("Controls").invoke("Add", button7);
		this.getRef("Controls").invoke("Add", button8);
		this.getRef("Controls").invoke("Add", button9);
		this.getRef("Controls").invoke("Add", button0);
		this.getRef("Controls").invoke("Add", buttonAdd);
		this.getRef("Controls").invoke("Add", buttonC);
		this.getRef("Controls").invoke("Add", buttonSum);
		this.getRef("Controls").invoke("Add", tbDisplay);
	}
	
	private void button1_Click(NObject sender, NObject e)
	{
		NumberPressed(1);
	}
	
	private void button2_Click(NObject sender, NObject e)
	{
		NumberPressed(2);
	}
	
	private void button3_Click(NObject sender, NObject e)
	{
		NumberPressed(3);
	}
	
	private void button4_Click(NObject sender, NObject e)
	{
		NumberPressed(4);
	}
	
	private void button5_Click(NObject sender, NObject e)
	{
		NumberPressed(5);
	}
	
	private void button6_Click(NObject sender, NObject e)
	{
		NumberPressed(6);
	}
	
	private void button7_Click(NObject sender, NObject e)
	{
		NumberPressed(7);
	}
	
	private void button8_Click(NObject sender, NObject e)
	{
		NumberPressed(8);
	}
	
	private void button9_Click(NObject sender, NObject e)
	{
		NumberPressed(9);
	}
	
	private void button0_Click(NObject sender, NObject e)
	{
		NumberPressed(0);
	}
	
	private void buttonAdd_Click(NObject sender, NObject e) throws JavonetException
	{
		int number = Integer.parseInt(tbDisplay.<String>get("Text"));
		result = number;
		operation="+";
		tbDisplay.set("Text", "+");
	}
	
	private void buttonC_Click(NObject sender, NObject e) throws JavonetException
	{
		tbDisplay.set("Text", "0");
		result=0;
		operation="";
	}
	
	private void buttonSum_Click(NObject sender, NObject e) throws JavonetException
	{
		int number = Integer.parseInt(tbDisplay.<String>get("Text"));
		if (operation.equals("+"))
			result = result+number;
		tbDisplay.set("Text", result.toString());
	}
	
	private void NumberPressed(Integer number)
	{
		try {
			String current = tbDisplay.<String>get("Text");

			if (current.equals(operation) || current.equals("0"))
				current="";
			tbDisplay.set("Text", current+number.toString());
		} catch (JavonetException e) {
			e.printStackTrace();
		}
	}
}
