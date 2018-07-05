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
```java
try (Res r = initResource()) { doSomething(r); }
```
can be mimicked using something like
```java
using(initResource()).accept(r -> doSomething(r); }
```
assuming some proper definition of 'using'.

## Accumulating lambdas

The try with resources example works for one resource but what if we
need more ? We look for a construct that allows dependent resources to be
handled and used like

```java
using(initR1())
    .nest(r1 -> initR2(r1))
    .accept((r1,r2) -> ...)
```

We use CCN for consumer of consumer of N arguments in the rest of the document.
Combining a CC1 with a CC1 yields a CC2 and by extension we expect the 
combination of a CCN and a CCM to be a CC(N+M).

## Classes

class name | description
---------- | -----------
CN  | consumer of N arguments
TN  | tuple of length N
FN  | function of N arguments
FTN | function of a tuple of size N
CCN | consumer of consumer of N arguments
CTN | consumer of consumer of a tuple of size N

### Method names
###### CCN methods

method | description
------ | -----------
nest   | The nest methods are the basic combination blocks. Nest methods have a number M that define the CCM to combine with. The nest1 method is abberviated to nest.
and    | The and methods combines the CCN with an independent CCM.
then   | The then methods combine the CCN with a CCM and the result looks like the CCM.
ct     | The ct method transforms a CCN into a CTN. A cc method exists on CTN that converts a CTN to a CCN.
ccM    | Transforms the CCN into a CCM using a tranformation function from TN to TM.

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

Some minimal examples are provided in the test sources. The examples shows how to
define and use temporary files and directories with managed life cycles.

Resource managing code looks like:
```java
withTmpDirectory("cctest")
.nest(dir      -> withFile(dir,"first_file"))
.nest((dir,f0) -> withFile(dir,"second_file"))
.accept((dir,f0,f1) -> {
    System.out.println("temp directory : " + dir);
    System.out.println("temp file 0    : " + f0);
    System.out.println("temp file 1    : " + f1);
});
```

Composite actions can be defined once and used in several test:
```java
public static final CC2<Path,Path> twoFiles =
    withTmpDirectory("cctest")
    .nest(dir      -> withFile(dir,"firstfile"))
    .nest((dir,f0) -> withFile(dir,"secondfile"))
    .cc2((dir,f0,f1) -> new T2<>(f0,f1));

public void test() {
    twoFiles.accept((f0,f1) -> {
        doSomethingWithFiles(f0,f1);
    });
}

```

