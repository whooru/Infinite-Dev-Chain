# 📜 Rules

**Infinite Dev Chain** is a collaborative experiment.\
Each pull request is a *move* in an endless chain where developers add
small, incremental contributions.\
The project can evolve into **anything** --- a tool, a library, a quirky
service --- not necessarily a game.

------------------------------------------------------------------------

## Core principles

-   **One move = one PR.** Keep changes small and self-contained.
-   **Build on top.** You may extend existing code, improve
    abstractions, or start something new.
-   **Quality first.** Follow clean architecture principles (SOLID, DRY,
    separation of concerns).
-   **Start abstract.** Early contributions should favor **interfaces
    and abstractions** over heavy implementations --- this creates a
    flexible foundation.
-   **Documentation matters.** If your code changes behavior or
    introduces concepts, update relevant docs or add a short README in
    the folder.
-   **CI is the referee.** Pull requests must pass automated checks
    (linting, tests, coverage, docs).

------------------------------------------------------------------------

## Contribution flow

1.  Fork → branch → PR.
2.  Each PR is reviewed as a "turn".
3.  CI must be green to merge.
4.  Scoring service may award points based on contribution type (tests,
    docs, coverage).

------------------------------------------------------------------------

## What is allowed

✅ Adding new functions, interfaces, or abstractions.\
✅ Extending existing modules with careful design.\
✅ Writing tests, docs, or tooling.\
✅ Refactoring with a clear rationale.

------------------------------------------------------------------------

## What is not allowed

❌ Large monolithic changes (\>400 LOC net).\
❌ Breaking existing code without tests/docs.\
❌ Adding irrelevant or auto-generated code.\
❌ Force-pushing to `main` (protected branch).

------------------------------------------------------------------------

## Spirit of the project

-   This is **not limited to creating a game**.\
-   The outcome may become a **weird service, a playful library, or
    something unpredictable**.\
-   The fun is in the **chain reaction** of contributions, not in
    planning the final result.
