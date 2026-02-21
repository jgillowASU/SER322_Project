## Compile

With a working directory at the same level as this README.md file, run the following to get started witht he app: 

> javac -cp "lib/*;src" -d bin src/Main.java

> java -cp "bin;lib/*" Main jdbc:mysql://localhost:3306/<databaseURL> <username> <password>

Make sure to change the last three arguments to match your local system's database. 

## Folder Structure

- lib: contains the database driver. I used the same as was provided by ASU as in Assignment 5. 
- src: the actual java code and bountyboard package. 
- ~bin: per my compile files above, this is where the compiled code will live after you compile. I leave it out in the .gitignore so you have to compile for each machine and it doesn't clog up our repo. 