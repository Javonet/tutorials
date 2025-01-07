// Activate Javonet using your license key
Javonet.Netcore.Sdk.Javonet.Activate("p9E8-t2W7-p9NK-Fn48-q9KJ");

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