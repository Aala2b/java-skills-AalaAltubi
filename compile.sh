#!/bin/bash

# Compiles all Java files in src and puts class files in out/
mkdir -p out
javac -d out src/*.java

echo "Compilation complete. Class files are in the 'out' directory."
