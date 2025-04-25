import RootDetection from './NativeRootDetection';

export function isRootDetected(): boolean {
  return RootDetection.isRootDetected();
}

export function isEmulator(): boolean {
  return RootDetection.isEmulator();
}

export function isDebuggable(): boolean {
  return RootDetection.isDebuggable();
}
