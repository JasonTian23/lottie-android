package com.airbnb.lottie;

import org.json.JSONObject;

class ShapePath {
  private final String name;
  private final int index;
  private final AnimatableShapeValue shapePath;

  private ShapePath(String name, int index, AnimatableShapeValue shapePath) {
    this.name = name;
    this.index = index;
    this.shapePath = shapePath;
  }

  static class Factory {
    static ShapePath newInstance(JSONObject json, LottieComposition composition) {
      return new ShapePath(json.optString("nm"), json.optInt("ind"),
          new AnimatableShapeValue(json.optJSONObject("ks"), composition));
    }
  }

  AnimatableShapeValue getShapePath() {
    return shapePath;
  }

  @Override public String toString() {
    return "ShapePath{" + "name=" + name +
        ", index=" + index +
        ", hasAnimation=" + shapePath.hasAnimation() +
        '}';
  }
}