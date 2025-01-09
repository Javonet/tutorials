from javonet.sdk import Javonet

if __name__ == '__main__':
    # use Activate only once in your app
    Javonet.activate("YOUR_JAVONET_LICENSE_KEY")

    # create called runtime context
    called_runtime = Javonet.in_memory().nodejs()

    # set up variables
    library_path = "JavaScriptHelloWorld\\ExampleClass.js"
    class_name = 'ExampleClass'

    # load custom library
    called_runtime.load_library(library_path)

    # get type from the runtime
    called_runtime_type = called_runtime.get_type(class_name).execute()

    # invoke static method (getHelloWorld) from the runtime
    response = called_runtime_type.invoke_instance_method("getHelloWorld").execute()

    # get value from response (getHelloWorld)
    result = response.get_value()

    # write result to console
    print(result)