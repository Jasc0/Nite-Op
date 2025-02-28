/*
 *  This sketch demonstrates how to scan WiFi networks.
 *  The API is based on the Arduino WiFi Shield library, but has significant changes as newer WiFi functions are supported.
 *  E.g. the return value of `encryptionType()` different because more modern encryption is supported.
 */
#include "HardwareSerial.h"


void setup() {
  Serial.begin(115200);

  Serial.println("Setup done");
}

void loop() {
  int val;
  val = analogRead(36);
  Serial.print(val);
    Serial.print("\n");
  delay(100);
}
