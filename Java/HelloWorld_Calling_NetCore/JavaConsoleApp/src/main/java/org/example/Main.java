package org.example;

import com.javonet.sdk.*;

public class Main {
    public static void main(String[] args) {
        // use activate only once in your app
        Javonet.activate("YOUR-JAVONET-LICENSE-KEY");

        // create called runtime context
        RuntimeContext calledRuntime = Javonet.inMemory().netcore();

        // set up variables
        String libraryPath = "../NetCoreHelloWorld/bin/Debug/net8.0/NetCoreHelloWorld.dll";
        String className = "NetCoreHelloWorld.ExampleClass";

        // load custom library
        calledRuntime.loadLibrary(libraryPath);

        // get type from runtime
        InvocationContext calledRuntimeType = calledRuntime.getType(className).execute();

        // invoke type's method (GetHelloWorld)
        InvocationContext response = calledRuntimeType.invokeStaticMethod("GetHelloWorld").execute();

        // get value from response (GetHelloWorld)
        String result = (String)response.getValue();

        // write result to console
        System.out.println(result);
    }
}