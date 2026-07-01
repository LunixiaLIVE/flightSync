# flightSync — Changelog

Stops players getting stuck in elytra flight after a portal teleport.
Client-side only.

Format based on [Keep a Changelog](https://keepachangelog.com/); versioning per [SemVer](https://semver.org/).

## [1.1.2] — 2026-07-01

First multi-loader release for **Minecraft 26.x** (the 26.2.x line).

### Added
- **Fabric + NeoForge** support from a single **universal** jar (per-loader `-fabric` / `-neoforge` jars are also produced).
- Minecraft **26.2** compatibility.
- Fully **dependency-free** — needs only the mod loader.

### Changed
- **No Architectury API required** — flightSync is now fully standalone — it needs only the loader (no Fabric API, no Architectury). Behaviour runs through a client mixin, so no loader API is required.
- Version pinned to the **26.2.x** line; the jar will not load on a different minor version.

### Dependencies
- **Fabric jar:** Minecraft 26.2.x, Fabric Loader >= 0.19.3  *(nothing else)*
- **NeoForge jar:** Minecraft 26.2.x, NeoForge 26.2.0.7-beta  *(no Fabric API, no Architectury)*
