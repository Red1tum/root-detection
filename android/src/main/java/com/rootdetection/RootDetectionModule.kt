package com.rootdetection

import android.annotation.SuppressLint
import android.content.pm.ApplicationInfo
import android.os.Build
import android.os.Debug
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.module.annotations.ReactModule
import com.scottyab.rootbeer.RootBeer
import java.util.Locale

@ReactModule(name = RootDetectionModule.NAME)
class RootDetectionModule(reactContext: ReactApplicationContext) :
  NativeRootDetectionSpec(reactContext) {

  private val rootBeer = RootBeer(reactContext)

  override fun getName(): String {
    return NAME
  }

  override fun isRootDetected(): Boolean {
    val isRooted = rootBeer.isRooted
    return isRooted
  }

  override fun isDebuggable(): Boolean {
    val isAppDebuggable = (reactApplicationContext.applicationInfo.flags and ApplicationInfo.FLAG_DEBUGGABLE) != 0
    val isDebuggerAttached = Debug.isDebuggerConnected()
    return isAppDebuggable || isDebuggerAttached
  }

  @SuppressLint("HardwareIds")
  override fun isEmulator(): Boolean {
    return Build.FINGERPRINT.startsWith("generic")
      || Build.FINGERPRINT.startsWith("unknown")
      || Build.MODEL.contains("google_sdk")
      || Build.MODEL.lowercase(Locale.ROOT).contains("droid4x")
      || Build.MODEL.contains("Emulator")
      || Build.MODEL.contains("Android SDK built for x86")
      || Build.MANUFACTURER.contains("Genymotion")
      || Build.HARDWARE.contains("goldfish")
      || Build.HARDWARE.contains("ranchu")
      || Build.HARDWARE.contains("vbox86")
      || Build.PRODUCT.contains("sdk")
      || Build.PRODUCT.contains("google_sdk")
      || Build.PRODUCT.contains("sdk_google")
      || Build.PRODUCT.contains("sdk_x86")
      || Build.PRODUCT.contains("vbox86p")
      || Build.PRODUCT.contains("emulator")
      || Build.PRODUCT.contains("simulator")
      || Build.BOARD.lowercase(Locale.ROOT).contains("nox")
      || Build.BOOTLOADER.lowercase(Locale.ROOT).contains("nox")
      || Build.HARDWARE.lowercase(Locale.ROOT).contains("nox")
      || Build.PRODUCT.lowercase(Locale.ROOT).contains("nox")
      || Build.SERIAL.lowercase(Locale.ROOT).contains("nox")
      || (Build.BRAND.startsWith("generic") && Build.DEVICE.startsWith("generic"))
  }

  companion object {
    const val NAME = "RootDetection"
  }
}
