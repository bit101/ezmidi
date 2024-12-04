# ezmidi

A simple SuperCollider extension to make connecting to MIDI devices a bit easier.

## Use cases

All of these require `EZMidi.init` or `MIDIClient.init` to be run first to initialize the lists of sources and destinations.

### Initialize the MIDIClient

Internally, just runs `MIDIClient.init` but with more friendly output.

```
EZMidi.init;
```

### Clear out all MIDI connections.

Disconnects all clients and re-initializes `MIDIClient`.

```
EZMidi.reset;
```

### List MIDI sources or destinations, showing the index of each item.

```
EZMidi.srcs;
EZMidi.dsts;
```

Example output for destinations:

```
MIDI destinations:
  0. MIDIEndPoint("Midi Through", "Midi Through Port-0")
  1. MIDIEndPoint("S-1", "S-1 MIDI IN")
  2. MIDIEndPoint("SuperCollider", "in0")
  3. MIDIEndPoint("SuperCollider", "in1")
  4. MIDIEndPoint("SuperCollider", "in2")
  5. MIDIEndPoint("SuperCollider", "in3")
```

### Connect to a MIDIOut destination by its name.

Returns a `MIDIOut` object.

The name is easily found by listing `EZMidi.dsts`.

The default port number is 0, but you can set it manually.

```
m = EZMidi.outByName("My Device Name", port);
```

### Connect to a MIDIOut destination by its index.

Returns a `MIDIOut` object.

The index is easily found by listing `EZMidi.dsts`.

The default port number is 0, but you can set it manually.

```
m = EZMidi.outByIndex(index, port);
```

