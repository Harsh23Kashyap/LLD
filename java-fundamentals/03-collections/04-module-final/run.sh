#!/usr/bin/env bash
set -euo pipefail
cd "$(dirname "$0")"
mkdir -p out
javac -d out src/main/java/learning/collections/module3final/*.java
java -cp out learning.collections.module3final.CollectionsFinalApp
