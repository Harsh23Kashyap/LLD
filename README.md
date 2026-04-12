# LLD Practice

Practice workspace for **low-level design (LLD)** and **Java fundamentals**. Each topic lives in its own folder so you can open a lesson and add code next to your notes.

## Layout

| Path | Purpose |
|------|---------|
| [`lld-course/`](lld-course/) | LLD curriculum: SOLID, UML, design patterns, concurrency, advanced topics |
| [`java-fundamentals/`](java-fundamentals/) | Java basics for LLD: OOP, collections, interfaces, enums, errors, packages |

Empty lesson folders use `.gitkeep` until you add source files.

---

## LLD course (`lld-course/`)

Numbered modules; each **leaf** folder is one lesson.

| Module | Topics |
|--------|--------|
| `01-introduction` | Introduction to LLD, software design principles |
| `02-solid-principles` | SRP, OCP, LSP, ISP, DIP |
| `03-uml` | UML, class diagrams |
| `04-creational-patterns` | Intro, singleton, factory method, builder, abstract factory, prototype |
| `05-structural-patterns` | Adapter, overview, facade, proxy, bridge, flyweight |
| `06-behavioural-patterns` | Iterator through memento (full set in repo) |
| `07-concurrency` | Threads, pools, safety, deadlocks, locks, producer–consumer (+ supplement folder for extra PC material) |
| `10-advanced-topics` | Exceptions / error handling, database design |

Practice code for these lessons is not in the repo yet (folders are a scaffold aligned with typical course titles).

---

## Java fundamentals (`java-fundamentals/`)

Work through the sections below in order unless you are jumping back to review. In each table, **Folder** is relative to that section’s path (for example, under **OOP basics**, `01-classes-and-objects` is `java-fundamentals/01-oop-basics/01-classes-and-objects/`). Lesson code and `run.sh` sit inside that leaf folder when present.

### OOP basics (`01-oop-basics/`)

| Folder | Topic | Done |
|--------|-------|:----:|
| `01-classes-and-objects` | Classes & objects | ✓ |
| `02-constructors` | Constructors | ✓ |
| `03-encapsulation` | Encapsulation | ✓ |
| `04-inheritance` | Inheritance | ✓ |
| `05-polymorphism` | Polymorphism | ✓ |
| `06-abstraction` | Abstraction (`abstract`, `interface`) | ✓ |
| `07-try-it-yourself` | Session 1 capstone (skeletons; tasks in each `.java` header) | ✓ |

### Interfaces (`02-interfaces/`)

| Folder | Topic | Done |
|--------|-------|:----:|
| `01-interface-usage` | `implements`, multiple interfaces on one class | ✓ |
| `02-practice` | Short exercise (skeletons; tasks in each `.java` header) | ✓ |

### Collections (`03-collections/`)

| Folder | Topic | Done |
|--------|-------|:----:|
| `01-list-and-arraylist` | `List`, `ArrayList`, iteration | ✓ |
| `02-map-and-hashmap` | `Map`, `HashMap`, `LinkedHashMap`, `TreeMap` | ✓ |
| `03-set-and-hashset` | `Set`, `HashSet`, `LinkedHashSet`, `TreeSet` | ✓ |
| `04-module-final` | Module capstone (list + map + set; tasks in each `.java` header) | ✓ |

### Enums (`04-enums/`)

| Folder | Topic | Done |
|--------|-------|:----:|
| `01-enums` | Enum type, constants, fields, `values`, `valueOf`, `switch` | ✓ |
| `02-practice` | Short exercise (`ChipColor` / `ChipPracticeApp`; tasks in each `.java` header) | ✓ |

### Access control (`05-access-control/`)

| Folder | Topic | Done |
|--------|-------|:----:|
| `01-access-modifiers` | `private`, package-private, `protected`, `public` | ✓ |

### Design thinking (`06-design-thinking/`)

| Folder | Topic | Done |
|--------|-------|:----:|
| `01-composition-vs-inheritance` | HAS-A (composition) vs IS-A (`extends`) | ✓ |
| `02-practice` | Short exercise (`Laptop` + `DesignPracticeApp`; tasks in each `.java` header) | ✓ |

### Error handling (`07-error-handling/`)

| Folder | Topic | Done |
|--------|-------|:----:|
| `01-exception-basics` | `try` / `catch` / `finally`, runtime exceptions | ✓ |

### Supporting topics (same repo, later order)

| Folder | Topic | Done |
|--------|-------|:----:|
| `08-code-structure` | Packages | |

---

## How to use

1. Pick a **`java-fundamentals`** topic until you are comfortable implementing small classes and using `List` / `Map`.
2. Work through **`lld-course`** in module order; implement examples in the matching leaf folder.
3. Keep one small runnable snippet or mini-project per folder, or introduce a shared build tool later if you outgrow single files.

Course videos (if you keep them elsewhere) are not stored in this repo; folder names align with typical lesson titles.
