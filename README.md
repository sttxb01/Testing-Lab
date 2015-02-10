# CSCI 121: Computer Science II
## Testing Lab

### Overview

Testing is good


### Plan Before You Code

Testing helps you think more deeply about what the specification of the class means.  If we do this before we start coding, we can avoid errors.  Consider the following description for a `Scoreboard` class that holds the top 10 scores and corresponding names:

- `Scoreboard()` creates an emtpy scoreboard.
- `isHighScore(score : int) : boolean}` returns true of the score is a highscore, and false otherwise.
- `addScore(name : String, score : int) : void` adds the score and name to the appropriate position in the high score list.  If the score is not a high score, the list is not changed.
- `getName(position : int) : String` returns the name in the specified position.
- `getScore(position : int) : int` returns the score in the specified position.
- `getNumScores() : int` returns the number of high scores, a value between 0 and 10 (inclusive).

From this description, you should see that we will need to have a linear collection of names and scores (an array, maybe?).  As a result, we should think about typical mistakes we might make when manipulating an array.

>**Question 1:** List three mistakes we can make when using an array.

### Temporal Thinking

The methods of a class must be prepared to repond whenever they are called.  The value returned by `getScore()` depends on when it is called.  Similarly, `getAverage` depends on how many values are in the data set (sum / quantity doesn't work when there are zero values!).

Therefore, we should always think about how the methods should work with:

- A new instance of the class.
- An instance with a single mutation.
- An instance with multiple mutations.

Each of these possibilities translates to one test case, and epending on the class interface, there may be multiple ways to instantiate and mutate the object.

>**Question 2:** List at least one configuration of a `Scoreboard` for each of the above scenarios.


### The Mantra of Testing

All (good) unit test have the same form:

1. Create an object in a known state.
2. Exercise the object (do something with the object).
3. Verify (test) the current state of the object.

For example, with the Scoreboard, we write a test to verify that tie scores are handled properly (the new score goes after the old score):

1. Create a scoreboard with three entries - the first with 100 points, the second with 50, and the third with 10.
2. Call `addScore` with a score of 50.
3. Verify that the new score is in third place, the first two scores are unchanged, and the old third place score is now fourth.

### Test-Driven Development (TDD) -- Step 1

In Monte Carlo simulations, we always need to take the average of a set of values.  Here is the interface for an `Average` class:

- `Average()` creates a new object representing an average with no data.
- `addValue(double): void` includes the specified value in the dataset.
- `getAverage(): double` returns the current average (0 of no data).
- `getCount(): int` returns the number of values in the data set.

**Activity**: make a *skeleton* for the `Average` class.  The skeleton should contain no data members, have an empty constructor, and have methods with a minimal body.  For a void method, this means the body is empty.  For a value-returning method, made the method return 0.  Don't forget that we always want to save our code in the `src` folder.

In TDD, we write tests as we are developing our code (purists say we should write our tests **first**).  At the core of this philosophy is the idea that we can build our class incrementally, from easy cases to difficult ones.  For the `Average` class, the simplest case is a new instance with no data.

**Activity**: 

- In DrJava, select "New JUnit Test Case..." from the *File* menu.  When prompted for a name for the test class, call it `AverageTest`.
- Change the method `testX()` to the following:

```
  public void testNewAverage() 
  {
    Average avg = new Average();
    
    assertEquals(0, avg.getCount());
    assertEquals(0, avg.getAverage(), 0.001);
  }
```

- `assertEquals` is a method used to verify the stat of the object.  The first parameter is always the expected value.  The second value is the value from the object.  When the values being compared are float-point values, the third value is a tolerance -- how far the values can be apart before we call them different (this deals with float-point round-off errors).
- Compile your code, and then press command-T to run the test.  Notice the green bar at the bottom right and the test name shown in green to the left.  This means your test passed.  If they are read, your test did not pass, and you should correct your code before you continue.

### TDD -- Step 2

It may seem like we have not accomplished anything significant -- after all, our code was written in a ways that makes this test pass even without the class representing an actual average.  But we are going to keep the `testNewAverage` test in our code *forever*.  When we make changes to our code, this test will fail if we break the class when there is no data.  In other words, our tests are watching to make sure we don't make any mistakes!

We have also solved the "blank page" problem.  Writing the skeleton of the class and a simple test has given us code to work with.  We no longer have to fret about where to start.

We will continue by making a small change to the code and write a test to make sure that small change works.  Here is the test for a single value:

```
  public void testSingleValue()
  {
    Average avg = new Average();
    
    avg.addValue(5.5);
    
    assertEquals(5.5, avg.getAverage(), 0.001);
    assertEquals(1, avg.getCount());
  }
```

If you run your tests now (command-T), you will notice that the first test still passes, but the new test fails.

**Activity:** Change the code in the `Average` class so that both tests pass.  A good way to do this is the make class variables named `sum` (double) and `count` (int), both initialized to zero.  The variable `sum` should hold the running total of all the values added, and count should simply be the number of values added.

### TDD -- Step 3

Our code for the `Average` class *probably* works at this point, but we should write a few more tests to make sure.  

**Activity:** Add the following tests to collection of test:


- A data set with 5 or more different values where the average is something other than 0.
- A data set with 5 or more values where the average is 0.
- A data set with 5 or more values that are the same.

When all these tests pass, we can be confident that the `Average` class works properly.

### Testing Questions


In addition to the ideas presented above, here are some questions to consider when testing:

- What would a brand new instance of the class look like?
- What is the simplest mutation possible for the class?
- What else can we do to an instance of the class?
- What are the boundary conditions for the class?

### A Range Class

In mathematics we denote a range using open-closed bracket notation: [0,10) means all real numbers greater than or equal to zero but less than ten. So 0 and 7.3 lie in this range, while -2.3, 10, and 11.5 do not.  Here is an interface for a `Range` class:

- `Range(double start, double stop)` creates a range with the specified values.  It is legal for start < stop or stop < start, and both represent the same range, [min(start, stop), max(start, stop)).  If start == stop, then we have the empty range, which we will treat at the range [0, 0). 
- 'contains(double value): boolean` returns true if the value is in the range and false otherwise.
- `getWidth(): double' returns the width of the range, which is defined as |start - stop|.
- `getMin(): double' returns the smaller value of the two values defining the range.
- `getMax(): double' returns the larger value of the two values defining the range.
- 'Range intersection(Range other): Range' returns the intersection of the two ranges -- that is, a new range where the caller and the parameter overlap.  This resulting range may be empty.

>**Question 3:** Answer the "Testing Questions" descripted in the previous section.

**Activity:** Using TDD, imlement and test the `Range` class.

### Average Range Intersection Length (Optional)

The method `Math.random()` returns a random number between 0 and 1.  If we create two `Range` objects using these random numbers, what is the probability they overlap?  If they do overlap, what is the average length of the overlap?

Now that we have the `Average` and `Range` classes, these questions can be answered using a Monte Carlo simulation written in a `main` method.

Abstraction and testing are awesome!
