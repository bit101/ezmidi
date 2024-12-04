# ezmidi

A simple SuperCollider extension to make connecting to MIDI devices a bit easier.

## Use cases

All of these require `MIDIClient.init` to be run first to initialize the lists of sources and destinations.

1. List MIDI sources or destinations, showing the index of each item.

```
EZMidi.srcs;
EZMidi.dsts;
```

2. Connect to a MIDIOut destination by its name.

The name is easily found by listing `EZMidi.dsts`.
The default port number is 0, but you can set it manually.

```
m = EZMidi.outByName("My Device Name", port);
```

2. Connect to a MIDIOut destination by its index.

The index is easil yfound by listing `EZMidi.dsts`.
The default port number is 0, but you can set it manually.

```
m = EZMidi.outByIndex(index, port);
```

3. Clear out all MIDI connections.

```
EZMidi.reset;
```

This will require running `MIDIClient.init` again.


