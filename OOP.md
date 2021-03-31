Object Oriented Programming Concept Questions

As you should know by now, there are 4 principles (pillars) of Object Oriented Programming.

Please write a 1-3 paragraphs explaining these 4 concepts further.  Please provide a sufficient enough explanation about these pillars, as well as some examples to illustrate the practical use cases of these principles.  Please be aware, that any copy / pasting from websites can be easily detected.  Don't do that, but rather, explain the concepts in your own words, while providing code examples of each concept.  

********************
1. Encapsulation

* Encapsulation is primarily about protecting and hiding data. Implementing encapsulation prevents direct manipulation of properties from the outside of the class. 
  The data in a class is private while the methods to access the data is public. For example, I have in my APG.java file several private variables that dictate the bits for objects to have for collision reasons. 
  I could easily make those variables public, but I could accidentally modify those values in another class and cause issues.
  By making those values private and creating a getter method for each of those variable, I am able to safely get those values elsewhere and not in any way modify those values.

********************
2. Inheritance

* Inheritance is all about extending a parent or super class a the child class. This allows for the child class to also have the methods and properties of the parent class.
The child class will have everything from the parent class while also having its own properties and methods unique to that child class.
  Classes are like blueprints for objects and if a child class is inheriting from a super class then it adds that blueprint to its own blueprint.
  This can make it so that code/methods that to be used by many classes can be made into its own class to be inherited from. This reduces redundancy that can appear in code.
  For example, in my GameScreen.java file, I have the main screen in that file. The file itself extends to a class called Screen. I am able to use functions provided by the Screen class in order to correctly set up the GameScreen class as a viable screen.

********************
3. Abstraction

* There are three main aspects to abstraction. Those three aspects are simplifying, conceptualizing, and generalizing.
Simplifying means that you are able to hide some code in the super abstract class. This can reduce the verbose code base that a class extends/implements from.
  Conceptualizing is comparing idea vs. reality. You are able to get a class that you do not want to create a concrete object from. You are forcing the programmer to use that class as a base for another class.
  This other class which will inherit from the abstract class will be the reality or the concrete object. Generalizing is simply put as re-usability.
  You can have a Person abstract/interface that will have properties and methods that every Person has. You can have a class for a specific person who will implement that interface.
  You can have many people as classes that will implement from that Person interface. This re-usability reduces redundant code since all of those classes will utilize those same properties and methods.
  In my game, the GameScreen class implements from the Screen interface. I am forced like a contract with this interface to implement the methods in the Screen class.
  I can have many screens (not enough time) that implements the Screen interface and reuse the methods present in that interface.

********************
4. Polymorphism
   
* Polymorphism means many forms. You can either overload or override methods. With overloading you can use the same method name in a class and have different amount of parameters in those methods.
This allows you to, depending on the number of parameters, manipulate or do specific actions. This can be useful by having different results from a method based on the parameters. This allows for more flexibility from methods.
  You can override methods which means that if you inherit from a super class then subclass/child class can implement their own implementation of the method. With an interface, the child class is forced to implement those methods.
  This allows for subclasses to have their own implementation of methods even though they are inheriting from a super class.
  For example, in the APG class I am using the super class Game. This is the like the main where it connects everything about the game.
  I am able to override methods such as Render() and Create(). This allows from my game to have its own implementation of those methods. I want to create sprite batches, and I want to render specific objects onto my game. 