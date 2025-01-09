from javonet.sdk import Javonet

if __name__ == '__main__':
    # use Activate only once in your app
    Javonet.activate("YOUR-JAVONET-LICENSE-KEY")

    # create called runtime context
    jvm_runtime = Javonet.in_memory().jvm()

    # set up variables
    # libraryPath - directory with .jar files
    libraryPath = "JavaHelloWorld\\out\\artifacts\\ExampleClass.jar"
    className = "ExampleClass"

    # load the library
    jvm_runtime.load_library(libraryPath)

    # get type from the runtime
    jvm_type = jvm_runtime.get_type(className).execute()

    # invoke type's static method (GetHelloWorld)
    response = jvm_type.invoke_static_method("GetHelloWorld").execute()
    result = response.get_value()

    # print the result
    print(result)