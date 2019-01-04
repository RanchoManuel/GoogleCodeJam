#!/bin/bash

reset
javac Main.java
java Main < in.txt
java Main < A-small-practice.in  > A-small-practice.out
echo "-------Exit code: $?-------"

#g++ -o MainCpp Main.cpp
#./MainCpp < in.txt
#echo "-------Exit code: $?-------"

#gcc -o MainC Main.c
#./MainC < in.txt
#echo "-------Exit code: $?-------"
