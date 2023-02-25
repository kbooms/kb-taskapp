# Taskmin Devlog/Changelog
All notable changes to this to this project will be documented in this file.  

## 2/25/2023
### Added
- `promptForString` method to `CommandLine` class
- surrounded `app.run()` in try catch block
	+ error came up with InterruptionException
- `run()` method to `ToDoList` class
	+ instantiates it's own `CommandLine`
	+ redisplays banner
	+ displays the tasklist (not fully written yet)

#### ToDo
- continue writing `ToDoList` run method
- `FileManager` and Help section

#### Notes
List options are not currently being displayed, prompt still holds for user input. Currently exits method when anything is entered and goes back to main switch loop.

## 2/23/2023
### Added
- Menu options array to App
- Main run sequence (while loop, switch statement)
- Changed `displayBanner()`, added tagline
- Changed `ToDoList` constructor to accept list again
  
### Removed
- Broke some tests, fine for now
	+ Planning fix in future update
- Rewrote `CommandLine` class structure
#### Todo
- Implement List handler methods for `ToDoList` class
	+ `run` method needs to be written
	+ Help section
- `FileManager` class future implement
	 

## 2/18/2023 
### Added
- `CommandLine` class
- `CommandLineTests` class
- Wrote basic greeting method to test manually in `App` class
- Wrote test to verify greeting hasn't changed
- Added a text banner display method
- Method to display main menu
- Method to display list menu
- Added `App` constructor with Command Line
- Added basic `run()` method
	+ setting up to structure app runtime
  
***
## 2/17/2023
### Added
- Test Cases for ToDoList
	+ default constructor returns blank
	+ parameterized constructor receives parameters
	+ `addTask()` adds a `Task` to the `ToDoList`
	+ `removeTask()` removes a `Task` from the `ToDoList`
- Added test case to Task that tests the constructor
  
### Removed
- Removed List as a parameter from the parameterized constructor
	+ The ToDoList will be populated by the user upon instantiation
***
## 2/16/2023
Had a chance to manually test the list constructor and play with the output.

- Manually created two `Task` objects as `taskOne` and `taskTwo`
	+ gave each object an Id and Description
- Instantiated a new `ToDoList` object as `list`
- Added `taskOne` and `taskTwo` to the list via the `addTask` method of `list`

Now here's where getting what I wanted to see got interesting. And by got interesting I mean I forgot how to display it properly. Let me show you.  
with a standard `System.out.println();` statement and plugging in `list.getTasks()` as the parameter I got this array representation  

`[Task{id=1, description='The first task'}, Task{id=2, description='The next right thing to do.'}]`

So it's showing me the two tasks I created with the data, but in Object array notation. So if we do a bit of method chaining we can modify what outputs to the screen. I appended a .get() with `0` as the index and then it returned a single result: the first task  

`System.out.println(list.getTasks().get(0));`  
`Task{id=1, description='The first task'}`

And if we add one more method, a `.getDescription()` from the `Task` itself, it will work it's way back through the chain and print the result.  

`System.out.println(list.getTasks().get(0).getDescription());`  
`The first task`

To summarize, we are getting the description of the `Task` object, at index 0 on our list of `Task` in this `ToDoList`

***
## 2/12/23
- Wrote Task class
	+ uses only an Id and a Description
	+ ommitted a Due Date and a Status property for now
- Wrote TaskTests
	+ added test for the id getter
	+ added test for the description getter
	+ added test for the description setter
- Wrote ToDoList class
	+ added title property
	+ added List of Task objects propery as blank list
	+ constructor is parameterless for the time being
		* might need to add loaded constructor when handling files
	+ need to implement tests

---


This format is based on [Keep a Changelog](https://keepachangelog.com/en/1.0.0/), and this project adheres to [Semantic Versioning](https://semver.org/spec/v2.0.0.html)

## [Unreleased]

### Added

- Added note for clarity

### Fixed