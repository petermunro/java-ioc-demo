# Simple IoC Container Example

This project demonstrates a basic implementation of an Inversion of Control (IoC) container in Java. The IoC container is responsible for managing the dependencies between objects and providing them to the client code when needed.

## Overview

The project consists of the following components:

- `Service` interface: Defines a contract for services that can be used by the client.
- `PetesService` and `DanielsService` classes: Concrete implementations of the `Service` interface.
- `Client` class: Represents the client code that depends on a `Service` instance.
- `Main` class: The entry point of the application that sets up the IoC container and wires the dependencies.
- `config.properties` file: Contains the configuration settings for the IoC container.

## How it works

1. The `Main` class reads the configuration file (`config.properties`) to determine which concrete `Service` implementation to use.
2. It creates an instance of the specified `Service` implementation using reflection.
3. The `Main` class creates an instance of the `Client` class and injects the `Service` instance into it via constructor injection.
4. The `Client` instance is then used to invoke the `useService()` method, which internally calls the `doService()` method of the injected `Service` instance.

## Configuration

The IoC container is configured using the `config.properties` file. It contains a single property:

- `service.class`: Specifies the fully qualified class name of the concrete `Service` implementation to be used.

Example configuration:

```
service.class=ioc.PetesService
```

## Usage

1. Clone the repository:

```
git clone https://github.com/your-username/simple-ioc-container.git
```

2. Navigate to the project directory:

```
cd simple-ioc-container
```

3. Compile the Java source files:

```
javac -d classes ioc/*.java
```

5. Run the application:

```
java -cp classes:. ioc.Main
```

The application will output the result of calling the `doService()` method on the configured `Service` implementation.

## Extending the project

To add new `Service` implementations:

1. Create a new class that implements the `Service` interface.
2. Update the `config.properties` file to specify the fully qualified class name of the new `Service` implementation.

## License

This project is open-source and available under the [MIT License](LICENSE).

Feel free to explore and use this project as a learning resource or as a starting point for your own IoC container implementation.