# FileArray

1.Design and implement a class FileArray that mantains a binary file-backed array of int values, with constructors/methods to:
-build a new array with n random values ∼U({0,…,2^10})
-use an existing array
-print the array
-increment all elements of the arrays

2.Write an application that "uses" FileArray
-receives m≥1 parameters at command line
-1st is a file pathname, if not existing, create with n∼U({1,…,2^5}), otherwise, load
-from 2nd on, a list of one-char commands:
i for increment
p for print
