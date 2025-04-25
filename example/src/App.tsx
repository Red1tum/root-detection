import { useEffect, useState } from 'react';
import { Text, View, StyleSheet } from 'react-native';
import {
  isDebuggable,
  isEmulator,
  isRootDetected,
} from 'react-native-root-detection';

export default function App() {
  const [rooted, setRooted] = useState(false);
  const [debuggable, setDebuggable] = useState(false);
  const [emulator, setEmulator] = useState(false);

  useEffect(() => {
    setRooted(isRootDetected());
    setEmulator(isEmulator());
    setDebuggable(isDebuggable());
  }, []);

  return (
    <View style={styles.container}>
      <Text style={styles.text}>
        Is this phone rooted/jailbreaked: {rooted.toString()}
      </Text>
      <Text style={styles.text}>
        Is application running on emulator: {emulator.toString()}
      </Text>
      <Text style={styles.text}>
        Is application debuggable: {debuggable.toString()}
      </Text>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
    backgroundColor: '#fcb',
  },
  text: {
    fontSize: 20,
  },
});
