# Input-Output Tasks
by Noppawan Kulchol 5910545728

I ran the tasks on a ASUS K401U with 2.8GHz i5-6200U,
and got these results:

|Task							| Time		|
|:------------------------------------------------------|--------------:|
|Read file 1-char at a time to String			|0.849859 sec.	|
|Read file 1-char a a time to StringBuilder		|0.022835 sec.	|
|Read file line at a time using BufferedReader		|0.030147 sec.	|

## Explanation of Results
Reading file using String is slower than others because when it append char to a String then String will be created for collect data and also old data into String.
