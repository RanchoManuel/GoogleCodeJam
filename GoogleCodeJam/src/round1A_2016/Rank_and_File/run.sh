#clear
javac Main.java
java Main < B-large.in > large.txt
rm *.class
echo "-------\nRta: $?\n-------"
