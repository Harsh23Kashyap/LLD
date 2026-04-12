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

---

## Java fundamentals (`java-fundamentals/`)

Study order follows folder numbering (OOP first, then interfaces, collections, and supporting topics).

### Progress

**`01-oop-basics` (OOP)**

| Lesson | Topic | Done |
|--------|-------|:----:|
| `01-classes-and-objects` | Classes & objects | ✓ |
| `02-constructors` | Constructors | ✓ |
| `03-encapsulation` | Encapsulation | ✓ |
| `04-inheritance` | Inheritance | ✓ |
| `05-polymorphism` | Polymorphism | ✓ |
| `06-abstraction` | Abstraction (`abstract`, `interface`) | ✓ |
| `07-try-it-yourself` | Session 1 mini exercise (see folder `README.md`) | ✓ |

**Other `java-fundamentals` modules**

| Module | Topics | Done |
|--------|--------|:----:|
| `02-interfaces` | `implements`, multiple interfaces | ✓ |
| `02-interfaces/02-practice` | Interfaces mini exercise (`02-practice/README.md`) | ✓ |
| `03-collections` | List / `ArrayList`, Map / `HashMap`, Set / `HashSet` | |
| `03-collections/01-list-and-arraylist` | List / `ArrayList` | ✓ |
| `03-collections/02-map-and-hashmap` | Map / `HashMap` | ✓ |
| `04-enums` | Fixed states / types | |
| `05-access-control` | `private`, `public`, `protected` | |
| `06-design-thinking` | Composition vs inheritance (HAS-A vs IS-A) | |
| `07-error-handling` | `try` / `catch` basics | |
| `08-code-structure` | Packages | |

**`lld-course/`** — lesson exercises not started yet (directory layout only; no ✓ here until you add code per topic).

---

## How to use

1. Pick a **`java-fundamentals`** topic until you are comfortable implementing small classes and using `List` / `Map`.
2. Work through **`lld-course`** in module order; implement examples in the matching leaf folder.
3. Keep one small runnable snippet or mini-project per folder, or introduce a shared build tool later if you outgrow single files.

Course videos (if you keep them elsewhere) are not stored in this repo; folder names align with typical lesson titles.
