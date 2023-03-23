# Taskmin Devlog/Changelog
All notable changes to this to this project will be documented in this file.  
## 3/22/2023
### Notes
The compile was finally successful. Several plugins had to be installed to make the compile work. As well as setting a path variable to apache maven 3.9.1, and jdk-17. Apparently I still had my desktop set to adoptium 11.

## 3/20/2023
### Added
- Version 1.0 to tagline. I've manually tested the app as much as I can think to. I'm satisfied.
  
### Removed
- A lot of commented out test code.
### Notes
Rewrite tests for the classes. Compile the app and add it to the repo. ITF: Look into adding color and editing tasks with the setters.

## 3/4/2023
### Added
- Filled out `helpMe()` section
	+ now accessible from main menu
- Added `displayTagline()` method to separate out the banner
	+ banner now redisplays in menus, tagline does not
- Added `saveFile()` method. Saves as .txt format
- Added `openFile()` method. Loads as .txt format
### Notes
The ** found in the .txt files is the Regex to denote to the program the title. There's probably a better way to do this, but I will explore that later. Decided on FileReader and PrintWriter, as performance isn't an issue, and in the end I do want to format the text. Ran into issue with FileReader populating a list when loading. It read the first line twice. After debugging I was able to get it to skip the first line  
```
// load the file and populate the list
        try (Scanner loadFile = new Scanner(listFile)) {
            while (loadFile.hasNextLine()) {
                Task currentLine = new Task(loadFile.nextLine());
                if (currentLine.toString().startsWith("**")) {}
                else {
                    tasks.add(currentLine);
                }
            }
        } catch (FileNotFoundException f) {
            System.err.println("File not found...");
        }
```
After changing the code around to simply discard the first line after it's read and then continue parsing the file to a List. Then I added another open and close before it to set the title
```
// load the file and set the title, close it
        try (Scanner loadFile = new Scanner(listFile)) {
            String currentLine = loadFile.nextLine();
            if (currentLine.startsWith("**")) {
                title = currentLine.substring(3);
                loadFile.close();
            }
        } catch (FileNotFoundException f) {
            System.err.println("File not found...");
        }

        // load the file and populate the list
        try (Scanner loadFile = new Scanner(listFile)) {
            // read and discard the first line
            if (loadFile.hasNextLine()) {
                loadFile.nextLine();
            }
            while (loadFile.hasNextLine()) {
                Task currentLine = new Task(loadFile.nextLine());
                tasks.add(currentLine);
                }
        } catch (FileNotFoundException f) {
            System.err.println("File not found...");
        }
```

*** 
## 3/2/2023
### Added
- Added escape clause for Adding a task
	+ if a user leaves the description prompt blank, no new task will be added to the list
- Added change title function, and escape clause
	+ if a user leaves the new title prompt blank, the title will not change
- Added `helpMe()` option for main `App` class
	+ called from `CommandLine` object, full output to be written
***
## 3/1/2023
### Added
- flagging for if the Task list is empty and a user attempts to remove a task
- flagging for if the user enters character output when prompted for a number
- flagging for if the user accidently selects remove task, and an escape route
- fixed IndexOutOfBounds issue
  
### Notes
try/catch block in `CommandLine`  was not catching the  IndexOutOfBoundsException (IOOB), there was nothing to index. Instead changed it to a NumberFormatException to catch any character input. Added the IOOB to the Remove Task block. This caught the index issue, but presented an infinite loop issue if the user accidently chose to Remove a Task. Added a flag for successful task removal, and a clause for going back to the List Menu when the user enters `0` as a task to remove. Wrote code to skip the process if the list is empty.
  
***
## 2/27/2023
### Added
- Add a task option successfully added
	+ numbers tasks on list as well
- Remove a task added, however
	+ throws an `IndexOutOfBoundsException`
### Removed
- old `addTask()` method, not needed, see Notes section
- old `removeTask()` method, not needed, see Notes section
- deleted some old concept code that was commented out
### Notes  
The adding and removing of tasks is handled inside of a switch-case statement, which is inside a while loop running on (true). To exit this function the user must input the option correlating with it (5). This will return out of the loop and send the user back to the main loop in the `App` class  
***
## 2/26/2023
### Added
- Application run sequence reactivated
  
### Removed
- id field from Task, for this app Id numbers will not be needed
- Testing field in main app for id generator sequence
### Notes
Tried writing a sequence to generate ids, got a rough one working, ultimately decided id's were not necessary at this time. It's a simple tasklist application, and I can number each one on the list with a For loop. The task and ToDoList tests are broken now, I'll rewrite them later. I'm focusing on making the application work how I need it to.
  
---
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
  
---
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
   
---
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