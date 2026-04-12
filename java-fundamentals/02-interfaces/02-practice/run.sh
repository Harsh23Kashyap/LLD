#!/usr/bin/env bash
set -euo pipefail
cd "$(dirname "$0")"
mkdir -p out
javac -d out src/main/java/learning/oop/interfacespractice/*.java
java -cp out learning.oop.interfacespractice.InterfacePracticeApp
