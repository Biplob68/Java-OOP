##### SOLID principles are object-oriented design concepts relevant to software development. SOLID is an acronym for five other class-design principles: Single Responsibility Principle, Open-Closed Principle, Liskov Substitution Principle, Interface Segregation Principle, and Dependency Inversion Principle.

_1. Single Responsibility Principle : This principle states that a class should only have one responsibility. Furthermore, it should only have one reason to change.How does this principle help us to build better software? Let's see a few of its benefits:_

    Testing – A class with one responsibility will have far fewer test cases.
    Lower coupling – Less functionality in a single class will have fewer dependencies.
    Organization – Smaller, well-organized classes are easier to search than monolithic ones.

```
public class Vehicle {
    public void printDetails() {}
    public double calculateValue() {}
    public void addVehicleToDB() {}
} 
```
The Vehicle class has three separate responsibilities: reporting, calculation, and database that does not follow the single responsibility principle. By applying SRP, we can separate the above class into three classes with separate responsibilities.

_2. Open-closed principle: Classes should be open for extension but closed for modification. In doing so, we stop ourselves from modifying existing code and causing potential new bugs in an otherwise happy application._

```
public class VehicleCalculations {
    public double calculateValue(Vehicle v) {
        if (v instanceof Car) {
            return v.getValue() * 0.8;
        if (v instanceof Bike) {
            return v.getValue() * 0.5;

    }
}
```
Suppose we now want to add another subclass called Truck. We would have to modify the above class by adding another if statement, which goes against the Open-Closed Principle. A better approach would be for the subclasses Car and Truck to override the calculateValue method:

```
public class Vehicle {
    public double calculateValue() {...}
}
public class Car extends Vehicle {
    public double calculateValue() {
        return this.getValue() * 0.8;
}
public class Truck extends Vehicle{
    public double calculateValue() {
        return this.getValue() * 0.9;
} 
```
_3. Liskov Substitution: The Liskov Substitution Principle states that subclasses should be substitutable for their base classes._


_4. Interface Segregation: Interface segregation, and it simply means that larger interfaces should be split into smaller ones. By doing so, we can ensure that implementing classes only need to be concerned about the methods that are of interest to them. The Interface Segregation Principle (ISP) states that clients should not be forced to depend upon interface members they do not use._


```
public interface Vehicle {
    public void drive();
    public void stop();
    public void refuel();
    public void openDoors();
}
public class Bike implements Vehicle {

    // Can be implemented
    public void drive() {...}
    public void stop() {...}
    public void refuel() {...}
    
    // Can not be implemented
    public void openDoors() {...}
}
```
As you can see, it does not make sense for a Bike class to implement the openDoors() method as a bike does not have any doors! To fix this, ISP proposes that the interfaces be broken down into multiple, small cohesive interfaces so that no class is forced to implement any interface, and therefore methods, that it does not need.

_5. Dependency Inversion: The principle of dependency inversion refers to the decoupling of software modules. This way, instead of high-level modules depending on low-level modules, both will depend on abstractions._
```
public class Car {
    private Engine engine;
    public Car(Engine e) {
        engine = e;
    }
    public void start() {
        engine.start();
    }
}
public class Engine {
   public void start() {...}
}
```
the code will work but if we add another engine then the car will require refacting. so we should declear the engine class as interfacer. 
```
public interface Engine {
    public void start();
}
```
```
public class Car {
    private Engine engine;
    public Car(Engine e) {
        engine = e;
    }
    public void start() {
        engine.start();
    }
}
public class PetrolEngine implements Engine {
   public void start() {...}
}
public class DieselEngine implements Engine {
   public void start() {...}
}
```
Now we can connect any kind of engine. SO by this technique we decouple our class. 
