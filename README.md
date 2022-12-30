# ShapesSorting
This application is able to sort various sizes of arrays containing Shape Objects.
There are 6 sorts to choose from:
* Insert = i
* Selection = s
* Bubble = b
* Merge = m
* Quick = q 
* Heap = z

Lists can be sorted by 1 of three variables:
* Height = h
* Volume = v
* Base Area = a


How To:
Run JAR file with three arguments
1. "-f" then the file name where the array is located
	
2. "-s" followed by the character representing the Sort you desire
	
3. "-t" followed by the character representing the Sort Parameter you desire

<hr>

Valid  Inputs:
```
java -jar sort.jar -fpolyfor1.txt -Tv -Sb
java -jar sort.jar -ta -sQ -f"res\polyfor3".txt
java -jar sort.jar -tH -F"C:\temp\polyfor5.txt" –sB
```
Date: June 2022

