import type { TurboModule } from 'react-native';
import { TurboModuleRegistry } from 'react-native';

export interface Spec extends TurboModule {
  isRootDetected(): boolean;
  isDebuggable(): boolean;
  isEmulator(): boolean;
}

export default TurboModuleRegistry.getEnforcing<Spec>('RootDetection');
