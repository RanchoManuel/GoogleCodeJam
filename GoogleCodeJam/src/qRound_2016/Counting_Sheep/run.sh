clear
javac Main.java
java Main < A-large.in > out.txt
rm *.class
echo "-------\nRta: $?\n-------"

#g++ -o MainCpp Main.cpp
#./MainCpp < in.txt
#echo "-------\nRta: $?\n-------"

#gcc -o MainC Main.c
#./MainC < in.txt
#echo "-------\nRta: $?\n-------"
