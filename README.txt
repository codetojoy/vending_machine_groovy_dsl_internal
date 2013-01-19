
*** Introduction

This is a work-in-progress example for the Vending Machine, as highlighted by the Lambda Lounge.

http://lambdalounge.org/meeting-archive/

This example uses Groovy to implement an internal DSL. It is a much Groovier
departure from the first project which was a Java-esque style.

The main approach is that the input files are truly calling Groovy code.

e.g. The following:

<TODO>example here</TODO>

*** Requirements

-- assumes Java 5+ is available
-- assumes Groovy and Gant are available

http://groovy.codehaus.org/

http://gant.codehaus.org/

*** Deviations from spec

-- the only input is a file, though this file allows assertions
-- there is no output per se

*** Themes

-- the input lines call Groovy methods/closures
-- the input can contain assertions of state. extremely useful
-- in theory, a set of input files could be used against other implementations to see if the examples match
-- MoneyState is immutable, and intended to allow the developer to visualize "slots" 
   e.g. new MoneyState(1,2,3,4) is 1 dollar, 2 quarters, 3 dimes, and 4 nickels

*** lessons learned

-- testing is essential here
-- you really have to trust the tests (see above). they become intrinsic to the experience
-- <TODO>more on the DSL experience</TODO>

test check-in Jan 2013
