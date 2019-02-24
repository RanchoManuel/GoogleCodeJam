#!/bin/bash

reset
javac Main.java
java Main < 'in.txt'
echo "-------Exit code: $?-------"

#g++ -o MainCpp Main.cpp
#./MainCpp < in.txt
#echo "-------Exit code: $?-------"

#gcc -o MainC Main.c
#./MainC < in.txt
#echo "-------Exit code: $?-------"
