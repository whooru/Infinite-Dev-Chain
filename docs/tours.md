# Tours

A **Tour** is a chain of tiny PRs forming a micro-story.

- Completed tours are moved to `archive/tours/` (read-only).
- `archive/deprecated/` contains abandoned or rejected lines that are **not** part of the canon.

---

## Instructions

- Each language/project has its own section (`## Kotlin`, `## Python`, etc.).
- Inside each section:
  - **Current State**: snapshot of what the project looks like right now.  
  - **Change Log**: step-by-step PR log (newest on top or bottom — team decides).  
- When the tour is finished → move the section into `archive/tours/`.

---

## Next Step (Tour 1)

Focus: **abstractions phase**  
- Align project skeletons around clean architecture layers  
- Define minimal interfaces in domain layer for all languages  
- Set up unit testing infra per language  

---

## Kotlin

### Current State
- Skeleton project created with layers:
  - `application`, `domain`, `infrastructure`, `presentation`
- Minimal domain interface & test
- Gradle setup for running tests

### Change Log
- PR #1: Initial Kotlin project skeleton
- PR #2: Added domain interface with test
- PR #3: Configured Gradle for tests


---

## Python

### Current State
_(empty — not started yet)_

### Change Log
- none


---

## Node.js

### Current State
_(empty — not started yet)_

### Change Log
- none
