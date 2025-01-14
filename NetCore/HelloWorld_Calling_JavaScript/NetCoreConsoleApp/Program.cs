namespace NetCoreCallingJavaScript;

using Javonet.Netcore.Sdk;

internal class Program
{
    static void Main(string[] args)
    {
        // use Activate only once in your app
        Javonet.Activate("YOUR-JAVONET-LICENSE-KEY");

        // create called runtime context
        var calledRuntime = Javonet.InMemory().Nodejs();

        // set up variables
        // libraryPath - directory with .js files
        string libraryPath = @"../JavaScriptHelloWorld/ExampleClass.js";
        string className = "ExampleClass";

        // load custom library
        calledRuntime.LoadLibrary(libraryPath);

        // get type from the runtime
        var calledRuntimeType = calledRuntime.GetType(className).Execute();

        // invoke type's static method (getHelloWorld)
        var response = calledRuntimeType.InvokeStaticMethod("getHelloWorld").Execute();

        // get value from response
        var result = (string)response.GetValue();
        
        // write result to console
        Console.WriteLine(result);
    }
}
