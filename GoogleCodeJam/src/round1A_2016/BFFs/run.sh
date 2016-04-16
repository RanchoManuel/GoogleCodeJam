clear
javac Main.java
java Main < test.in #> out.txt
rm *.class
echo "-------\nRta: $?\n-------"
