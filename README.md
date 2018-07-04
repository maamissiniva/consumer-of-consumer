# Consumer of consumer
## What is it ?
The base idea is that when an object can execute a runnable it defines 
an execute method that takes a runnable object. Extending the concept a bit
using consumer instead of runnable and using the consumer method instead of
a custom execute method provides a more regular structure that is a consumer
of consumer. Part of the implementation is just some fun converting things
in some functional way (this shows the equivalence between consumers of 
consumers and consumers of consumer of tuples, and the equivalence between
function of n arguments and a function of a tuple of size n).
## Try with resources
Accepting a consumer or runnable allows the definition of code that mimics the
java try with resources construct
```try (Res r = initResource()) { doSomething(r); }```
can be mimicked using something like
```using(initResource()).accept(r -> doSomething(r); }```
assuming some proper definition of 'using'.
## Accumulating lambdas
The try with resources example works for one resource but what if we
need more ? We look for a construct that allows dependent resources to be
handled and used like
```using(initR1()).nest(r1 -> initR2(r1)).accept((r1,r2) -> ...)```
We use CCN for consumer of consumer of N arguments in the rest of the document.
Combining a CC1 with a CC1 yields a CC2 and by extension we expect the 
combination of a CCN and a CCM to be a CC(N+M).
## Projections
The number of arguments can be reduced (e.g: CC3 to CC2). The ignored arguments
are still managed despite no being shown in the signature. This is useful
when, for example, building a temporary directory and files in it but
only using the files. 
## Current state
The current implementation is a proof of concept that should be working but
many methods are missing (nest and others).
Some conversions between function types (function of n arguments and function 
of a tuple of size n) are provided.
## Examples
Some minimal examples are provided in the test sources. The example shows how to
define and use temporary files and directories with managed life cycles.
