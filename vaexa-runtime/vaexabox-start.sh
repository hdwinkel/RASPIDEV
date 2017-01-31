#!/bin/bash

cd ~/Downloads/vaexa-runtime
lxterminal -e ~/Downloads/vaexa-runtime/start_dropwizard.sh &
sleep 20

cd ~/Downloads/python_scripts

lxterminal -e ~/Downloads/python_scripts/button-post.sh &
sleep 10

lxterminal -e ~/Downloads/python_scripts/post-manned.sh &
sleep 5

lxterminal -e ~/Downloads/python_scripts/get-count-loop.sh &
sleep 5

lxterminal -e ~/Downloads/python_scripts/LCDDisplay.sh &
sleep 5

lxterminal -e ~/Downloads/python_scripts/ultrasonic-post.sh &
sleep 5

