# PvP Refined

A client-side Fabric mod for Minecraft 1.21.1 that fixes common vanilla bugs, resolves client-server desync issues, and provides visual Quality of Life (QoL) improvements for competitive PvP and Prison servers.

## Features

### Mining & Desync Fixes
- **Ghost Block Fix**: Prevents walking through blocks that are broken client-side but not yet confirmed by the server
- **Container Desync Fix**: Prevents items from glitching back into inventory when moving them quickly between chest and player inventory

### Combat Input Fixes
- **Visual Shield Sync**: Delays shield animation to match the exact moment the server registers the block
- **Fast Switch Input Buffer**: Buffers right-click input when switching to shield/trident for reliable blocking
- **Trident/Spear Deadlock Fix**: Detects stuck charging animations and forces reset after maximum charge time

### Visual QoL
- **Low Fire**: Reduces fire overlay height to prevent blocking the crosshair
- **Small Totem Pop**: Scales down Totem of Undying animation
- **Explosion Flash Reduction**: Reduces white flash from explosions for better visibility
- **Transparent Chat Background**: Reduces chat background opacity to see enemies behind the chat

## Safety

✅ **Completely safe for strict anti-cheat servers** (Vulcan, Grim, etc.)

This mod:
- Contains NO attack reach modifications
- Does NOT automate clicks
- Does NOT bypass cooldowns
- Does NOT alter movement logic
- Only provides client-side visual corrections and synchronization improvements

## Installation

1. Install [Fabric Loader](https://fabricmc.net/use/) for Minecraft 1.21.1
2. Download the latest release of PvP Refined
3. Place the mod JAR in your `mods` folder
4. Launch Minecraft with the Fabric profile

## Configuration

Each feature can be toggled individually in the mod settings:
- Press ESC → Mods → PvP Refined → Configure
- Or edit `config/pvprefined/pvprefined.json` directly

### Default Configuration

```json
{
  "enabled": true,
  "miningDesync": {
    "ghostBlockFix": true,
    "containerDesyncFix": true
  },
  "combatInput": {
    "shieldVisualSync": true,
    "fastSwitchBuffer": true,
    "tridentDeadlockFix": true
  },
  "visualQoL": {
    "lowFire": true,
    "fireHeightMultiplier": 0.6,
    "smallTotemPop": true,
    "totemScaleMultiplier": 0.7,
    "explosionFlashReduction": true,
    "explosionFlashAlpha": 0.3,
    "transparentChatBackground": true,
    "chatBackgroundAlpha": 0.2
  }
}
```

## Dependencies

- Fabric API
- Cloth Config (for configuration GUI)
- Architectury (for Cloth Config)
- Mod Menu (optional, for easier configuration access)

## Building

```bash
./gradlew build
```

The compiled JAR will be in `build/libs/`

## Compatibility

- **Minecraft**: 1.21.1
- **Fabric Loader**: 0.16.5+
- **Fabric API**: Latest stable for 1.21.1

## License

MIT License - See LICENSE file for details

## Support

For issues, feature requests, or questions, visit the [GitHub repository](https://github.com/ItsN4x/PvP-Refined)
