# react-native-root-detection

Detect root on user device

## Installation

```sh
npm install react-native-root-detection
```

## Usage


```js
import { isRootDetected, isDebuggable, isEmulator } from 'react-native-root-detection';

// ...

// Is device rooted or jailbreaked
const isDeviceRooted = isRootDetected();

// On Android: is application debuggable or is debugger connected to application
// On iOS: is debugger attached to application
const isDebuggable = isDebuggable();

// Is application running on emulator/simulator
const isRunningOnEmulator = isEmulator();
```

## License

MIT