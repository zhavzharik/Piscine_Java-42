# delete target directory
rm -rf target

# create target directory
mkdir target

# copy resources
cp -R src/resources ./target

# compile all java files located in src into target
javac -d ./target src/java/edu/school21/printer/*/*.java

# create jar archive
jar cfm ./target/images-to-chars-printer.jar src/manifest.txt -C target .

# run jar archive with 2 arguments (symbol for white color, symbol for black color)
java -jar target/images-to-chars-printer.jar . 0
