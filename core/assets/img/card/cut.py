#! /usr/bin/env python
import cv2

img = cv2.imread('total.jpg')
ix, iy = 11, 13
wx, wy = 74, 74
dx, dy = 25, 14

for i in range(5):
    for j in range(5):
        nx = ix+(wx+dx)*i
        ny = iy+(wy+dy)*j
        card = img[nx:nx+wx, ny:ny+wy]
        card = cv2.resize(card, (128, 128))
        cv2.imwrite('card_%d_%d.bmp'%(i, j), card)
