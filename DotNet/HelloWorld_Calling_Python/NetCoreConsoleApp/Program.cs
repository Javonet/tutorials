namespace JavonetPython31StaticMethodInvokeExample;
using Javonet.Netcore.Sdk;

internal class Program
{
    static void Main(string[] args)
    {
        // use Activate only once in your app
        Javonet.Activate("YOUR_JAVONET_LICENSE_KEY");

        // create called runtime context
        var calledRuntime = Javonet.InMemory().Python();

        // libraryPath - directory with .py files
        string libraryPath = @"..\PythonHelloWorld";

        // "{module_name}.{class_name}"
        string className = "program.Program";

        // load custom library
        calledRuntime.LoadLibrary(libraryPath);

        // get type from the runtime
        var calledRuntimeType = calledRuntime.GetType(className).Execute();

        // invoke type's static method (get_hello_world)
        var response = calledRuntimeType.InvokeStaticMethod("get_hello_world").Execute();

        // get value from response (get_hello_world)
        var result = (string)response.GetValue();

        // write result to console
        Console.WriteLine(result);
    }
}
