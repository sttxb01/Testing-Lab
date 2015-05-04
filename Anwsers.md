#CSC 121: Computer Science II
##Testing Lab Anwsers
###Thomas X Belusko

**Question 1:** A mistake we can make when using an array is failing to declare the array as an array of integers. A Second mistake we can make when using an array can be forgetting to allocate the amount of integers in memory.  When using an array, we must not use the wrong slots in the array when initializing.

**Question 2:** First, we declare an array of integers for "Scoreboard".  Then, we allocate the amount of memory slots for the array.  We can then call a random number and save it into a variable.  If the variable is within the top n in "Scoreboard", its place will be determined and the current integer in that slot and all integers in the slots below will be moved down a slot (with the final integer in the last being booted off the array).  The variable will then be added to the array in its determined slot.