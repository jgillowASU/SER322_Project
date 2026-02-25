## Compile

With a working directory at the same level as this README.md file, run the following to get started with the app.

**Windows** (use `;` in classpath):

> javac -cp "lib/*;src" -d bin src/Main.java

> java -cp "bin;lib/*" Main jdbc:mysql://localhost:3306/\<databaseURL\> \<username\> \<password\>

**Mac/Linux** (use `:` in classpath):

> javac -cp "lib/*:src" -d bin src/Main.java

> java -cp "bin:lib/*" Main jdbc:mysql://localhost:3306/\<databaseURL\> \<username\> \<password\>

Make sure to change the last three arguments to match your local system's database. 

## Folder Structure

- lib: contains the database driver. I used the same as was provided by ASU as in Assignment 5. 
- src: the actual java code and bountyboard package. 
- ~bin: per my compile files above, this is where the compiled code will live after you compile. I leave it out in the .gitignore so you have to compile for each machine and it doesn't clog up our repo. 

## Group Member Contributions

* Jacob Gillow:
    * Reviewed the intial draft of Deliverable 1 (D1) and discussed with the group what was needed and what to trim. 
    * Started the group Github that was used throughout the project. 
    * Reviewed initial draft of the ER diagram and ensured that the cardinality of Planet - Target was proper and pushed a version 2 with proper updates. 
    * Updated the D1 doc in order to match instructor feedback for our Deliverable 2 (D2) submission. Personally added the "Use Cases" section. 
    * Created the "create" portion of Deliverable 3 (D3) to initially structure the database.
    * Reorganized the initial design in such a way to make it easier to compile in java and wrapped it up into a simpler package. 
    * Fleshed out the InputValidator.java class to handle user inputs. 
    * Populated the SQL queries and the basic outline for the following functions for the Java code: 
        * printSyndicates()
        * welcomeSyndicate()
        * printTargets()
        * printHunters()
        * welcomeHunter()
        * printBountyBoard()
        * printUnassignedBounties()
        * printUnfinishedBounties()
        * printBountiesAssignedToHunter()

* Christopher Paquin
    * Created a starter proposal draft which was further refined by the whole team.
    * Created a ER diagram that was discussed and refined by everyone together.
    * Created the select and insert SQL scripts.
    * Helped refine deliverable 4 project structure did some project structural code.