####Why did you choose the framework you used?
I chose use Espresso as this is the framework the company is using to automate Android tests plus I'm very hyped about the technology and saw this as a good opportunity to get some hands on experience with it.

####What were the advantages and disadvantages of your choice?
Espresso, being a white-box test framework, comes with many convenient features by design like Thread Safety, 
the possibility to launch tests directly in a chosen Activity other than MainActivity 
(and skip repetitive flows like Login that only piles up in execution time) or directly use layout resources
to write View locators. Espresso Recorder is also a handy tool to get started writing tests at first
time, but I consider this a two edge sword (more on this later). Coming from an Appium background
where tests usually lives in an isolated codebase, having the opportunity to just have tests sitting on 
the same codebase is just a bliss, as the feedback loop between changes in the app itself is much
quicker to validate on the test level. Plus, the test execution is FAST, really really fast!

As for the downsides, well, I think Espresso is a verbose framework in many different levels. After 
I recorded the first couple of interactions I end up with almost 100 lines of code that translated on just
simple taps in the UI, it took me a while to synthesize that code into refactor into more readable
and modular functions. Moreover, it's almost impossible to understand realtime execution as logs are
completely swamped in - most of the cases - irrelevant information. 
One thing I really missed on Espresso api is the granular control over the target device for execution,
maybe there's such functionality or an external library that aims to bridge this gap but I couldn't find it at this point.
There isn't much documentation on Espresso, nor a big active community around it. :(

Not really a concern in this point but more as a side note, Espresso seems to be too coupled with jUnit, 
that in my opinion not the best or most scalable test framework available for the JVM.

####What was the most complicated part?
Because tests are really fast, I had some issues with synchronization between steps, and it was not really 
clear or easy to figure out IdlePolicies was crucial for stable executions. Also, I didn't manage
to assert presence Toast messages on the MainActivity. 

####Which good coding practices did you follow when writing your tests?
I implemented Page Object Model pattern where I mapped UI elements for each View on its own class as
functions returning instances of Robot classes and encapsulated page functions as self returning types 
that allows fluid chaining to compose complex flows.
The Robot class mentioned above is a slightly customized version of the Robot pattern, where direct interactions
with an element/view are self-returning functions that allows fluid chaining to compose complex interactions.

####How do you make sure your code is maintainable by other team members?
Functions and with clear and meaningful names, encapsulating repetitive flows into functions that can be reused across the project, 
separations of concerns of Page Actions and Element actions.