package com.rootdetection

import android.util.Log
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.module.annotations.ReactModule
import com.scottyab.rootbeer.RootBeer

@ReactModule(name = RootDetectionModule.NAME)
class RootDetectionModule(reactContext: ReactApplicationContext) :
  NativeRootDetectionSpec(reactContext) {

  private val rootBeer = RootBeer(reactContext)

  override fun getName(): String {
    return NAME
  }

  override fun isRootDetected(): Boolean {
    val isRooted = rootBeer.isRooted
    Log.d("RootDetectionModule", "Is rooted: ${isRooted}")
    return isRooted
  }

  companion object {
    const val NAME = "RootDetection"
  }
}
