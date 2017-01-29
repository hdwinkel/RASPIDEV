#!/usr/bin/python
# Verwenden von GPIO
import RPi.GPIO as GPIO

ledpin=31
buttonpin=29

# Warnungen ausschalten
#GPIO.setwarnings(False)
# Pin Nummern verwenden
GPIO.setmode(GPIO.BOARD)
# Pin 11 als Input
GPIO.setup(buttonpin, GPIO.IN)
# Pin 12 als Output
GPIO.setup(ledpin, GPIO.OUT)

# Endlosschleife
while True:
  # Solange Button nicht gedrueckt wird (False)
  if not GPIO.input(buttonpin):
    GPIO.output(ledpin, True)
  # Wenn der Button gedrueckt wird
  else:
    GPIO.output(ledpin, False)

GPIO.cleanup() 



