# flightSync — Changelog

Stops players getting stuck in elytra flight after a portal teleport.
Client-side only.

Format based on [Keep a Changelog](https://keepachangelog.com/); versioning per [SemVer](https://semver.org/).

## [1.1.2] — 2026-07-01

Multi-loader release spanning the **Minecraft 1.21** line (built on 1.21.1, runs across 1.21.x).

### Added
- **Fabric + NeoForge** support from a single **universal** jar (per-loader `-fabric` / `-neoforge` jars are also produced).

### Changed
- **No Architectury API required** — flightSync is now fully standalone. Behaviour runs through a client mixin, so no loader API is required.

### Dependencies
- **Fabric jar:** Minecraft 1.21.x, Fabric Loader >= 0.19.3  *(nothing else — loader only)*
- **NeoForge jar:** Minecraft 1.21.x, NeoForge 21.1.234  *(no Fabric API, no Architectury)*
