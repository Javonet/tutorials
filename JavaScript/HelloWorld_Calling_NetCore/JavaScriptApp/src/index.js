const {Javonet} = require('javonet-nodejs-sdk')

// use Activate only once in your app
Javonet.activate("YOUR-JAVONET-LICENSE-KEY")

// create called runtime context
let calledRuntime = Javonet.inMemory().netcore()

// set up variables
let libraryPath = '../../NetCoreHelloWorld/bin/Debug/net8.0/NetCoreHelloWorld.dll'
let className = 'NetCoreHelloWorldProject.ExampleClass'

// load custom library
calledRuntime.loadLibrary(libraryPath)

// get type from the runtime
let calledRuntimeType = calledRuntime.getType(className).execute()

// invoke type's static method (GetHelloWorld)
let response = calledRuntimeType.invokeStaticMethod("GetHelloWorld").execute()

// get value from response (GetHelloWorld)
let result = response.getValue()

// write result to console
console.log(result)