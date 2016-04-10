clear
javac Main.java
java Main < primos.txt > out_large2.txt
rm *.class
echo "-------\nRta: $?\n-------"
