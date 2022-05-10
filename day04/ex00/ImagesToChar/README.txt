# delete target directory
rm -rf target

# create target directory
mkdir target

# compile all java files located in src into target
javac -d ./target src/java/edu/school21/printer/*/*.java

# run Program with 3 arguments (symbol for white color, symbol for black color, path to the image)
java -classpath target edu.school21.printer.app.Program . 0 /Users/abridger/Downloads/it.bmp
