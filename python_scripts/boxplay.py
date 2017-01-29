#!/usr/bin/env python

import pygame
pygame.mixer.init()
pygame.mixer.music.load("/home/pi/Downloads/work/box03.mp3")
pygame.mixer.music.play()
while pygame.mixer.music.get_busy() == True:
	continue
	
