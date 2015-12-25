#! /usr/bin/env python
import numpy as np
import cv2

colors = [0x000000,
          0x964B00,
          0xFF0000,
          0xFFA500,
          0xFFFF00,
          0x9ACD32,
          0x6495ED,
          0xEE82EE,
          0xA0A0A0,
          0xFFFFFF]

size = 64
img = np.ndarray((size, size*len(colors), 3))
for i in xrange(len(colors)):
    color = [colors[i]%256, colors[i]/256%256, colors[i]/256/256%256]
    img[:,i*size:(i+1)*size,:] = color
cv2.imwrite('color.bmp', img)
