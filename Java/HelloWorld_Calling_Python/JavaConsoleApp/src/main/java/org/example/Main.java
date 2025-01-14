package org.example;

import com.javonet.sdk.*;

public class Main {
    public static void main(String[] args) {
        // use activate only once in your app
        Javonet.activate("YOUR-JAVONET-LICENSE-KEY");

        // create called runtime context
        RuntimeContext calledRuntime = Javonet.inMemory().python();

        // set up variables
        String libraryPath = "../PythonHelloWorld";
        String className = "program.Program";

        // load custom library
        calledRuntime.loadLibrary(libraryPath);

        // get type from runtime
        InvocationContext calledRuntimeType = calledRuntime.getType(className).execute();

        // invoke type's method (get_hello_world)
        InvocationContext response = calledRuntimeType.invokeStaticMethod("get_hello_world").execute();

        // get value from response (get_hello_world)
        String result = (String)response.getValue();

        // write result to console
        System.out.println(result);
        System.out.println(result);
    }
}