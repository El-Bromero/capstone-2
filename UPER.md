<h1>The Problem Solving Framework : 'UPER'</h1>

* U = "Understand"
* P = "Plan"
* E = "Execute"
* R = "Reflect" / "Refactor"

<h2>1. Understanding the Problem</h2>
* Create a game using Java. Primary focus on OOP and OOD principles
* Game should have a playable character
* Game should have a basic game state management like score
* A basic UI on the game
* Instructions on a md file or in the game options
* At least the 4 pillars of OOP. OOD are advanced features
* Basic project structure
* Basic unit test coverage (at least 5)
<h2>
    2. Planning the Solution
</h2>
* Use UML to layout project classes and how they connect to each other. Still, cannot finish it this early since I don't know the full extend of a 3rd party library
* Going to use LWJGL which incorporates OpenGL. I have messed with OpenGL before. There are videos in Youtube and OpenGL has documentation in C
* Going to need a window for the game to appear in
* Going to need render function. Set up sprite entities like player and enemy
* Tiled is a great application for tile map creation. Can look up for free sprite editors online for player and background sprites

<h2>
    3. Executing the Plan
</h2>

* After trying out LWJGL I have determined it is not the right fit right now. Too much code just to set things up. Going to switch to LibGDX since it seems to be easier to manage and to use their library
* Have a tile set for the environment of the game. Game character is playable
* Have present blocks that the player can hit and collect points that way
* Basic scoring system and timer UI incorporated
* So far these steps have been correct/working as intended
* Victory screen if player reaches the gem at the end of the level
* Game over screen if the player runs out of time
<h2>
    4. Reflection / Refactor
</h2>
* Starting with LWJGL was a mistake for me in the beginning. I should have researched more about that library beforehand. I let my previous experience cloud my judgement
* A library such as LibGDX was extremely easy to use. Setting up is a lot easier than LWJGL
* I could have implemented more if I didn't spend as much time on LWJGL instead of LibGDX
* I was able to utilize many libraries that LibGDX provides for classes such as game screens, sprites, contact listeners, and Box2D
* I was able to effectively implement all 4 pillars of OOP into my project. I should have attempted to incorporate more OOD patterns into my design.