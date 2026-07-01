# flightSync

Stops players getting stuck in elytra flight after a portal teleport.
**Client-side only.**

## Features

- Cancels lingering elytra flight after portal teleport
- Client-side, single mixin
- Zero dependencies — needs only the loader

## Versions & downloads

This repository uses a **branch-per-version** layout: this `main` branch is documentation only — the code for each Minecraft version lives on its own branch, each with its own history and `CHANGELOG.md`.

| Branch | Minecraft | Loaders | Dependencies | Notes |
|--------|-----------|---------|--------------|-------|
| [`multi_26.2`](https://github.com/LunixiaLIVE/flightSync/tree/multi_26.2) | 26.2.x | Fabric · NeoForge | None — loader only | [changelog](https://github.com/LunixiaLIVE/flightSync/blob/multi_26.2/CHANGELOG.md) |
| [`multi_26.1`](https://github.com/LunixiaLIVE/flightSync/tree/multi_26.1) | 26.1, 26.1.1, 26.1.2 | Fabric · NeoForge | None — loader only | [changelog](https://github.com/LunixiaLIVE/flightSync/blob/multi_26.1/CHANGELOG.md) |

The `multi_*` branches each build a single **universal** jar that runs on **both** Fabric and NeoForge (per-loader `-fabric` / `-neoforge` jars are also produced). The 26.x builds are fully standalone — **no Architectury API at runtime**.

## License

MIT
