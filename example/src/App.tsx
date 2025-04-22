import { useEffect, useState } from 'react';
import { Text, View, StyleSheet } from 'react-native';
import { isRootDetected } from 'react-native-root-detection';

export default function App() {
  const [rooted, setRooted] = useState(false);
  useEffect(() => {
    setRooted(isRootDetected());
  }, []);
  return (
    <View style={styles.container}>
      <Text>Is this phone rooted/jailbreaked: {rooted.toString()}</Text>
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
});
