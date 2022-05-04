# DataStructures
A custom implementation of popular java Data Structures and more.

# Running JUnit tests from the command line
In order to run a standard JUnit test in Windows cmd, please follow the
instructions below:
```console
rootFolder>dir /s /b *.java > sources.txt
rootFolder>javac -cp .;junit-4.11.jar -d ./bin @sources.txt
rootFolder>cd bin
java -cp .;../junit-4.11.jar MyArrayListTest
```

# ArrayList Implementation
The MyArrayList class is a resizable array, which is located in the java.util
package. This implementation displays some of the most popular methods and
implements a custom List interface. 
