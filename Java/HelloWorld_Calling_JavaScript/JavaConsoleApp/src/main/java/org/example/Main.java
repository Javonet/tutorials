package org.example;

import com.javonet.sdk.*;

public class Main {
    public static void main(String[] args) {
        // use activate only once in your app
        Javonet.activate("YOUR-JAVONET-LICENSE-KEY");

        // create called runtime context
        RuntimeContext calledRuntime = Javonet.inMemory().nodejs();

        // set up variables
        String libraryPath = "../JavaScriptHelloWorld/ExampleClass.js";
        String className = "ExampleClass";

        // load custom library
        calledRuntime.loadLibrary(libraryPath);

        // get type from runtime
        InvocationContext calledRuntimeType = calledRuntime.getType(className).execute();

        // invoke type's method (GetHelloWorld)
        InvocationContext response = calledRuntimeType.invokeStaticMethod("getHelloWorld").execute();

        // get value from response (GetHelloWorld)
        String result = (String)response.getValue();

        // write result to console
        System.out.println(result);
    }
}