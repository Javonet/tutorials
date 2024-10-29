using System;

namespace HelloJavonetWorld
{
    using Javonet.Netcore.Sdk;
    class MainClass
    {
        static void Main(string[] args)
        {
            // use Activate only once in your application
            Javonet.Activate("Wy83-Kb36-Sx3t-Zp89-Yg82");

            // create called runtime context
            var javaRuntime = Javonet.InMemory().Jvm();

            // load custom library
            javaRuntime.LoadLibrary("../JavaHelloWorld/SampleJava.jar");

            // get type from the runtime
            var javaType = javaRuntime.GetType("SampleJava").Execute();

            // invoke type's static method
            var response = javaType.InvokeStaticMethod("multiplyByTwo", 2).Execute();

            // get value from response
            var result = (string)response.GetValue();

            // write result to console
            System.Console.WriteLine(result);

            //Call Static Multiply Method
            var multiplyResponse = javaType.InvokeStaticMethod("Multiply", 7, 7).Execute();

            // get value from response
            var multiplyResult = (int)multiplyResponse.GetValue();

            // write result to console
            System.Console.WriteLine(multiplyResult);
        }
    }
}