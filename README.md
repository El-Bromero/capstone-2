# Capstone 2 - 2D Java Based Terminal Game

There is a file `OOP.md` in the root level of this repository.  Please answer the questions in that file.

The name of the game (pun intended) is a 2D terminal based game, written in Java.  The purpose of this Capstone is to gauge your fluency in Object Oriented Programming and Design.  Realize, there will be the temptation to focus the bulk of your efforts on UI / UX and graphics, as this project is a game after all.  However, it must be emphasized that the ultimate focus should remain around the core tenets and principles of Object Orientation.

Take a look at some screenshots of possible games in the [`game-ideas`](https://github.com/TEKcamp/capstone-2/tree/master/game-ideas) folder. You are not limited to the games in the [`game-ideas`](https://github.com/TEKcamp/capstone-2/tree/master/game-ideas) folder, but those should illustrate a suitable scoping of game complexity for this Capstone.  

Once again, this project is designed to showcase your knowledge of object-oriented programming and design, so let that be your ultimate focus.

Please note that there will be no tolerance for plagarized code (code that is copied and pasted from tutorials, etc.).  If it is determined that this has occured, that project will receive a 0.  

***************************************************************
## UPER - Problem Solving Framework

As with any project or complicated problem, it's important to step back and think through the process for tackling the project.  We will use Polya's Problem Solving Framework to guide us through that process once again.  Don't forget the famous saying, 

<code><i>"If you fail to plan, you plan to fail."</i></code>

In the root of this repository, you will find a a pdf file outlining a methodology to approaching & solving any problem.  The file is called : <code>"Polya's Problem Solving Framework.pdf"</code>  Feel free to research and learn more about the framework online, or stick to the .pdf file as a primary reference.

Before you dive into the coding, be sure to follow the steps of the Prolem Solving framework.  Please do not underestimate the importance of this step!  Be clear and specific about what the problem is.  It is not sufficient to simply say, 

<i>"The problem is to build a terminal game in java."</i>

That definitely is the core assignment, but it is not specific.  The above statement does not clearly spell out the exact problems that you as the developer are faced with when tackling this project.  The problem needs to cater towards you **specifically**, where you clearly identify what are the issues, blockers, and challenges that lie ahead of you on the path to reach the end goal.  

Clearly defining the problem is often times the most overlooked and vital step to any complicated project.  Get in the habit of contemplating and documenting what the problem is <code><strong>before</strong></code> you start writing code.  

Step 2 of UPER is <strong>Planning</strong>.  After you have brainstormed and thought about the problems facing you as the developer of this java based game, you should clearly map <strong>each</strong> problem to a clear action item.  These action item steps will go in the plan section of the <code>UPER.md</code> document.  

Realize that even Step 2 - Plan, of the Problem Solving framework should also be primarily done <strong>before</strong> you start coding.  

Document the steps you will be taking for this project in the <code>UPER.md</code> file.  

Also, for step 2 of U<strong>P</strong>ER, you will need to use some OOP design tools to set up your Architecture.  These tools are called `Class Diagrams`, part of a graphical language known as <code>UML</code>.  You can learn about `UML` at the following url:

[UML Class Diagram Tutorial](https://www.lucidchart.com/pages/uml-class-diagram#discovery__top)

There are several UML modeling tools you could use to creat your Class Diagrams and/or State Diagrams.  Below are a few options : 

- [GenMyModel](https://app.genmymodel.com/)
- [Creately](https://creately.com/diagram-type/class-diagram)
- [Visual Paradigm (VP) Online](https://online.visual-paradigm.com/diagrams/solutions/free-class-diagram-tool/)
- [Lucidchart](https://www.lucidchart.com/)
- [MS Visio,](https://www.microsoft.com/en-us/microsoft-365/visio/flowchart-software), etc.

To help kickstart your "Understanding the Problem / Planning phases of the project, take a look at the following article:

- [How to create a Text Based Game](https://levelskip.com/classic/Make-a-Text-Based-Game)
- [Java Games basics](https://zetcode.com/javagames/basics/)

A final point to note, as you code the project, you will most likely need to go back to the UPER.md document to add & modify it incrementally. 

This will be especially applicable to  Step 4 of UPER - **Reflection / Refactoring**

***************************************************************
## Core Features : ⭐️ ⭐️ ⭐️

- Game playable by a user, with working game logic.
- Basic Game state management (Score, Points, etc.) 
- Basic, Presentable UI (does not have to be a 3rd party GUI)
- Documented instructions for how to play the game.  A file <code>instructions.md</code> has been provided.
- Include elements of the game using Java classes that adhere to the four pillars of Object Oriented Programming: 
  1.  Encapsulation
  2.  Inheritance
  3.  Abstraction
  4.  Polymorphism 

- Basic Project Structure
- Basic Unit Test Coverage


****************************************************************
## Advanced Features ⭐️ ⭐️ ⭐️ ⭐️ ⭐️
* Game state is effectively tracked and managed (Points, Lives, High Score, Location History of player movement, etc.)
* Incorporate SOLID principles of Object Oriented Design into your project.  

  * Single Responsibility Principle
  * Open Closed Principle
  * Liskov Substitution Principle
  * Interface Segregation Principle
  * Dependency Inversion Principle

* Incorporate some Object Oriented Design Patterns into your project.  There are many patterns, but here are a few examples:
  
  * Singleton
  * Facade
  * Observer
  * Factory
  * Adapter

For the OOD Principles and Patterns, you should be able to explain them clearly and demonstrate how you used them in your code to earn a full score on these categories.
  
* Implement a 3rd party Java library to aid you in Java Game Development.  A few examples: (NOTE : this is not a core feature, but an advanced feature)
  * [Slick2D](http://slick.ninjacave.com/)
  * [LWJGL](https://www.lwjgl.org/)
  * [libGDX](https://libgdx.badlogicgames.com/)
  * [LITIENGINE](https://litiengine.com/)
  * [Java Swing](https://docs.oracle.com/javase/tutorial/uiswing/)

* Implement TDD (Test Driven Development) to build your application.  This involves Oscillating between test and production code, and having your git commit history reflective of that oscillation.  If properly adhering to the TDD approach, you should end up with a suite of unit tests that comprehensively covers your application.   
  
* Error handling for bad user input (incorrect key press, bad input) etc.
  
* Instructions implemented in the Game UI

## ********************************************************
## Git Instructions

- [ ] Create a template copy of this repository by clicking : "Use this template"
- [ ] Name the repository the same name as the master template repository.  
- [ ] Add your TM as collaborator
- [ ] Clone YOUR repo to your local computer
- [ ] Create a new branch: <code>git checkout -b `<firstName-lastName>`</code>.
- [ ] Implement the project on your newly created `<firstName-lastName>` branch, committing changes regularly.
- [ ] Push all of your commits: <code>git push origin `<firstName-lastName>`</code>.
- [ ] When ready for your TM to review, open a Pull Request (PR) and add your TM as a collaborator.

## ********************************************************