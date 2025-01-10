const {Javonet} = require('javonet-nodejs-sdk')

// use Activate only once in your app
Javonet.activate("YOUR-JAVONET-LICENSE-KEY")

// create called runtime context
let pythonRuntime = Javonet.inMemory().python()

// set up variables
// libraryPath - directory with .py files
const libraryPath = "..\\..\\PythonHelloWorld"

// "{module_name}.{class_name}"
const className = "program.Program";

pythonRuntime.loadLibrary(libraryPath)

// get type from the runtime
const pythonType = pythonRuntime.getType(className).execute()

// invoke type's static method (get_hello_world)
const response = pythonType.invokeStaticMethod("get_hello_world").execute();

// get value from response (GetHelloWorld)
const result = response.getValue()

// print result
console.log(result)