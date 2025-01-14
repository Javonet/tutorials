// Activate Javonet using your license key
Javonet.Netcore.Sdk.Javonet.Activate("YOUR-ACTIVATION-KEY");

// Initialize Java runtime environment
var rtmCtx = Javonet.Netcore.Sdk.Javonet.InMemory().Jvm();

// Load Java JAR file
rtmCtx.LoadLibrary("../JavaHelloWorld/JavaHelloWorld.jar");

// Access Java class
var javaType = rtmCtx.GetType("SampleJavaClass").Execute();

// Call HelloWorld method
var result = javaType.InvokeStaticMethod("HelloWorld").Execute();

// Show the result (Hello World)
Console.WriteLine(result.GetValue());
