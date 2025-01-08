from javonet.sdk import Javonet

if __name__ == '__main__':
    # use Activate only once in your app
    Javonet.activate("YOUR_JAVONET_LICENSE_KEY")

    # create called runtime context
    netcore_runtime = Javonet.in_memory().netcore()

    # set up variables
    # libraryPath - directory with .dll files, compiled from .NET Core project
    libraryPath = "NetCoreHelloWorld\\bin\\Debug\\net8.0\\NetCoreHelloWorld.dll"
    className = "NetCoreHelloWorldProject.ExampleClass" # {namespace}.{classname}

    # load the library
    netcore_runtime.load_library(libraryPath)

    # get type from the runtime
    netcore_type = netcore_runtime.get_type(className).execute()

    # invoke type's static method (GetHelloWorld)
    response = netcore_type.invoke_static_method("GetHelloWorld").execute()
    result = response.get_value()

    # print the result
    print(result)