EZMidi {

  *srcs {
    "MIDI sources:".postln;
    MIDIClient.sources.do({
      | name, index |
      postf("  %. %\n", index, name);
    });
  }

  *dsts {
    "MIDI destinations:".postln;
    MIDIClient.destinations.do({
      | name, index |
      postf("  %. %\n", index, name);
    });
  }

  *reset {
    MIDIClient.disposeClient
  }

  *outByName {
    |name, outPort = 0|
    var client, out;
    client = MIDIClient.destinations.detect({|e| e.device == name});
    if (client != nil, {
      out = MIDIOut.new(outPort, client.uid);
      if(thisProcess.platform.name == \linux, {
        out.connect(client.uid);
      }, {
        out.connect();
      });
      postf("MIDI device \"%\" is set up!\n", name);
    }, {
      postf("Could not find MIDI device \"%\".\n", name);
    });
    ^out;
  }

  *outByIndex {
    | index, outPort=0 |
    var client, out;
    client = MIDIClient.destinations[index];
    if (client != nil, {
      out = MIDIOut.new(outPort, client.uid);
      if(thisProcess.platform.name == \linux, {
        out.connect(client.uid);
      }, {
        out.connect();
      });
      postf("MIDI device \"%\" is set up!\n", name);
    }, {
      postf("Could not find MIDI device \"%\".\n", name);
    });
    ^out;
  }
}
