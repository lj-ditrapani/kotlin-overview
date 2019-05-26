Kotlin Overview
===============

This overview has 04 stages.
Each stage has corresponding `src/main/overviewXX/Lst.kt`
and `src/test/overviewXX/LstTest.kt` files.

1. XX = 01
2. Open `overviewXX/Lst.kt` and `overviewXX/LstTest.kt`,
3. Talk about the code; notes for each stage below.
4. Run the tests `./gradlew test --tests 'overviewXX*'`
5. XX = XX + 1
6. Go to step 2 unless XX > 4


Cost of typed language
----------------------
- Extra wordiness of types
- Optimized for maintainability/readability over write-ability
- 'noise' of types
- Almost like 2 languages; the runtime semantics & the type system


Benefit
-------
- maintainability
- readability (types are documentation)
- performance (not true with TypeScript)
- Don't need tests to check that you implemented the interface correctly
- Don't need tests to check that you are using the interface correctly


Intro
-----
We are going to build a generic list class.
Along the way we will learn about data classes, pattern matching,
and type parameters.
Show box/pointer diagram of list object on white board.
Explain Algebraic Data Types (ADTs).


01 Data structure
-----------------
code
- packages like java
- Basic Lst of Ints class
- Meaning of sealed
- object
- data class
    - free toString & copy & == & hash
    - ADT product type
- Nil & Cons sum types of Lst
    - Inheritance
    - extend with : Base()

tests
- Call class name to create instance (no new)
- can use backticks to name classes & methods
- when branches on type
    - exhaustive check
    - works because of sealed base class


02 Reduce; generic function
---------------------------
Reduce is way too restrictive.  Let's make it more generic.

code
- top level function
- tailrec
    - not as smart as scala
- type parameter B
    - B is the type of zero, and an input and the output parameter of f
- lambda function
- when type match
    - exhaustive

tests
- calling lambda as last parameter, outside of parentheses
- Now we can reduce to a string instead of only an Int
- Reducing to an Int still works the same


03 Generic class
----------------
code
- Lst is parameterized over type A
- reduce uses A instead of Int
- Nil object Lst<Nothing>
- Nothing is the bottom type
- out == covariance.  Allows Nil to subtype of Lst<A> of any A.
    - Covariance: if B is a subtype of A, then `Lst<B>` is a subtype of `Lst<A>`
    - Without the `out`, Lst is type invariant with regard to its type parameter.

tests
- Add type parameter Int (Lst<Int> on line 8)
- Last test now works on Lst<Char>


04 Complete API
---------------
code
- new methods: map, reverse, size, asString
- implemented in terms of reduce
- map is parameterized over type B, so f is function from A => B
- map and reverse qualify call to reduce with type parameter
    - required because Nil is Lst<Nothing>
- newLst factory function to create Lsts
    - generic type parameter A
    - vararg parameters with vararg keyword
    - much nicer list constructor
    - must declare type parameters of fold because Nil is Lst<Nothing>

tests
- new tests for new methods
- use new newLst factory function


Building and running an application on the JVM
----------------------------------------------

- Look at overview04/Main.kt
- Splat Array with `*`
- run `./gradlew assembleDist`;
  creates zip and tar application files under build/distributions/
- run `./gradlew installDist`;
  unzips files into build/install/kotlin-overview.
  Run as `./build/install/kotlin-overview/bin/kotlin-overview`.


Resources
---------

Type hierarchy:
<http://natpryce.com/articles/000818.html>

Tutorial (from shallow to more in depth):
- <https://learnxinyminutes.com/docs/kotlin/>
- <https://kotlinlang.org/docs/reference/>

You can decompile your .class files that kotlinc emits with javap (partial)
or CFR (complete) or some other java decompiler.

- CFR - a nice java decompiler <http://www.benf.org/other/cfr/> 

<https://exercism.io> has a kotlin track.


Part 2
======

[Kotlin Overview Part 2](https://github.com/lj-ditrapani/kotlin-overview)


Develop this overview
=====================

Run tests

    ./gradlew test

Run tests and static analysis

    ./gradlew check

Format code

    ./gradlew ktlintFormat

Run static analysis

    ./gradlew detekt

Create zip and tar application files under build/distributions/

    ./gradlew assembleDist

Unzips dist files into build/install/kotlin-overview.

    ./gradlew installDist

Run main

    ./build/install/kotlin-overview/bin/kotlin-overview
