#!/usr/bin/env bash
set -euo pipefail
cd "$(dirname "$0")"
mkdir -p out
javac -d out src/main/java/learning/oop/constructors/*.java
java -cp out learning.oop.constructors.ConstructorsApp
