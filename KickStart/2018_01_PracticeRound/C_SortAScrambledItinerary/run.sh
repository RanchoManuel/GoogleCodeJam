#!/bin/bash

reset
javac -Xlint Main.java
#java Main < in.txt
java Main < C-large-practice.in  > C-large-practice.out
echo "-------Exit code: $?-------"

#g++ -o MainCpp Main.cpp
#./MainCpp < in.txt
#echo "-------Exit code: $?-------"

#gcc -o MainC Main.c
#./MainC < in.txt
#echo "-------Exit code: $?-------"
