<div align="center">

# 🪶 flightSync

### Stops players getting stuck in elytra flight after a portal teleport.

![](https://img.shields.io/badge/Fabric-DBA463?style=for-the-badge&logoColor=white)&nbsp;![](https://img.shields.io/badge/NeoForge-F16436?style=for-the-badge&logoColor=white)&nbsp;

[![](https://img.shields.io/badge/Download_on-Modrinth-00AF5C?style=for-the-badge&logo=modrinth&logoColor=white)](https://modrinth.com/project/flightsync)&nbsp;[![](https://img.shields.io/badge/Download_on-CurseForge-F16436?style=for-the-badge&logo=curseforge&logoColor=white)](https://www.curseforge.com/minecraft/mc-mods/flightsync)

![](https://img.shields.io/badge/Minecraft-26.x_%7C_1.21.x-62B47A?style=flat-square) ![](https://img.shields.io/badge/Side-Client--side-3498DB?style=flat-square) ![](https://img.shields.io/badge/Dependencies-loader_only-2ECC71?style=flat-square) ![](https://img.shields.io/badge/License-MIT-blue?style=flat-square)

</div>

---

## 🪶 What it does

You take off with an elytra, glide through a nether portal (or step into the End), and on the other
side you're **still stuck in the flying pose** — arms out, gliding — even though you never launched
again. Sometimes you can't walk normally, sometimes you rocket into a wall, sometimes it just looks
broken until you jump or take fall damage to snap out of it.

**flightSync fixes exactly that.** It's a tiny, do-one-thing client mod: the instant you finish a
dimension change, it checks whether the game left you in elytra-glide state and, if so, quietly turns
it off. You land on the other side of the portal standing normally — no phantom flight, no manual
jump to reset it. Install it and forget it's there.

## ✨ Features

- **Kills phantom elytra flight after a portal.** Cross a nether/End portal (or any dimension
  teleport) while gliding, and you arrive on your feet instead of stuck in flight mode.
- **Completely automatic.** No keybind to press, no command to run, no state to manage — it reacts to
  the teleport itself.
- **Client-side only.** It runs entirely on your client, so it works on **any server** — vanilla,
  modded, or a realm — with nothing installed server-side. Other players don't need it.
- **Featherweight.** A single tiny mixin and two empty entrypoints. No new items, blocks, screens,
  or background ticking.
- **Zero dependencies.** Needs only the mod loader itself — no Fabric API, no library mods.

## 🔧 How it works

When you travel between dimensions, the server sends your client a **respawn packet** to rebuild you
in the new world. The client applies it in `ClientPacketListener.handleRespawn`. The long-standing
annoyance is that your **fall-flying (elytra glide) flag can survive that rebuild** — the new world
loads around a player the client still thinks is mid-glide, leaving you visually and mechanically
stuck in flight until something forces a reset.

flightSync attaches a **single mixin** to the tail of `handleRespawn`. After the vanilla code has
finished placing you in the new dimension, it does one check:

```java
if (mc.player != null && mc.player.isFallFlying()) {
    mc.player.stopFallFlying();
}
```

If — and only if — you're still flagged as fall-flying right after the teleport, it clears that
state. That's the entire mod. It doesn't touch normal elytra use (you can launch and glide freely on
either side of the portal), it doesn't cancel flight in mid-air during ordinary play, and it adds no
per-tick logic — it fires once, at the exact moment the bug would otherwise strike.

## 🎛️ Commands & configuration

**None — and that's the point.** There are no commands, no config file, no options screen, and
nothing to tune. Drop the jar in your `mods/` folder and it just works. Both the Fabric and NeoForge
entrypoints are intentionally empty; all the behavior lives in that one mixin.

## 💡 Use cases

- **Elytra highways & portal hubs.** If you routinely glide straight through nether portals to cross
  your world quickly, this removes the little post-portal hitch every single time.
- **Servers you can't mod.** Because it's client-side, it fixes the annoyance on vanilla and
  third-party servers where you can't add server mods.
- **Modpack polish.** A no-config, no-dependency quality-of-life fix that won't conflict with anything
  or add weight to a pack — safe to bundle and forget.

## 📦 Versions &amp; downloads

> [!NOTE]
> This repo uses a **branch-per-version** layout. This `main` branch is **documentation only** — the code for each Minecraft version lives on its own branch, each with an independent history and its own `CHANGELOG.md`.

| Branch | Minecraft | Loaders | Dependencies | Log |
|:------:|:---------:|:-------:|:------------:|:---:|
| [`multi_26.2`](https://github.com/LunixiaLIVE/flightSync/tree/multi_26.2) | 26.2.x | Fabric · NeoForge | None — loader only | [📄](https://github.com/LunixiaLIVE/flightSync/blob/multi_26.2/CHANGELOG.md) |
| [`multi_26.1`](https://github.com/LunixiaLIVE/flightSync/tree/multi_26.1) | 26.1, 26.1.1, 26.1.2 | Fabric · NeoForge | None — loader only | [📄](https://github.com/LunixiaLIVE/flightSync/blob/multi_26.1/CHANGELOG.md) |
| [`multi_1.21`](https://github.com/LunixiaLIVE/flightSync/tree/multi_1.21) | 1.21.x *(spans the 1.21 line)* | Fabric · NeoForge | None — loader only | [📄](https://github.com/LunixiaLIVE/flightSync/blob/multi_1.21/CHANGELOG.md) |

> [!TIP]
> Every `multi_*` branch builds **one jar that runs on both Fabric and NeoForge**. On 26.x that's a shared universal jar (Minecraft is unobfuscated there); on 1.21.x it's a jar-in-jar bundle (`-multi.jar`) with the Fabric and NeoForge builds nested inside, each loader picking its own. Per-loader `-fabric` / `-neoforge` jars are produced too (`build/staging/`). Fully self-contained — **no extra library mods to install**.

<details>
<summary>🛠️ <b>Building from source</b></summary>

Each code branch is a self-contained Gradle project. Grab the branch for your Minecraft version:

```bash
git clone -b multi_26.2 https://github.com/LunixiaLIVE/flightSync.git
cd flightSync
./gradlew build
```

The universal jar lands in `build/libs/` — drop it into your `mods/` folder on either loader.
</details>

## 📄 License

Released under the **MIT License**.

<div align="center"><sub>⛏️ Part of <a href="https://github.com/LunixiaLIVE/Lunixia-Minecraft-QOL-Mods">Lunixia's Minecraft QOL Mods</a>.</sub></div>
